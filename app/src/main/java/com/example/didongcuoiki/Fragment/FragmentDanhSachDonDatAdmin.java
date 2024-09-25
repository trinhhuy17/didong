package com.example.didongcuoiki.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.List;
import com.example.didongcuoiki.Adapter.AdapterDanhSachDonDatAdmin;
import com.example.didongcuoiki.DTO.DanhSachDonDatAdminDTO;
import com.example.didongcuoiki.R;
public class FragmentDanhSachDonDatAdmin extends Fragment {
    private RecyclerView recyclerViewDsDonDat;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_danh_sach_don_dat_admin, container, false);
        recyclerViewDsDonDat = view.findViewById(R.id.recyclerDanhSachHoaDonAdmin);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        AdapterDanhSachDonDatAdmin adapterDanhSachDonDatAdmin = new AdapterDanhSachDonDatAdmin(getDSHD());
        recyclerViewDsDonDat.setLayoutManager(layoutManager);
        recyclerViewDsDonDat.setAdapter(adapterDanhSachDonDatAdmin);
        return view;
    }
    private List<DanhSachDonDatAdminDTO> getDSHD() {
        List<DanhSachDonDatAdminDTO> list = new ArrayList<>();
        list.add(new DanhSachDonDatAdminDTO(R.drawable.img_bong_cai_trang_trang_chu, "Trinh quang huy", "Bông cai trắng", "1kg", "17.000 VND"));
        list.add(new DanhSachDonDatAdminDTO(R.drawable.img_bong_cai_trang_trang_chu, "trinh Quang Huy", "Bông cai trắng", "1kg", "17.000 VND"));
        return list;
    }
}