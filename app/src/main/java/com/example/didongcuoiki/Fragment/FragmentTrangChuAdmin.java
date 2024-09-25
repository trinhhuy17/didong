package com.example.didongcuoiki.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.example.didongcuoiki.Adapter.AdapterViewPagerTrangChu;
import com.example.didongcuoiki.R;
public class FragmentTrangChuAdmin extends Fragment {
    private TabLayout tabLayoutAdmin;
    private ViewPager2 viewPager2Admin;
    private AdapterViewPagerTrangChu adapterViewPagerTrangChu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_trang_chu_admin, container, false);
        tabLayoutAdmin = view.findViewById(R.id.tabLayoutAdmin);
        viewPager2Admin = view.findViewById(R.id.viewPager2Admin);
        adapterViewPagerTrangChu = new AdapterViewPagerTrangChu(this);
        viewPager2Admin.setAdapter(adapterViewPagerTrangChu);
        new TabLayoutMediator(tabLayoutAdmin, viewPager2Admin, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Rau");
                    break;
                case 1:
                    tab.setText("Củ");
                    break;
                case 2:
                    tab.setText("Quả");
                    break;
            }
        }).attach();
        return view;
    }
}