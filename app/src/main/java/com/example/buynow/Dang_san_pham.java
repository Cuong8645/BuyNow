package com.example.buynow;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.buynow.data_models.product;
import com.example.buynow.data_models.user;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dang_san_pham extends AppCompatActivity {
    private DatabaseReference mDataBase;
    private EditText editTextTenSanPham;
    private EditText editTextGia;
    private EditText editTextMoTaSanPham;
    private Switch aSwitchTinhTrang;
    private Spinner spinnerKhuVuc;
    private Spinner spinnerLoai;
    private Button buttonDang;
    private Button buttonXemLai;
    private ImageView imageView;
    private StorageReference mStorage;
    private static  final  int GALLERY_INTENT = 2;
    private ProgressDialog mProgressDialog;
    public  user  user;
    public product product;
    private String i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_san_pham_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Đăng sản phẩm"); //Thiết lập tiêu đề nếu muốn
        String title = actionBar.getTitle().toString(); //Lấy tiêu đề nếu muốn
        // Init View
        editTextTenSanPham = (EditText) findViewById(R.id.editText_TenSanPham);
        editTextGia = (EditText) findViewById(R.id.editText_Gia);
        editTextMoTaSanPham = (EditText) findViewById(R.id.editText_MoTaSanPham);
        aSwitchTinhTrang = (Switch) findViewById(R.id.SwitchTinhTrang);
        spinnerKhuVuc = (Spinner) findViewById(R.id.SpnKhuVuc);
        spinnerLoai = (Spinner) findViewById(R.id.SpnDanhMuc);
        buttonDang = (Button) findViewById(R.id.BtnDang);
        buttonXemLai = (Button) findViewById(R.id.BtnXemLai);
        imageView = (ImageView) findViewById(R.id.ImageViewSanPham);

        mStorage = FirebaseStorage.getInstance().getReference();

        mProgressDialog = new ProgressDialog(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });



//        editTextTenSanPham.getText().toString();
//        editTextGia.getText().toString();
//        editTextMoTaSanPham.getText().toString();
//        aSwitchTinhTrang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    aSwitchTinhTrang.getTextOn();
//                }else{
//                    aSwitchTinhTrang.getTextOff();
//                }
//            }
//        });
//        spinnerKhuVuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    String item = parent.getItemAtPosition(position).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        spinnerLoai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item = parent.getItemAtPosition(position).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK){

            mProgressDialog.setMessage("Upload.....");
            mProgressDialog.show();

            final Uri uri = data.getData();
            imageView.setImageURI(uri);
            StorageReference filepath = mStorage.child("Photos").child(uri.getLastPathSegment());
            final String key1 = uri.getLastPathSegment();

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(Dang_san_pham.this,"Upload Done...",Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();
                }
            });
            buttonDang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get value from switch
                    aSwitchTinhTrang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked){
                                i= aSwitchTinhTrang.getTextOn().toString();
                            }else{
                                i= aSwitchTinhTrang.getTextOff().toString();
                            }
                        }
                    });


                    // Viết dữ liệu vào database
                    mDataBase = FirebaseDatabase.getInstance().getReference();
                    final String key = mDataBase.child("products").push().getKey();
                    final Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    final String date = simpleDateFormat.format(calendar.getTime());
                    mDataBase.child("products").child(key).setValue(new product(editTextTenSanPham.getText().toString(),i,spinnerLoai.getSelectedItem().toString(),editTextGia.getText().toString(),editTextMoTaSanPham.getText().toString(),date,spinnerKhuVuc.getSelectedItem().toString()));
                    //new user(editTextTenSanPham.getText().toString(),editTextGia.getText().toString(),editTextMoTaSanPham.getText().toString(),key1,spinnerLoai.getSelectedItem().toString(),spinnerKhuVuc.getSelectedItem().toString())
                    editTextTenSanPham.setText("");
                    editTextGia.setText("");
                    editTextMoTaSanPham.setText("");
                }

            });
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

}
