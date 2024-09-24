package com.example.didongcuoiki.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.example.didongcuoiki.MainActivity;
import com.example.didongcuoiki.R;
import com.example.didongcuoiki.XacNhanTaiKhoanActivity;
public class FragLogin extends Fragment {
    private TextView tvQuenMatKhau;
    private AppCompatButton btnDangNhap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_login,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvQuenMatKhau = view.findViewById(R.id.tvQuenMatKhau);
        btnDangNhap = view.findViewById(R.id.btnLogin);
        tvQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), XacNhanTaiKhoanActivity.class));
                getActivity().finish();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}