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
import com.jsqix.dongqing.multitype.data.bean.ImgDataBean;

import me.drakeet.multitype.ItemViewProvider;

/**
 * Created by dongqing on 2017/2/10.
 */

public class ImageViewProvider extends ItemViewProvider<ImgDataBean,ImageViewProvider.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_image, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull ImgDataBean dataBean) {
        holder.content.setText(dataBean.getDesc());
        if(dataBean.getImages()!=null&&dataBean.getImages().size()>0){
            holder.image.setVisibility(View.VISIBLE);
            Glide.with(holder.image.getContext()).load(dataBean.getImages().get(0)).crossFade().centerCrop().into(holder.image);
        }else{
            holder.image.setVisibility(View.GONE);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView content;
        private ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
