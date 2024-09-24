package com.example.didongcuoiki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
public class XacNhanTaiKhoanActivity extends AppCompatActivity {
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_tai_khoan);
        ivBack = findViewById(R.id.tvBackXacNhanTaiKhoan);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XacNhanTaiKhoanActivity.this, LoginSigUpActivity.class));
                finish();
            }
        });
    }
}