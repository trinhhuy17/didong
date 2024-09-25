package com.example.didongcuoiki.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.didongcuoiki.DTO.DanhSachDonDatAdminDTO;
import com.example.didongcuoiki.R;
public class AdapterDanhSachDonDatAdmin extends RecyclerView.Adapter<AdapterDanhSachDonDatAdmin.DanhSachDonDatViewHolder>{
    private List<DanhSachDonDatAdminDTO> list;
    public AdapterDanhSachDonDatAdmin(List<DanhSachDonDatAdminDTO> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public DanhSachDonDatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danh_sach_don_admin, parent, false);
        return new DanhSachDonDatViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DanhSachDonDatViewHolder holder, int position) {
        DanhSachDonDatAdminDTO danhSachDonDatAdminDTO = list.get(position);
        if (danhSachDonDatAdminDTO == null){
            return;
        }
        holder.imgDanhSachDonAdmin.setImageResource(danhSachDonDatAdminDTO.getImgDsAdmin());
        holder.txtTenNguoiDat.setText(danhSachDonDatAdminDTO.getNguoiDatDs());
        holder.txtSanPhamDat.setText(danhSachDonDatAdminDTO.getSanPhamDat());
        holder.txtSoLuongDat.setText(danhSachDonDatAdminDTO.getSoLuongDat());
        holder.txtDonGiaDat.setText(danhSachDonDatAdminDTO.getDonGiaSpDat());
    }
    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }
    public class DanhSachDonDatViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgDanhSachDonAdmin;
        private TextView txtTenNguoiDat;
        private TextView txtSanPhamDat;
        private TextView txtSoLuongDat;
        private TextView txtDonGiaDat;
        public DanhSachDonDatViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDanhSachDonAdmin = itemView.findViewById(R.id.imgDanhSachDonAdmin);
            txtTenNguoiDat = itemView.findViewById(R.id.txtNguoiDatDonAdmin);
            txtSanPhamDat = itemView.findViewById(R.id.txtSpDanhSachAdmin);
            txtSoLuongDat = itemView.findViewById(R.id.txtSLuongDanhSachAdmin);
            txtDonGiaDat = itemView.findViewById(R.id.txtDonGiaDanhSachAdmin);
        }
    }
}