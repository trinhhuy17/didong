package com.example.didongcuoiki.DTO;

public class TaiKhoanDTO {
    public int idTaiKhoan;
    public int idKhachHang;
    public String tenDangNhap;
    public String matKhau;
    public TaiKhoanDTO() {
    }
    public TaiKhoanDTO(int idTaiKhoan, int idKhachHang, String tenDangNhap, String matKhau) {
        this.idTaiKhoan = idTaiKhoan;
        this.idKhachHang = idKhachHang;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }
    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }
    public int getIdKhachHang() {
        return idKhachHang;
    }
    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }
    public String getTenDangNhap() {
        return tenDangNhap;
    }
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}