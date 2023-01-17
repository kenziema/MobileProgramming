package com.uts.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    TextView detailDesc, detailName, detailPrice;
    ImageView detailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        detailDesc = findViewById(R.id.detailDesc);
        detailName = findViewById(R.id.detailName);
        detailPrice = findViewById(R.id.detailPrice);
        detailImg = findViewById(R.id.detailImg);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText(bundle.getString("Desc"));
            detailImg.setImageResource(bundle.getInt("Image"));
            detailName.setText(bundle.getString("Name"));
            detailPrice.setText(bundle.getString("Price"));

        }
    }
}