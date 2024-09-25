package com.example.didongcuoiki;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
public class ViCuaToiActivity extends AppCompatActivity {
    private ImageView imgBackViCuaToi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_cua_toi);
        imgBackViCuaToi = findViewById(R.id.imgBackViCuaToi);
        imgBackViCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}