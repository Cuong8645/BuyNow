package com.example.buynow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tab_danhmuc extends Fragment {
    @Nullable
    ListView listView;
    ArrayList<DanhMuc> mangDanhmuc;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_danhmuc, container , false);

        listView = (ListView) view.findViewById(R.id.lvdanhmuc);
        mangDanhmuc = new ArrayList<DanhMuc>();

        mangDanhmuc.add(new DanhMuc("Điện Thoại",7,R.drawable.images));
        mangDanhmuc.add(new DanhMuc("Laptop",3,R.drawable.images));
        mangDanhmuc.add(new DanhMuc("Máy ảnh",4,R.drawable.images));

        DanhMucAdapter arrayAdapter = new DanhMucAdapter(getActivity(),R.layout.listview_danhmuc,mangDanhmuc);

        listView.setAdapter(arrayAdapter);

        return  view;
    }
}
