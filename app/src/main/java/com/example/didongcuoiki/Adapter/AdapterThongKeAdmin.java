package com.example.didongcuoiki.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.didongcuoiki.DTO.ThongKeAdmin;
import com.example.didongcuoiki.R;
public class AdapterThongKeAdmin extends RecyclerView.Adapter<AdapterThongKeAdmin.ThongKeViewHolder>{
    private List<ThongKeAdmin> thongKeAdminList;
    public AdapterThongKeAdmin(List<ThongKeAdmin> thongKeAdminList) {
        this.thongKeAdminList = thongKeAdminList;
    }
    @NonNull
    @Override
    public ThongKeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_thong_ke, parent, false);
        return new ThongKeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ThongKeViewHolder holder, int position) {
        ThongKeAdmin thongKeAdmin = thongKeAdminList.get(position);
        if (thongKeAdmin == null){
            return;
        }
        holder.imgThongKe.setImageResource(thongKeAdmin.getImgThongKe());
        holder.txtTenSpTK.setText(thongKeAdmin.getTenSpThongKe());
        holder.txtSoLuongMua.setText(thongKeAdmin.getSoLuongSPmua());
    }
    @Override
    public int getItemCount() {
        if (thongKeAdminList != null){
            return thongKeAdminList.size();
        }
        return 0;
    }
    public class ThongKeViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgThongKe;
        private TextView txtTenSpTK;
        private TextView txtSoLuongMua;
        public ThongKeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgThongKe = itemView.findViewById(R.id.imgThongKe);
            txtSoLuongMua = itemView.findViewById(R.id.txtSoLuongMua);
            txtTenSpTK = itemView.findViewById(R.id.txtTenSpThongKe);
        }
    }
}