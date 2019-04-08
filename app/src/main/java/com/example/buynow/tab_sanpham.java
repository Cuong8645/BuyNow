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

public class tab_sanpham extends Fragment {
    @Nullable
    ListView listView;
    ArrayList<SanPham> mangSanPham;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_sanpham, container, false);


        listView = (ListView) view.findViewById(R.id.lvsanpham);
        mangSanPham = new ArrayList<SanPham>();
        mangSanPham.add(new SanPham("Xperia",10000000, R.drawable.images, 4));
        mangSanPham.add(new SanPham("Sony",15000000, R.drawable.images, 5));
        mangSanPham.add(new SanPham("Asus",8000000, R.drawable.images, 4));
        mangSanPham.add(new SanPham("Apple",20000000, R.drawable.images, 4));

        SanPhamAdapter arrayAdapter = new SanPhamAdapter(getActivity(), R.layout.listview_sanpham, mangSanPham);
        listView.setAdapter(arrayAdapter);
        return view;
    }
}
