package com.example.didongcuoiki.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;

import com.example.didongcuoiki.Adapter.AdapterDonDatUser;
import com.example.didongcuoiki.DAO.DonDatUserDAO;
import com.example.didongcuoiki.DTO.DonDatUserDTO;
import com.example.didongcuoiki.R;
public class FragDonDatUser extends Fragment {
    List<DonDatUserDTO> list;
    DonDatUserDAO donDatUserDAO;
    AdapterDonDatUser adapterDonDatUser;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_don_dat_user,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Ánh xạ view
        recyclerView = view.findViewById(R.id.rcvDonDatUser);
        //Khởi tạo dao
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.donDat();
        adapterDonDatUser = new AdapterDonDatUser(getContext(),list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDatUser);
        adapterDonDatUser.notifyDataSetChanged();
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();
        donDatUserDAO = new DonDatUserDAO(getContext());
        list = donDatUserDAO.donDat();
        adapterDonDatUser = new AdapterDonDatUser(getContext(),list);
        LinearLayoutManager manager = new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDonDatUser);
        adapterDonDatUser.notifyDataSetChanged();
    }
}