package com.fjh.fxrecylerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */

public class RecyListActivity extends Activity{
    private Context context;
    private RecyclerView recy;
    private List<String> mDatas;
    private SimpleAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview);
        context=RecyListActivity.this;
        initview();
        initDatas();
        setview();
    }

    private void initview() {
        recy= (RecyclerView) findViewById(R.id.recy);
    }

    /**
     * 模拟数据
     */
    private void initDatas() {
        mDatas=new ArrayList<>();
        for (int i='A';i<='z';i++){
            mDatas.add(""+(char)i);
        }

    }
    private void setview() {
        mAdapter=new SimpleAdapter(this,mDatas);
        recy.setAdapter(mAdapter);
        recy.setItemAnimator(new DefaultItemAnimator());
        //设置布局样式
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recy.setLayoutManager(linearLayoutManager);
        mAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(context,mDatas.get(position),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }
}
