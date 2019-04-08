package com.example.buynow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Box_chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.box_chat_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Box Chat"); //Thiết lập tiêu đề nếu muốn
        String title = actionBar.getTitle().toString(); //Lấy tiêu đề nếu muốn
    }
}
