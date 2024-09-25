package com.example.didongcuoiki.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.didongcuoiki.DanhSachSanPhamUseActivity;
import com.example.didongcuoiki.DAO.SanPhamTrangChuDAO;
import com.example.didongcuoiki.Adapter.AdapterSliderTrangChuUser;
import com.example.didongcuoiki.Adapter.AdapterTrangChuUser;
import com.example.didongcuoiki.DTO.SanPhamTrangChuUserDTO;
import com.example.didongcuoiki.DTO.SliderDTO;
import com.example.didongcuoiki.R;
import me.relex.circleindicator.CircleIndicator3;

public class FragTrangChuUser extends Fragment {
    private TextView tvXemThem, tvName;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;
    private RecyclerView recyclerView;
    private AdapterTrangChuUser adapterTrangChuUser;
    private LinearLayout layoutRau,layoutCu,layoutQua,layoutHat;
    private SanPhamTrangChuDAO sanPhamTrangChuDAO;
    private  List<SanPhamTrangChuUserDTO> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_trang_chu_user,container,false);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvXemThem = view.findViewById(R.id.tvXemThem);
        layoutCu = view.findViewById(R.id.layoutCuTrangChuUser);
        layoutQua = view.findViewById(R.id.layoutQuaTrangChuUser);
        layoutHat = view.findViewById(R.id.layoutHatTrangChuUser);
        layoutRau = view.findViewById(R.id.layoutRauTrangChuUser);
        tvName = view.findViewById(R.id.tvNameTrangChuUser);
        viewPager2 = view.findViewById(R.id.viewPager2TrangChuUser);
        circleIndicator3 = view.findViewById(R.id.ci3);
        recyclerView = view.findViewById(R.id.rcvTrangChuUser);

        sanPhamTrangChuDAO = new SanPhamTrangChuDAO(getContext());
        //Hiển thi tên tài khoản
        String tenDangNhap = requireActivity().getIntent().getStringExtra("tenDangNhap");
        tvName.setText("Hi, "+tenDangNhap);

        //Khởi tạo adapter Cho slideShow
        AdapterSliderTrangChuUser userAdapter = new AdapterSliderTrangChuUser(getData());
        viewPager2.setAdapter(userAdapter);
        circleIndicator3.setViewPager(viewPager2);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setClipChildren(false);
        viewPager2.setClipToPadding(false);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(2));
        viewPager2.setPageTransformer(compositePageTransformer);
        //setOnclick cho textView xem them
        tvXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUseActivity.class));
//                getActivity().finish();
            }
        });
        layoutCu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUseActivity.class));
//                getActivity().finish();
            }
        });
        layoutRau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUseActivity.class));
//                getActivity().finish();

            }
        });

        layoutHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), DanhSachSanPhamUseActivity.class));
//                getActivity().finish();

            }
        });
        layoutQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DanhSachSanPhamUseActivity.class));
//                getActivity().finish();

            }
        });

        //Set Data mẫu

        list = sanPhamTrangChuDAO.getAll();
        adapterTrangChuUser = new AdapterTrangChuUser(getContext(),list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapterTrangChuUser);
        super.onViewCreated(view, savedInstanceState);
    }
    private List<SanPhamTrangChuUserDTO> getDataSanPham() {
        List<SanPhamTrangChuUserDTO> list = new ArrayList<>();

        return list;
    }
    private List<SliderDTO> getData() {
        List<SliderDTO> list = new ArrayList<>();
        list.add(new SliderDTO(R.drawable.img_slider9));
        list.add(new SliderDTO(R.drawable.img_slider8));
        list.add(new SliderDTO(R.drawable.img_slider1));
        list.add(new SliderDTO(R.drawable.img_slider5));
        list.add(new SliderDTO(R.drawable.img_slider6));
        list.add(new SliderDTO(R.drawable.img_slider7));
        return list;
    }
}