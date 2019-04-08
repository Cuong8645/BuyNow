package vn.edu.tdc.chuyendedidong;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.tdc.chuyendedidong.adapter.RecyclerViewAdapter;
import vn.edu.tdc.chuyendedidong.data_models.Product;

public class MH3_Activity extends AppCompatActivity {

    // Set Spinner
    private Spinner spinNew;
    private Spinner spinArea;
    private Spinner spinPrice;

    //List Product
    List<Product> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh3);

        //Adđ danh sách sản phẩm
        listProduct = new ArrayList<>();
        //int ID_Image, String nameProduct, double price
        listProduct.add(new Product(R.drawable.samsung_galaxy_s10,"Điện thoại Samsung Galaxy S10",20990000));
        listProduct.add(new Product(R.drawable.iphone_x_256gb,"Điện thoại iPhone X 256GB",27990000));
        listProduct.add(new Product(R.drawable.oppo_find_x2,"Điện thoại OPPO Find X",19990000));
        listProduct.add(new Product(R.drawable.proddk_min,"Điện thoại Huawei P30 Pro",17990000));
        listProduct.add(new Product(R.drawable.iphone_xr_128gb_blue,"Điện thoại iPhone Xr 128GB",21990000));
        listProduct.add(new Product(R.drawable.xiaomi_mi_8,"Điện thoại Xiaomi Mi 8",11990000));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, listProduct);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(myAdapter);


        Toolbar toolbarDetail = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbarDetail);
        ActionBar actionBar = getSupportActionBar();

        // Loại bỏ tiêu đề mặc định
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Chuyển màn hình
        toolbarDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MH3_Activity.this, MH1_MH2_Activity.class);
                startActivity(intent);
            }
        });


        spinNew = (Spinner) findViewById(R.id.spinNew);
        spinArea = (Spinner) findViewById(R.id.spinArea);
        spinPrice = (Spinner) findViewById(R.id.spinPrice);


        // Set dữ liệu cho Spinner New
        List<String> listNew = new ArrayList<>();
        listNew.add("Mới nhất");
        listNew.add("Cũ nhất");
        ArrayAdapter<String> adapterNew = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listNew);
        adapterNew.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinNew.setAdapter(adapterNew);
        spinNew.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Set dữ liệu cho Spinner Area
        List<String> listArea = new ArrayList<>();
        listArea.add("Khu Vực");
        listArea.add("Toàn quốc");
        listArea.add("TP Hồ Chí Minh");
        listArea.add("Hà Nội");
        listArea.add("Đà Nẵng");
        listArea.add("Cần Thơ");
        listArea.add("Bình Dương");
        listArea.add("An Giang");
        listArea.add("Bà Rịa - Vũng Tàu");
        listArea.add("Bắc Giang");
        listArea.add("Bắc Kạn");
        listArea.add("Bạc Liêu");
        listArea.add("Bắc Ninh");
        listArea.add("Bến Tre");
        listArea.add("Bình Định");
        listArea.add("Bình Phước");
        listArea.add("Bình Thuận");
        listArea.add("Cà Mau");
        listArea.add("Cao Bằng");
        listArea.add("Đắk Lắk");
        listArea.add("Đắk Nông");
        listArea.add("Điện Biên");
        listArea.add("Đồng Nai");
        listArea.add("Đồng Tháp");
        listArea.add("Gia Lai");
        listArea.add("Hà Giang");
        listArea.add("Hà Nam");
        listArea.add("Hà Tĩnh");
        listArea.add("Hải Dương");
        listArea.add("Hải Phòng");
        listArea.add("Hậu Giang");
        listArea.add("Hòa Bình");
        listArea.add("Hưng Yên");
        listArea.add("Khánh Hòa");
        listArea.add("Kiên Giang");
        listArea.add("Kon Tum");
        listArea.add("Lai Châu");
        listArea.add("Lâm Đồng");
        listArea.add("Lạng Sơn");
        listArea.add("Lào Cai");
        listArea.add("Long An");
        listArea.add("Nam Định");
        listArea.add("Nghệ An");
        listArea.add("Ninh Bình");
        listArea.add("Ninh Thuận");
        listArea.add("Phú Thọ");
        listArea.add("Phú Yên");
        listArea.add("Quảng Bình");
        listArea.add("Quảng Nam");
        listArea.add("Quảng Ngãi");
        listArea.add("Quảng Ninh");
        listArea.add("Quảng Trị");
        listArea.add("Sóc Trăng");
        listArea.add("Sơn La");
        listArea.add("Tây Ninh");
        listArea.add("Thái Bình");
        listArea.add("Thái Nguyên");
        listArea.add("Thanh Hóa");
        listArea.add("Thừa Thiên Huế");
        listArea.add("Tiền Giang");
        listArea.add("Trà Vinh");
        listArea.add("Tuyên Quang");
        listArea.add("Vĩnh Long");
        listArea.add("Vĩnh Phúc");
        listArea.add("Yên Bái");
        ArrayAdapter<String> adapterArea = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listArea);
        adapterArea.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinArea.setAdapter(adapterArea);
        spinArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Set dữ liệu cho Spinner Price
        List<String> listPrice = new ArrayList<>();
        listPrice.add("Giá");
        listPrice.add("Thấp đến Cao");
        listPrice.add("Cao đến Thấp");
        ArrayAdapter<String> adapterPrice = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listPrice);
        adapterNew.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinPrice.setAdapter(adapterPrice);
        spinPrice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
