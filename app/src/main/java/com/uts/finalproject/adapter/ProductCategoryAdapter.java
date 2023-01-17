package com.uts.finalproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.uts.finalproject.Category;
import com.uts.finalproject.R;
import com.uts.finalproject.model.ProductCategory;

import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.CategoryViewHolder> {

    List<ProductCategory> productCategoryList;

    public ProductCategoryAdapter(Context context, List<ProductCategory> productCategoryList) {

        this.productCategoryList = productCategoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View catView = inflater.inflate(R.layout.category_row, parent, false);
        CategoryViewHolder catViewHolder = new CategoryViewHolder(catView);
        return catViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryName.setText(productCategoryList.get(position).getProductName());
        holder.categoryImage.setImageResource(productCategoryList.get(position).getImageUrl());
        holder.categoryCard.getContext();

        holder.categoryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Category.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productCategoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;
        ImageView categoryImage;
        CardView categoryCard;

        public CategoryViewHolder(@NonNull View CatView){
            super(CatView);
            this.categoryName = itemView.findViewById(R.id.cat_name);
            this.categoryImage = itemView.findViewById(R.id.cat_img);
            this.categoryCard = itemView.findViewById(R.id.cat_card);
        }
    }


}
