package com.example.didongcuoiki.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.didongcuoiki.Fragment.FragDonHuyUser;
import com.example.didongcuoiki.Fragment.FragDonDatUser;
import com.example.didongcuoiki.Fragment.FragLogin;
import com.example.didongcuoiki.Fragment.FragSigUp;
public class AdapterViewPagerDonDat extends FragmentStateAdapter {
    public AdapterViewPagerDonDat(@NonNull Fragment fragment) {
        super(fragment);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragDonDatUser();
            case 1:
                return new FragDonHuyUser();
            default:
                return new FragDonDatUser();
        }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
