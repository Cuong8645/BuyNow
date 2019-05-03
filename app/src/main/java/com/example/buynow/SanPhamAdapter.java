package com.example.buynow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {

    Context sanphamContext;
    int sanphamLayout;
    List<SanPham> arraysanpham;

    public SanPhamAdapter(Context context, int layout , List<SanPham> sanPhamList){
        sanphamContext = context;
        sanphamLayout = layout;
        arraysanpham = sanPhamList;
    }

    @Override
    public int getCount() {
        return arraysanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) sanphamContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(sanphamLayout , null);

        TextView txtTen = (TextView) convertView.findViewById(R.id.txtTen);
        txtTen.setText(arraysanpham.get(position).Ten);
        TextView txtGia = (TextView) convertView.findViewById(R.id.txtGia);
        txtGia.setText(arraysanpham.get(position).Gia+"");
        TextView txtRate = (TextView) convertView.findViewById(R.id.txtRate);
        txtRate.setText(arraysanpham.get(position).Rate+"");
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imgSanPham);
        imgHinh.setImageResource(arraysanpham.get(position).Hinh);

        return convertView;
    }
}
