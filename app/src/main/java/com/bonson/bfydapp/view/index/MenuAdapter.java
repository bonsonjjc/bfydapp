package com.bonson.bfydapp.view.index;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.bonson.bfydapp.R;
import com.bonson.bfydapp.databinding.ItemMenuBinding;
import com.bonson.bfydapp.model.bean.Menu;
import com.bonson.resource.adapter.BaseAdapter;
import com.bonson.resource.adapter.ViewHolder;

import javax.inject.Inject;

/**
 * Created by zjw on 2018/1/3.
 */

public class MenuAdapter extends BaseAdapter<Menu, ItemMenuBinding> {

    @Inject
    public MenuAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder<ItemMenuBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMenuBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_menu, parent, false);
        return new ViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder<ItemMenuBinding> holder, int position) {
        Menu menu = beans.get(position);
        holder.getBinding().setMenu(menu);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(v -> {
            if (null != onItemClickListener) {
                onItemClickListener.itemClick(position);
            }
        });
    }
}
