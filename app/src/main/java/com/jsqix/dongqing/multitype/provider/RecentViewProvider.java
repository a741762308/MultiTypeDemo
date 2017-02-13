package com.jsqix.dongqing.multitype.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jsqix.dongqing.multitype.R;
import com.jsqix.dongqing.multitype.data.bean.HeaderBean;
import com.jsqix.dongqing.multitype.data.bean.ImgDataBean;
import com.jsqix.dongqing.multitype.data.bean.RecentBean;

import me.drakeet.multitype.ItemViewProvider;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by dongqing on 2017/2/10.
 */

public class RecentViewProvider extends ItemViewProvider<RecentBean, RecentViewProvider.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root=inflater.inflate(R.layout.item_cardview,parent,false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull RecentBean recentBean) {
        Items items = new Items();
        items.add(recentBean.getHeaderBean());
        items.addAll(recentBean.getList());
        holder.setData(items);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private MultiTypeAdapter adapter;

        ViewHolder(View itemView) {
            super(itemView);
            RecyclerView recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new MultiTypeAdapter();
            adapter.register(HeaderBean.class, new HeaderViewProvider());
            adapter.register(ImgDataBean.class, new ImageViewProvider());
            recyclerView.setAdapter(adapter);
        }

        private void setData(Items items) {
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    }
}
