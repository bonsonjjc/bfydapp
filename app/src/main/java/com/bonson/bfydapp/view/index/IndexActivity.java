package com.bonson.bfydapp.view.index;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.view.View;

import com.bonson.bfydapp.R;
import com.bonson.bfydapp.databinding.ActivityMainBinding;
import com.bonson.resource.activity.BaseDaggerActivity;
import com.bonson.resource.utils.AdapterDataChangeFactory;

import javax.inject.Inject;

public class IndexActivity extends BaseDaggerActivity<ActivityMainBinding> {
    @Inject
    IndexViewModel viewModel;
    @Inject
    MenuAdapter menuAdapter;

    @Inject
    TableAdapter tableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBindingLayout(R.layout.activity_main);
        binding.setViewModel(viewModel);
        binding.getRoot().setBackgroundColor(color(R.color.theme));
        setViewModel(viewModel);
        binding.recMenus.setAdapter(menuAdapter);
        binding.recTables.setAdapter(tableAdapter);
        binding.recTables.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        new PagerSnapHelper().attachToRecyclerView(binding.recTables);
        AdapterDataChangeFactory.create(menuAdapter).attach(viewModel.menus);
        AdapterDataChangeFactory.create(tableAdapter).attach(viewModel.tables);
        binding.drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View menu, float slideOffset) {
                int m = menu.getRight() < binding.content.getRight() ? 1 : -1;
                binding.content.setTranslationX(slideOffset * menu.getWidth() * m);
            }
        });
        binding.rgType.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_bind:
                    if (viewModel.mode.get() == 1) {
                        viewModel.mode.set(2);
                    }
                    break;
                default:
                    if (viewModel.mode.get() != 1) {
                        viewModel.mode.set(1);
                    }
            }
        });
        binding.rgActionGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_yd:
                    viewModel.motion();
                    binding.mv.moving(1234 + "", "0公里 | 0千卡", 100);
                    binding.getRoot().setBackgroundColor(color(R.color.theme));
                    break;
                case R.id.rb_sm:
                    viewModel.sleep();
                    binding.mv.sleeping(1234 + "", "昨晚共睡眠0分钟", 100);
                    binding.getRoot().setBackgroundColor(color(R.color.theme_sm));
                    break;
                case R.id.rb_xl:
                    viewModel.heart();
                    binding.getRoot().setBackgroundColor(color(R.color.theme_heart));
                    binding.mv.hearting(90 + "", "心率正常");
                    break;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
