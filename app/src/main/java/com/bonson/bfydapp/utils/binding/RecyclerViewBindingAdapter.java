package com.bonson.bfydapp.utils.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;

import com.bonson.bfydapp.model.bean.Menu;
import com.bonson.bfydapp.view.index.MenuAdapter;
import com.bonson.bfydapp.view.index.Table;
import com.bonson.bfydapp.view.index.TableAdapter;
import com.bonson.bfydapp.widget.DividerItemDecoration;

import java.util.List;

/**
 * Created by zjw on 2018/1/5.
 */
public class RecyclerViewBindingAdapter {

    @BindingAdapter("android:divider")
    public static void setDivider(RecyclerView recyclerView, Drawable drawable) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @BindingAdapter("android:menus")
    public static void setMenus(RecyclerView recyclerView, List<Menu> menus) {
        MenuAdapter adapter = (MenuAdapter) recyclerView.getAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setBeans(menus);
    }

    @BindingAdapter("android:tables")
    public static void setTables(RecyclerView recyclerView, List<Table> tables) {
        TableAdapter adapter = (TableAdapter) recyclerView.getAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setBeans(tables);
    }
}
