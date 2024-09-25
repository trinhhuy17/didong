package com.example.didongcuoiki.Adapter;

import static com.example.didongcuoiki.Fragment.FragGioHangUser.tvTongTienGioHang;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import com.example.didongcuoiki.DAO.GioHangDAO;
import com.example.didongcuoiki.DBHelper.MyDBHelper;
import com.example.didongcuoiki.DTO.GioHangDTO;
import com.example.didongcuoiki.Fragment.FragGioHangUser;
import com.example.didongcuoiki.R;
public class AdapterGioHang extends RecyclerView.Adapter<AdapterGioHang.ViewHolder> {
    Context context;
    public static List<GioHangDTO> list;
    GioHangDAO gioHangDAO;
    ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    public AdapterGioHang(Context context, List<GioHangDTO> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_gio_hang,parent,false);
        return new ViewHolder(view1);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        viewBinderHelper.bind(holder.layoutSwipeRevealLayout,list.get(position).getId()+"");
        GioHangDTO id = list.get(position);
        gioHangDAO = new GioHangDAO(context);
        list = gioHangDAO.getAll();
        holder.tvTenSanPham.setText(list.get(position).getTenSanPham());
        holder.tvGiaMacDinh.setText(decimalFormat.format(list.get(position).getGiaSanPham())+" VND / 1Kg");
        String tenImg = list.get(position).getImgSanPham();
        int resImg =
                (((Activity)context).getResources().getIdentifier(tenImg
                        ,"drawable",((Activity)context).getPackageName()));
        holder.ivSanPham.setImageResource(resImg);
        holder.tvTongTien.setText(decimalFormat.format(list.get(position).getTongTienCuaSp())+" VND");
        holder.tvSoLuongSp.setText(list.get(position).getSoLuongSanPham()+"");
        //Xoá sản phẩm trong gio hàng
        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kq = gioHangDAO.deleteRow(id);
                if (kq > 0) {
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    list.clear();
                    list.addAll(gioHangDAO.getAll());
                    tinhTongTien();
                    notifyDataSetChanged();
                }else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Set thêm sản phẩm
        holder.tvCongSoLuongSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getSoLuongSanPham() < 8) {
                    //setThemSoLuongSanPham
                    int soLuongSanPhamMoi = id.getSoLuongSanPham()+1;
                    id.setSoLuongSanPham(soLuongSanPhamMoi);
                    holder.tvSoLuongSp.setText(soLuongSanPhamMoi+"");
                    //set lại giá sản phẩm khi số lượng sản phẩm thay đổi;
                    int giaMacDinh = id.getGiaSanPham();
                    long tongTien1SanPham = (long) giaMacDinh *soLuongSanPhamMoi;
                    id.setTongTienCuaSp((int) tongTien1SanPham);
                    holder.tvTongTien.setText(decimalFormat.format(tongTien1SanPham)+" VND");
                    gioHangDAO.updateRowSoLuong(id);
                    list.clear();
                    list.addAll(gioHangDAO.getAll());
                    tinhTongTien();
                }
            }
        });
        //Set click trừ sản phẩm
        holder.tvTruSoLuongSp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getSoLuongSanPham() > 1) {
                    //setThemSoLuongSanPham
                    int soLuongSanPhamMoi = id.getSoLuongSanPham()-1;
                    id.setSoLuongSanPham(soLuongSanPhamMoi);
                    holder.tvSoLuongSp.setText(soLuongSanPhamMoi+"");
                    //set lại giá sản phẩm khi số lượng sản phẩm thay đổi;
                    int giaMacDinh = id.getGiaSanPham();
                    long tongTien1SanPham = (long) giaMacDinh *soLuongSanPhamMoi;
                    id.setTongTienCuaSp((int) tongTien1SanPham);
                    holder.tvTongTien.setText(decimalFormat.format(tongTien1SanPham)+" VND");
                    gioHangDAO.updateRowSoLuong(id);
                    list.clear();
                    list.addAll(gioHangDAO.getAll());
                    tinhTongTien();
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenSanPham,tvCongSoLuongSp,tvTruSoLuongSp,tvSoLuongSp;
        TextView tvGiaMacDinh,tvTongTien;
        ImageView ivSanPham,ivXoa;
        SwipeRevealLayout layoutSwipeRevealLayout;
        LinearLayout layoutDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenSanPham = itemView.findViewById(R.id.tvTenSanPhamItemGioHang);
            tvGiaMacDinh = itemView.findViewById(R.id.tvGiaSanPhamItemGioHang);
            tvTongTien = itemView.findViewById(R.id.tvTongTien1SanPhamItemGioHang);
            tvCongSoLuongSp = itemView.findViewById(R.id.tvThemSoLuongSanPhamItemGioHang);
            tvTruSoLuongSp = itemView.findViewById(R.id.tvTruSoLuongSanPhamItemGioHang);
            tvSoLuongSp = itemView.findViewById(R.id.tvSoLuongSanPhamCua1ItemGioHang);
            ivSanPham = itemView.findViewById(R.id.ivItemGioHang);
            layoutSwipeRevealLayout = itemView.findViewById(R.id.layoutSRL);
            layoutDelete = itemView.findViewById(R.id.layoutDelete);
        }
    }
    //Hàm tính tổng tiền
    private void tinhTongTien(){
        long tongTien = 0;
        for (int i = 0; i < list.size(); i++) {
            tongTien = tongTien + ((long) list.get(i).getGiaSanPham() * list.get(i).getSoLuongSanPham());
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tvTongTienGioHang.setText("Tổng tiền : "+decimalFormat.format(tongTien)+" VND");
    }
}