package com.example.didongcuoiki;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.example.didongcuoiki.Adapter.CategoRySpinnerAdapter;
import com.example.didongcuoiki.DTO.Category;
public class ThemSanPhamAdmin extends AppCompatActivity {
    private Spinner spnCategoryAddSp;
    private CategoRySpinnerAdapter categoRySpinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham_admin);

        spnCategoryAddSp = findViewById(R.id.spnCategoryAddSp);

        categoRySpinnerAdapter = new CategoRySpinnerAdapter(this, R.layout.item_selected_themsp, getListCategory());
        spnCategoryAddSp.setAdapter(categoRySpinnerAdapter);
        spnCategoryAddSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ThemSanPhamAdmin.this, categoRySpinnerAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private List<Category> getListCategory() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Rau"));
        list.add(new Category("Củ"));
        list.add(new Category("Quả"));
        return list;
    }
}