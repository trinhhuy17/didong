package com.example.didongcuoiki.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.didongcuoiki.DTO.FoodTrangChuAdmin;
import com.example.didongcuoiki.R;
public class AdapterFoodAdmin extends RecyclerView.Adapter<AdapterFoodAdmin.FoodViewHolder> {
    private List<FoodTrangChuAdmin> foodTrangChuAdminList;
    public AdapterFoodAdmin(List<FoodTrangChuAdmin> foodTrangChuAdminList) {
        this.foodTrangChuAdminList = foodTrangChuAdminList;
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_trang_chu_admin, parent, false);
        return new FoodViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodTrangChuAdmin foodTrangChuAdmin = foodTrangChuAdminList.get(position);
        if (foodTrangChuAdmin == null){
            return;
        }
        holder.imgFoodAdmin.setImageResource(foodTrangChuAdmin.getImgFoodAdmin());
        holder.txtNameFood.setText(foodTrangChuAdmin.getFoodNameAdmin());
        holder.txtPriceFood.setText(foodTrangChuAdmin.getFoodPriceAdmin());
    }
    @Override
    public int getItemCount() {
        if (foodTrangChuAdminList != null){
            return foodTrangChuAdminList.size();
        }
        return 0;
    }
    public class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoodAdmin;
        private TextView txtNameFood;
        private TextView txtPriceFood;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoodAdmin = itemView.findViewById(R.id.img_food_admin);
            txtNameFood = itemView.findViewById(R.id.txtNameFoodAdmin);
            txtPriceFood = itemView.findViewById(R.id.txtPriceFoodAdmin);
        }
    }
}
