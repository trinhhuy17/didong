package com.example.didongcuoiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
public class DiaChiActivity extends AppCompatActivity {
    RecyclerView recyclerDiaChi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi);
        recyclerDiaChi = findViewById(R.id.recyclerDiaChi);
    }
}