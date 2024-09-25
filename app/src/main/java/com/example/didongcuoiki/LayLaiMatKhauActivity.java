package com.example.didongcuoiki;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import java.util.List;
import com.example.didongcuoiki.DAO.TaiKhoanDAO;
import com.example.didongcuoiki.DTO.TaiKhoanDTO;
public class LayLaiMatKhauActivity extends AppCompatActivity {
    private EditText edMatKhauMoi,edLaiMatKhauMoi;
    private AppCompatButton btnDoiMatKhau;
    private TaiKhoanDAO taiKhoanDAO;
    private List<TaiKhoanDTO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay_lai_mat_khau);
        //Ánh xạ view
        edLaiMatKhauMoi = findViewById(R.id.edLaiMatKhauMoiLayLaiMatKhau);
        edMatKhauMoi = findViewById(R.id.edMatKhauMoiLayLaiMatKhau);
        btnDoiMatKhau = findViewById(R.id.btnDoiMatKhacLayLaiMatKhau);
        taiKhoanDAO = new TaiKhoanDAO(this);
        list = taiKhoanDAO.getAll();
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemTra()) {
                    TaiKhoanDTO idTaiKhoan = new TaiKhoanDTO();
                    for (int i = 0; i < list.size(); i++) {
                        idTaiKhoan = list.get(i);
                    }
                    String matKhauMoi = edMatKhauMoi.getText().toString();
                    idTaiKhoan.setMatKhau(matKhauMoi);
                    int kq = taiKhoanDAO.updateRow(idTaiKhoan);
                    if (kq > 0) {
                        Toast.makeText(LayLaiMatKhauActivity.this, "Đổi mât khẩu thành công"
                                , Toast.LENGTH_SHORT).show();
                        list.clear();
                        list.addAll(taiKhoanDAO.getAll());
                        startActivity(new Intent(LayLaiMatKhauActivity.this, LoginSigUpActivity.class));
                        finish();
                    }else {
                        Toast.makeText(LayLaiMatKhauActivity.this, "Đổi mật khẩu thất bại"
                                , Toast.LENGTH_SHORT).show();
                    }
                }
            }
            private boolean kiemTra() {
                if (edMatKhauMoi.getText().toString().equals("")
                        ||edLaiMatKhauMoi.getText().toString().equals("")) {
                    Toast.makeText(LayLaiMatKhauActivity.this, "Mời nhập thông tin"
                            , Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (edMatKhauMoi.getText().toString().length() < 5 ) {
                    Toast.makeText(LayLaiMatKhauActivity.this
                            , "Mật khẩu mới phải có trên 5 ký tự", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (!edMatKhauMoi.getText().toString().equals(edLaiMatKhauMoi.getText().toString())) {
                    Toast.makeText(LayLaiMatKhauActivity.this, "Mật khẩu không khớp"
                            , Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });
    }
}