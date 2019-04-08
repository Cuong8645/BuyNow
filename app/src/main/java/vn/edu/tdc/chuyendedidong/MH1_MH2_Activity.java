package vn.edu.tdc.chuyendedidong;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MH1_MH2_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mh2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Loại bỏ tiêu đề mặc định
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        //Bỏ con trỏ của EditText khi chưa click vào
        final EditText edtSearch = (EditText) findViewById(R.id.edtSearch);
        btnSearch.requestFocus();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Sự kiện của button search ở màn hình 1
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MH1_MH2_Activity.this, MH3_Activity.class);
                startActivity(intent);
            }
        });

        // Chuyển hình ảnh hình đại diện từ hình vuông sang hình tròn
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.hinh_dai_dien);
        Bitmap circularBitmap = ImageConverter_Mh2.getRoundedCornerBitmap(bitmap, 100);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login_signup) {
            // Handle the camera action
        } else if (id == R.id.nav_post_news) {

        } else if (id == R.id.nav_messager) {

        } else if (id == R.id.nav_save_news) {

        } else if (id == R.id.nav_account_settings) {

        } else if (id == R.id.nav_create_shop) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
