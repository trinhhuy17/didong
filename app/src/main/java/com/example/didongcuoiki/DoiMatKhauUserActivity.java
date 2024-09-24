package com.example.didongcuoiki;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
public class DoiMatKhauUserActivity extends AppCompatActivity {
    Toolbar toolbarQuenPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau_user);
        toolbarQuenPass = findViewById(R.id.toolBar_quen_pass);
        setSupportActionBar(toolbarQuenPass);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}