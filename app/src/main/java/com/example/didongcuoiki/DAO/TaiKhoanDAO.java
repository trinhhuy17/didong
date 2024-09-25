package com.example.didongcuoiki.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import com.example.didongcuoiki.DBHelper.MyDBHelper;
import com.example.didongcuoiki.DTO.TaiKhoanDTO;
public class TaiKhoanDAO {
    private final MyDBHelper myDBHelper;
    private final SQLiteDatabase db;
    public TaiKhoanDAO(Context context){
        myDBHelper = new MyDBHelper(context);
        db = myDBHelper.getWritableDatabase();
    }
    //Hàm thêm tài khoản
    public long addRow(TaiKhoanDTO objTaiKhoan){
        ContentValues values = new ContentValues();
        values.put("ten_dang_nhap",objTaiKhoan.getTenDangNhap());
        values.put("mat_khau",objTaiKhoan.getMatKhau());
        return db.insert("tb_tai_khoan",null,values);
    }
    //Hàm đổi mật khẩu
    public int updateRow(TaiKhoanDTO objTaiKhoan){
        ContentValues values = new ContentValues();
        values.put("mat_khau",objTaiKhoan.getMatKhau());
        return db.update("tb_tai_khoan",values,"id_tai_khoan=?"
                ,new String[]{objTaiKhoan.getIdTaiKhoan()+""});
    }
    //Hàm getAll tài khoản
    public List<TaiKhoanDTO> getAll(){
        List<TaiKhoanDTO> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_tai_khoan",null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                int id = cursor.getInt(0);
                int idKhach = cursor.getInt(1);
                String tenDangNhap = cursor.getString(2);
                String matKhau = cursor.getString(3);
                TaiKhoanDTO objTaiKhoan = new TaiKhoanDTO();
                objTaiKhoan.setIdTaiKhoan(id);
                objTaiKhoan.setIdKhachHang(idKhach);
                objTaiKhoan.setTenDangNhap(tenDangNhap);
                objTaiKhoan.setMatKhau(matKhau);
                list.add(objTaiKhoan);
                cursor.moveToNext();
            }
        }
        return list;
    }
    //Hàm check tài khoản login
    public  Boolean checkTaiKhoan(String tenTaiKhoan,String matKhau){
        Cursor cursor =
                db.rawQuery("SELECT * FROM tb_tai_khoan WHERE ten_dang_nhap=? AND mat_khau=?"
                        ,new String[]{tenTaiKhoan,matKhau});
        if (cursor.getCount() > 0){
            return true;
        }else {
            return false;
        }
    }
    //Hàm check tên tài khoản để quên mật khẩu
    public Boolean checkUserName(String tenTaiKhoan){
        Cursor cursor =
                db.rawQuery("SELECT * FROM tb_tai_khoan WHERE ten_dang_nhap=?"
                        ,new String[]{tenTaiKhoan});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
