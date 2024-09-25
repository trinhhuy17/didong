package com.example.didongcuoiki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import java.util.ArrayList;
import java.util.List;
import com.example.didongcuoiki.DAO.ThongTinKhachHangDAO;
import com.example.didongcuoiki.DBHelper.MyDBHelper;
import com.example.didongcuoiki.DTO.ThongTinKhachHangDTO;
import com.example.didongcuoiki.Fragment.FragTaiKhoanUser;
public class ThongTinCaNhanActivity extends AppCompatActivity {
    private ImageView imgBackThongTinCaNhan;
    private EditText edtTenKhachHang, edtEmail, edtSoDienThoai, edtGioiTinh, edtNgaySinh;
    private AppCompatButton btnLuThongTin;
    private ThongTinKhachHangDAO thongTinKhachHangDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
       // Ánh xạ các View Layout
        imgBackThongTinCaNhan = findViewById(R.id.imgBackThongTinCaNhan);
        imgBackThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edtTenKhachHang = findViewById(R.id.edt_ho_ten);
        edtEmail = findViewById(R.id.edt_email);
        edtSoDienThoai = findViewById(R.id.edt_sdt);
        edtGioiTinh = findViewById(R.id.edtGioiTinh);
        edtNgaySinh = findViewById(R.id.edt_ngay_sinh);
        btnLuThongTin = findViewById(R.id.btn_doi_pass);
        thongTinKhachHangDAO = new ThongTinKhachHangDAO(this);
        ArrayList<ThongTinKhachHangDTO> list = thongTinKhachHangDAO.getAll();
        if (!list.isEmpty()) {
            ThongTinKhachHangDTO khachHangDTO = list.get(0);
            edtTenKhachHang.setText(khachHangDTO.getTenKhachHang());
            edtEmail.setText(khachHangDTO.getEmail());
            edtSoDienThoai.setText(khachHangDTO.getSoDienThoai());
            edtGioiTinh.setText(khachHangDTO.getGioiTinh());
            edtNgaySinh.setText(khachHangDTO.getNgaySinh());
        }
        btnLuThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String tenKhachHang = edtTenKhachHang.getText().toString();
                    String email = edtEmail.getText().toString();
                    String soDienThoai = edtSoDienThoai.getText().toString();
                    String gioiTinh = edtGioiTinh.getText().toString();
                    String ngaySinh = edtNgaySinh.getText().toString();
                    ThongTinKhachHangDTO thongTinKhachHangDTO = new ThongTinKhachHangDTO();
                    int thongTinKhachHangUpdate = thongTinKhachHangDAO.updateRow(thongTinKhachHangDTO);
                    if (thongTinKhachHangUpdate > 0) {
                        Toast.makeText(ThongTinCaNhanActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ThongTinCaNhanActivity.this, "Lưu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}