package com.example.buynow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DanhSachSanPhamActivity extends AppCompatActivity {

    int[] IMAGE = {R.drawable.product1,R.drawable.product2};
    String [] NAMES = {"Sản phẩm: Xperia XZ1", "Sản phẩm: Sony alpha 7 mark III"};
    String[] DESCRIPTIONS = {"Giá: 6,300,000", "Giá: 35,000,000"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham);
        ListView listView = (ListView)findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGE.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            TextView textView_name = (TextView)findViewById(R.id.textView_name);
            TextView textView_description = (TextView)findViewById(R.id.textView_description);
            RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);

            imageView.setImageResource(IMAGE[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);
            return view;
        }
    }
}
