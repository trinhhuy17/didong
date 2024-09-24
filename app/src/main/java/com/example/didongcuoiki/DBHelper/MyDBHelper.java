package com.example.didongcuoiki.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MyDBHelper extends SQLiteOpenHelper {
    public  static  final  String DB_NAME = "QuanLy";
    public  static  final  int DB_VERSION = 1;
    public MyDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlLoaiSanPham = "CREATE TABLE tb_loai_san_pham (\n" +
                "    id_san_pham       INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    ten_loai_san_pham TEXT    NOT NULL\n" +
                ");\n";
        db.execSQL(sqlLoaiSanPham);
        String sqlSanPham = "CREATE TABLE tb_san_pham (\n" +
                "    id_san_pham      INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_loai_san_pham INTEGER REFERENCES tb_loai_san_pham (id_san_pham),\n" +
                "    ten_san_pham     TEXT    NOT NULL,\n" +
                "    don_gia          INTEGER NOT NULL,\n" +
                "    img_url          INTEGER NOT NULL,\n" +
                "    mo_ta            TEXT    NOT NULL,\n" +
                "    so_luong         INTEGER NOT NULL\n" +
                ");\n";
        db.execSQL(sqlSanPham);
        String sqlThongTinKhachHang = "CREATE TABLE tb_thong_tin_khach_hang (\n" +
                "    id_khach_hang  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    ten_khach_hang TEXT    NOT NULL,\n" +
                "    so_dien_thoai  TEXT    NOT NULL,\n" +
                "    gioi_tinh      TEXT    NOT NULL,\n" +
                "    ngay_sinh      TEXT    NOT NULL,\n" +
                "    email          TEXT    NOT NULL\n" +
                ");\n";
        db.execSQL(sqlThongTinKhachHang);
        String sqlHoaDon = "CREATE TABLE tb_hoa_don (\n" +
                "    id_hoa_don    INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_san_pham   INTEGER REFERENCES tb_san_pham (id_san_pham),\n" +
                "    id_khach_hang INTEGER REFERENCES tb_khach_hang (id_khach_hang),\n" +
                "    dia_chi       TEXT    NOT NULL,\n" +
                "    ngay_dat      TEXT    NOT NULL,\n" +
                "    trang_thai    TEXT    NOT NULL,\n" +
                "    tong_tien     INTEGER NOT NULL\n" +
                ");\n";
        db.execSQL(sqlHoaDon);
        String sqlTaiKhoan = "CREATE TABLE tb_tai_khoan (\n" +
                "    id_tai_khoan  INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_khach_hang INTEGER REFERENCES tb_khach_hang (id_khach_hang),\n" +
                "    ten_dang_nhap TEXT    NOT NULL,\n" +
                "    mat_khau      TEXT    NOT NULL\n" +
                ");\n";
        db.execSQL(sqlTaiKhoan);
        String sqlChiTietHoaDon = "CREATE TABLE tb_chi_tiet_hoa_don (\n" +
                "    id_chi_tiet_hoa_don INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    id_san_pham         INTEGER NOT NULL\n" +
                "                                REFERENCES tb_san_pham (id_san_pham),\n" +
                "    id_hoa_don          INTEGER NOT NULL\n" +
                "                                REFERENCES tb_hoa_don (id_hoa_don),\n" +
                "    ten_san_hoa_pham    TEXT    NOT NULL,\n" +
                "    so_luong            INTEGER NOT NULL,\n" +
                "    tong_tien_hoa_don   TEXT    NOT NULL\n" +
                ");\n";
        db.execSQL(sqlChiTietHoaDon);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tb_loai_san_pham");
        db.execSQL("DROP TABLE  tb_san_pham");
        db.execSQL("DROP TABLE tb_thong_tin_khach_hang");
        db.execSQL("DROP TABLE tb_hoa_don");
        db.execSQL("DROP TABLE tb_tai_khoan");
        db.execSQL("DROP TABLE tb_chi_tiet_hoa_don");
    }
}
