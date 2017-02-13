package com.jsqix.dongqing.multitype.provider;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jsqix.dongqing.multitype.R;
import com.jsqix.dongqing.multitype.data.bean.FuliBean;

import java.text.SimpleDateFormat;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by dongqing on 2017/2/10.
 */

public class FuliViewProvider extends ItemViewProvider<FuliBean, FuliViewProvider.ViewHolder> {
    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_fuli, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull FuliBean fuliBean) {
        Glide.with(holder.image.getContext()).load(fuliBean.getUrl()).crossFade().centerCrop().into(holder.image);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        holder.time.setText(df.format(fuliBean.getPublishedAt()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView time;

        ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            time = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
