package com.feima.statusbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView mListWidget;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mListWidget.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new String[]{"沉浸式", "改变状态栏"}));
        mListWidget.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) mListWidget.getItemAtPosition(position);
                if ("改变状态栏".equals(str)) {
                    startActivity(new Intent(MainActivity.this, StatusBarChangeActivity.class));
                } else if ("沉浸式".equals(str)) {
                    startActivity(new Intent(MainActivity.this, ImmersiveStatusBarActivity.class));
                }
            }
        });
    }

    private void initView() {
        mListWidget = (ListView) findViewById(R.id.list_widget);
    }
}
