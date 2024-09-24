package com.example.didongcuoiki.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.didongcuoiki.Fragment.FragQuaDanhSachSanPhamUse;
import com.example.didongcuoiki.Fragment.FragCuDanhSachSanPhamUse;
import com.example.didongcuoiki.Fragment.FragRauDanhSachSanPhamUse;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragRauDanhSachSanPhamUse();
            case 1:
                return new FragCuDanhSachSanPhamUse();
            case 2:
                return new FragQuaDanhSachSanPhamUse();
            default:
                return new FragRauDanhSachSanPhamUse();
        }
    }
    @Override
    public int getItemCount() {
        return 3;
    }
}