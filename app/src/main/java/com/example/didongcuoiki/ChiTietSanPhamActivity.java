package com.example.didongcuoiki;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import com.example.didongcuoiki.DAO.GioHangDAO;
import com.example.didongcuoiki.DAO.SanPhamTrangChuDAO;
import com.example.didongcuoiki.DTO.GioHangDTO;
import com.example.didongcuoiki.DTO.SanPhamTrangChuUserDTO;
import com.example.didongcuoiki.Fragment.FragGioHangUser;
import com.example.didongcuoiki.Fragment.FragTrangChuUser;
public class ChiTietSanPhamActivity extends AppCompatActivity {
    ImageView ivBack,ivAnhSp;
    List<SanPhamTrangChuUserDTO> list;
    SanPhamTrangChuDAO sanPhamTrangChuDAO;
    TextView tvTenSp,tvGiaSp,tvMoTaSp;
    LinearLayout layoutThemVaoGioHang;
    List<GioHangDTO> listGioHang;
    GioHangDAO gioHangDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        ivBack = findViewById(R.id.ivbackChiTietSanPham);
        tvTenSp = findViewById(R.id.tvTenSanPham);
        tvGiaSp = findViewById(R.id.tvGiaTienChiTienSanPham);
        tvMoTaSp = findViewById(R.id.tvMoTaSanPhamChiTietSanPham);
        ivAnhSp = findViewById(R.id.ivAnhChiTietSp);
        layoutThemVaoGioHang = findViewById(R.id.layoutThemVaoGioHangChiTietSanPham);
        sanPhamTrangChuDAO = new SanPhamTrangChuDAO(this);
        list = sanPhamTrangChuDAO.getAll();
        gioHangDAO = new GioHangDAO(this);
        listGioHang = gioHangDAO.getAll();
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        String tenSanPham = getIntent().getStringExtra("tenSp");
        int giaSp = getIntent().getIntExtra("giaSp",0);
        String anhSp = getIntent().getStringExtra("anhSp");
        String moTaSp = getIntent().getStringExtra("moTaSp");
        tvTenSp.setText(tenSanPham);
        tvGiaSp.setText(giaSp+" VND");
        int resImg = ((this).getResources().getIdentifier(anhSp,"drawable",getPackageName()));
        ivAnhSp.setImageResource(resImg);
        tvMoTaSp.setText(moTaSp);
        layoutThemVaoGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GioHangDTO objGioHang = new GioHangDTO();
                objGioHang.setTenSanPham(tenSanPham);
                objGioHang.setGiaSanPham(giaSp);
                objGioHang.setSoLuongSanPham(1);
                objGioHang.setImgSanPham(anhSp);
                objGioHang.setTongTienCuaSp(giaSp);
                long kq = gioHangDAO.addRow(objGioHang);
                if (kq > 0) {
                    Toast.makeText(ChiTietSanPhamActivity.this, "Thêm thành công"
                            ,Toast.LENGTH_SHORT).show();
                    listGioHang.clear();
                    listGioHang.addAll(gioHangDAO.getAll());
                    layoutThemVaoGioHang.setEnabled(true);
                }else {
                    Toast.makeText(ChiTietSanPhamActivity.this, "Thêm thất bại"
                            ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}