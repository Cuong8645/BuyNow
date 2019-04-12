package com.example.buynow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TaoCuaHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tao_cua_hang_layout);

        getSupportActionBar().setTitle("Tạo cửa hàng");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
