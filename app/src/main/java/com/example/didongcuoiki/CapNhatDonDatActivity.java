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


    }
}