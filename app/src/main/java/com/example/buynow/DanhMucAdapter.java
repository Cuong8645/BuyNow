package com.example.buynow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DanhMucAdapter extends BaseAdapter {

    Context danhmuContext;
    int danhmucLayout;
    List<DanhMuc> arrayDdanhmuc;

    public DanhMucAdapter(Context context, int layout, List<DanhMuc> danhMucList) {
        danhmuContext = context;
        danhmucLayout = layout;
        arrayDdanhmuc = danhMucList;
    }

    @Override
    public int getCount() {
        return arrayDdanhmuc.size();
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
        LayoutInflater inflater = (LayoutInflater) danhmuContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(danhmucLayout , null);

        TextView txtTen = (TextView) convertView.findViewById(R.id.txtTen);
        txtTen.setText(arrayDdanhmuc.get(position).Ten);
        TextView txtSoLuong = (TextView) convertView.findViewById(R.id.txtSoLuong);
        txtSoLuong.setText(arrayDdanhmuc.get(position).SoLuong+"");
        ImageView imgHinh = (ImageView) convertView.findViewById(R.id.imgDanhmuc);
        imgHinh.setImageResource(arrayDdanhmuc.get(position).Hinh);

        return convertView;
    }
}
