package com.jsqix.dongqing.multitype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.jsqix.dongqing.multitype.data.Data;
import com.jsqix.dongqing.multitype.data.bean.FuliBean;
import com.jsqix.dongqing.multitype.data.bean.GankData;
import com.jsqix.dongqing.multitype.data.bean.HeaderBean;
import com.jsqix.dongqing.multitype.data.bean.ImgDataBean;
import com.jsqix.dongqing.multitype.data.bean.RecentBean;
import com.jsqix.dongqing.multitype.provider.FuliViewProvider;
import com.jsqix.dongqing.multitype.provider.RecentViewProvider;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;


public class CardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Items items;
    private MultiTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
    }

    private void iniView() {
        GankData gank = new Gson().fromJson(Data.Gank, GankData.class);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        items = new Items();
        adapter = new MultiTypeAdapter();
        adapter.register(FuliBean.class, new FuliViewProvider());
        adapter.register(RecentBean.class, new RecentViewProvider());
        recyclerView.setAdapter(adapter);
        Gson gson = new Gson();
        if (gank.getResults() != null) {
            if (gank.getResults().get福利() != null && gank.getResults().get福利().size() > 0) {
                ImgDataBean img = gank.getResults().get福利().get(0);
                FuliBean bean = gson.fromJson(gson.toJson(img), FuliBean.class);
                items.add(bean);
            }
            if (gank.getResults().getAndroid() != null && gank.getResults().getAndroid().size() > 0) {
                RecentBean bean = new RecentBean();
                bean.setHeaderBean(new HeaderBean("Android"));
                bean.setList(gank.getResults().getAndroid());
                items.add(bean);
            }
            if (gank.getResults().getiOS() != null && gank.getResults().getiOS().size() > 0) {
                RecentBean bean = new RecentBean();
                bean.setHeaderBean(new HeaderBean("iOS"));
                bean.setList(gank.getResults().getiOS());
                items.add(bean);
            }
            if (gank.getResults().get前端() != null && gank.getResults().get前端().size() > 0) {
                RecentBean bean = new RecentBean();
                bean.setHeaderBean(new HeaderBean("前端"));
                bean.setList(gank.getResults().get前端());
                items.add(bean);
            }
            if (gank.getResults().get瞎推荐() != null && gank.getResults().get瞎推荐().size() > 0) {
                RecentBean bean = new RecentBean();
                bean.setHeaderBean(new HeaderBean("瞎推荐"));
                bean.setList(gank.getResults().get瞎推荐());
                items.add(bean);
            }
            if (gank.getResults().get拓展资源() != null && gank.getResults().get拓展资源().size() > 0) {
                RecentBean bean = new RecentBean();
                bean.setHeaderBean(new HeaderBean("拓展资源"));
                bean.setList(gank.getResults().get拓展资源());
                items.add(bean);
            }
            if (gank.getResults().get休息视频() != null && gank.getResults().get休息视频().size() > 0) {
                RecentBean bean = new RecentBean();
                bean.setHeaderBean(new HeaderBean("休息视频"));
                bean.setList(gank.getResults().get休息视频());
                items.add(bean);
            }
        }
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(0);
    }
}
