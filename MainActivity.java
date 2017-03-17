package com.fjh.fxrecylerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Context content;
    private Button recy_list;
    private Button recy_radio;
    private Button recy_water;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content=MainActivity.this;
        initview();
    }

    /**
     * 初始化控件
     */
    private void initview() {
        recy_list= (Button) findViewById(R.id.recy_list);
        recy_radio= (Button) findViewById(R.id.recy_radio);
        recy_water= (Button) findViewById(R.id.recy_water);
        recy_list.setOnClickListener(this);
        recy_radio.setOnClickListener(this);
        recy_water.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.recy_list:
                Intent intent=new Intent(content,RecyListActivity.class);
                startActivity(intent);
                break;
            case R.id.recy_radio:
                intent=new Intent(content,RecyRadioActivity.class);
                startActivity(intent);
                break;
            case R.id.recy_water:
                intent=new Intent(content,WaterFallActivity.class);
                startActivity(intent);
                break;
        }
    }


}
