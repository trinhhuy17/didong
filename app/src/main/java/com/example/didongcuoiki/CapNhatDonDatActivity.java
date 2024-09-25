package com.example.didongcuoiki;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;

public class CapNhatDonDatActivity extends AppCompatActivity {
    private EditText edtTenKhachHang, edtSoDienThoai, edtDiaChi;
    private AppCompatButton btnCapNhatThongTinDiaChi;
    ImageView imgBackCapNhatDiaChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cap_nhat_don_dat);
        edtTenKhachHang = findViewById(R.id.edtTenKhachHang);
        edtSoDienThoai = findViewById(R.id.edtSoDienThoai);
        edtDiaChi = findViewById(R.id.edtDiaChiCapNhat);
        btnCapNhatThongTinDiaChi = findViewById(R.id.btnCapNhatThongTinDiaChi);
        imgBackCapNhatDiaChi = findViewById(R.id.imgBackcapNhatDiaChi);
        imgBackCapNhatDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent  intent = getIntent();
        if (intent != null){
            String tenKhachHang = intent.getStringExtra("ten_khach_hang");
            String soDienThoai = intent.getStringExtra("so_dien_thoai");
            String diaChi = intent.getStringExtra("dia_chi");
            edtTenKhachHang.setText(tenKhachHang);
            edtSoDienThoai.setText(soDienThoai);
            edtDiaChi.setText(diaChi);
        }


    }
}