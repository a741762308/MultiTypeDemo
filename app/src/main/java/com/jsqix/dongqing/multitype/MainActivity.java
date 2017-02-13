package com.jsqix.dongqing.multitype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.jsqix.dongqing.multitype.data.Data;
import com.jsqix.dongqing.multitype.data.bean.FuliBean;
import com.jsqix.dongqing.multitype.data.bean.GankData;
import com.jsqix.dongqing.multitype.data.bean.HeaderBean;
import com.jsqix.dongqing.multitype.data.bean.ImgDataBean;
import com.jsqix.dongqing.multitype.provider.FuliViewProvider;
import com.jsqix.dongqing.multitype.provider.HeaderViewProvider;
import com.jsqix.dongqing.multitype.provider.ImageViewProvider;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {
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
    adapter.register(HeaderBean.class, new HeaderViewProvider());
    adapter.register(ImgDataBean.class, new ImageViewProvider());
    recyclerView.setAdapter(adapter);
    Gson gson = new Gson();
    if (gank.getResults() != null) {
        if (gank.getResults().get福利() != null && gank.getResults().get福利().size() > 0) {
            ImgDataBean img = gank.getResults().get福利().get(0);
            FuliBean bean = gson.fromJson(gson.toJson(img), FuliBean.class);
            items.add(bean);
        }
        if (gank.getResults().getAndroid() != null && gank.getResults().getAndroid().size() > 0) {
            items.add(new HeaderBean("Android"));
            items.addAll(gank.getResults().getAndroid());
        }
        if (gank.getResults().getiOS() != null && gank.getResults().getiOS().size() > 0) {
            items.add(new HeaderBean("iOS"));
            items.addAll(gank.getResults().getiOS());
        }
        if (gank.getResults().get前端() != null && gank.getResults().get前端().size() > 0) {
            items.add(new HeaderBean("前端"));
            items.addAll(gank.getResults().get前端());
        }
        if (gank.getResults().get瞎推荐() != null && gank.getResults().get瞎推荐().size() > 0) {
            items.add(new HeaderBean("瞎推荐"));
            items.addAll(gank.getResults().get瞎推荐());
        }
        if (gank.getResults().get拓展资源() != null && gank.getResults().get拓展资源().size() > 0) {
            items.add(new HeaderBean("拓展资源"));
            items.addAll(gank.getResults().get拓展资源());
        }
        if (gank.getResults().get休息视频() != null && gank.getResults().get休息视频().size() > 0) {
            items.add(new HeaderBean("休息视频"));
            items.addAll(gank.getResults().get休息视频());
        }
    }
    adapter.setItems(items);
    adapter.notifyDataSetChanged();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.more) {
            startActivity(new Intent(this, CardActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
