package com.jsqix.dongqing.multitype.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jsqix.dongqing.multitype.R;
import com.jsqix.dongqing.multitype.data.bean.HeaderBean;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by dongqing on 2017/2/10.
 */

public class HeaderViewProvider extends ItemViewProvider<HeaderBean, HeaderViewProvider.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_header, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HeaderBean headerBean) {
        holder.content.setText(headerBean.getTitle());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView content;

        ViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
