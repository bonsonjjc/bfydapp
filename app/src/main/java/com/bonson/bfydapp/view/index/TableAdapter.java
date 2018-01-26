package com.bonson.bfydapp.view.index;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.bonson.bfydapp.R;
import com.bonson.bfydapp.databinding.ItemTableBinding;
import com.bonson.resource.adapter.BaseAdapter;
import com.bonson.resource.adapter.ViewHolder;

import javax.inject.Inject;


public class TableAdapter extends BaseAdapter<Table, ItemTableBinding> {
    @Inject
    public TableAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder<ItemTableBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTableBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_table, parent, false);
        return new ViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder<ItemTableBinding> holder, int position) {
        ItemTableBinding binding = holder.getBinding();
        Table table = beans.get(position);
        binding.setTable(table);
        binding.executePendingBindings();
    }
}
