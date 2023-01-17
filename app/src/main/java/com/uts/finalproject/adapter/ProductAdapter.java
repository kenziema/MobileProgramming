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

import com.uts.finalproject.ProductData;
import com.uts.finalproject.ProductDetailsActivity;
import com.uts.finalproject.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private Context context;
    private List<ProductData> productList;

    public void setSearchList(List<ProductData> productSearchList){
        this.productList = productSearchList;
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context, List<ProductData> productList){
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ProductViewHolder(view);

//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View prodView = inflater.inflate(R.layout.recycler_item, parent, false);
//        ProductViewHolder productViewHolder = new ProductViewHolder(prodView);
//        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.prodImg.setImageResource(productList.get(position).getProdImg());
        holder.prodName.setText(productList.get(position).getProdName());
        holder.prodPrice.setText(productList.get(position).getProdPrice());
        holder.prodDescription.setText(productList.get(position).getProdName());

        holder.prodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);

//                intent.putExtra("Image", productList.get(holder.getAbsoluteAdapterPosition()).getProdImg());
//                intent.putExtra("Name", productList.get(holder.getAbsoluteAdapterPosition()).getProdName());
//                intent.putExtra("Price", productList.get(holder.getAbsoluteAdapterPosition()).getProdPrice());
//                intent.putExtra("Description", productList.get(holder.getAbsoluteAdapterPosition()).getProdDescription());

                intent.putExtra("Image", productList.get(holder.getBindingAdapterPosition()).getProdImg());
                intent.putExtra("Name", productList.get(holder.getBindingAdapterPosition()).getProdName());
                intent.putExtra("Price", productList.get(holder.getBindingAdapterPosition()).getProdPrice());
                intent.putExtra("Desc", productList.get(holder.getBindingAdapterPosition()).getProdDescription());

//                intent.putExtra("Image", productList.get(position).getProdImg());
//                intent.putExtra("Name", productList.get(position).getProdName());
//                intent.putExtra("Price", productList.get(position).getProdPrice());
//                intent.putExtra("Description", productList.get(position).getProdDescription());

                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }
}


class ProductViewHolder extends RecyclerView.ViewHolder{

    ImageView prodImg;
    TextView prodName, prodDescription, prodPrice;
    CardView prodCard;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        prodImg = itemView.findViewById(R.id.prodImg);
        prodName = itemView.findViewById(R.id.prodName);
        prodDescription = itemView.findViewById(R.id.prodDescription);
        prodPrice = itemView.findViewById(R.id.prodPrice);
        prodCard = itemView.findViewById(R.id.prodCard);
    }
}