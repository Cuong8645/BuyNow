package com.example.buynow;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

public class ChiTietSanPhamActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Animation in,out;
    ImageButton btnnext,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chi_tiet_san_pham_layout);
        btnback = (ImageButton)findViewById(R.id.btnback);
        btnnext = (ImageButton)findViewById(R.id.btnnext);


        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);
        in = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        out = AnimationUtils.loadAnimation(this,R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(10000);
        viewFlipper.setAutoStart(true);

        //chuyen hinh dai dien thanh hinh tron
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.a);
        Bitmap circularBitmap = CircleImageActivity.getRoundedCornerBitmap(bitmap,100);



        //su kien cho button
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewFlipper.isAutoStart()){
                    viewFlipper.stopFlipping();
                    viewFlipper.showNext();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewFlipper.isAutoStart()){
                    viewFlipper.stopFlipping();
                    viewFlipper.showPrevious();
                    viewFlipper.startFlipping();
                    viewFlipper.setAutoStart(true);
                }
            }
        });
    }
}
