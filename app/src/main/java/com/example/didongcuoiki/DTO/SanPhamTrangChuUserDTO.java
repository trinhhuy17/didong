package com.example.didongcuoiki.DTO;

public class SanPhamTrangChuUserDTO {
    public int idSanPhamUser;
    public int anhSanPhamUser,iconGioHangUser;
    public String tenSanPhamUser;
    public String giaSanPhamUser;
    public SanPhamTrangChuUserDTO(int idSanPhamUser, int anhSanPhamUser, int iconGioHangUser, String tenSanPhamUser, String giaSanPhamUser) {
        this.idSanPhamUser = idSanPhamUser;
        this.anhSanPhamUser = anhSanPhamUser;
        this.iconGioHangUser = iconGioHangUser;
        this.tenSanPhamUser = tenSanPhamUser;
        this.giaSanPhamUser = giaSanPhamUser;
    }
    public int getIdSanPhamUser() {
        return idSanPhamUser;
    }
    public void setIdSanPhamUser(int idSanPhamUser) {
        this.idSanPhamUser = idSanPhamUser;
    }
    public int getAnhSanPhamUser() {
        return anhSanPhamUser;
    }
    public void setAnhSanPhamUser(int anhSanPhamUser) {
        this.anhSanPhamUser = anhSanPhamUser;
    }
    public int getIconGioHangUser() {
        return iconGioHangUser;
    }
    public void setIconGioHangUser(int iconGioHangUser) {
        this.iconGioHangUser = iconGioHangUser;
    }
    public String getTenSanPhamUser() {
        return tenSanPhamUser;
    }
    public void setTenSanPhamUser(String tenSanPhamUser) {
        this.tenSanPhamUser = tenSanPhamUser;
    }
    public String getGiaSanPhamUser() {
        return giaSanPhamUser;
    }
    public void setGiaSanPhamUser(String giaSanPhamUser) {
        this.giaSanPhamUser = giaSanPhamUser;
    }
}
