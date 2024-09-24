package com.example.didongcuoiki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.didongcuoiki.DTO.SanPhamTrangChuUserDTO;
import com.example.didongcuoiki.R;
public class AdapterTrangChuUser extends RecyclerView.Adapter<AdapterTrangChuUser.ViewHolder> {
    Context context;
    List<SanPhamTrangChuUserDTO> list;
    public AdapterTrangChuUser(Context context, List<SanPhamTrangChuUserDTO> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_san_pham_trang_chu,parent,false);
        return new ViewHolder(view1);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivAnhSanPham.setImageResource(list.get(position).getAnhSanPhamUser());
        holder.ivIconGioHang.setImageResource(list.get(position).getIconGioHangUser());
        holder.tvTenSanPham.setText(list.get(position).getTenSanPhamUser());
        holder.tvGiaSanPham.setText(list.get(position).getGiaSanPhamUser());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public static  class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAnhSanPham,ivIconGioHang;
        TextView tvTenSanPham,tvGiaSanPham;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnhSanPham = itemView.findViewById(R.id.imgSanPhamTrangChu);
            ivIconGioHang = itemView.findViewById(R.id.ivIconGioHangItem);
            tvGiaSanPham = itemView.findViewById(R.id.tvGiaSanPhamItemTrangChu);
            tvTenSanPham = itemView.findViewById(R.id.tvTenSanPhamItemTrangChu);
        }
    }
}