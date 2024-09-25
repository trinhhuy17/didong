package com.example.didongcuoiki.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import com.example.didongcuoiki.Adapter.AdapterFoodAdmin;
import com.example.didongcuoiki.DTO.FoodTrangChuAdmin;
import com.example.didongcuoiki.R;
public class FragmentRauTrangChuAdmin extends Fragment {
    private RecyclerView recyclerViewRauAdmin;
    private FloatingActionButton fltRauAdmin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_rau_trang_chu_admin, container, false);
        recyclerViewRauAdmin = view.findViewById(R.id.recyclerRauAdmin);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewRauAdmin.setLayoutManager(gridLayoutManager);
        AdapterFoodAdmin adapterFoodAdmin = new AdapterFoodAdmin(getFoodAdmin());
        recyclerViewRauAdmin.setAdapter(adapterFoodAdmin);
        return view;
    }
    private List<FoodTrangChuAdmin> getFoodAdmin() {
        List<FoodTrangChuAdmin> foodTrangChuAdminList = new ArrayList<>();
        foodTrangChuAdminList.add(new FoodTrangChuAdmin(R.drawable.img_bap_cai_trang_chu, "Rau cải bắp", "17.000 VND"));
        foodTrangChuAdminList.add(new FoodTrangChuAdmin(R.drawable.img_cai_chip_trang_chu, "Rau cải chíp", "24.000 VND"));
        foodTrangChuAdminList.add(new FoodTrangChuAdmin(R.drawable.img_rau_muong_trang_chu, "Rau muống", "17.000 VND"));
        foodTrangChuAdminList.add(new FoodTrangChuAdmin(R.drawable.img_bong_cai_xanh_trang_chu, "Bông vải xanh", "17.000 VND"));
        foodTrangChuAdminList.add(new FoodTrangChuAdmin(R.drawable.img_bong_cai_trang_trang_chu, "Bông cải trẵng", "17.000 VND"));
        foodTrangChuAdminList.add(new FoodTrangChuAdmin(R.drawable.img_cai_thao_trang_chu, "Rau cải thảo", "17.000 VND"));
        return foodTrangChuAdminList;
    }
}