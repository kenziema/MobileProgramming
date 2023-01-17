package com.uts.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.uts.finalproject.adapter.ProductAdapter;
import com.uts.finalproject.adapter.ProductCategoryAdapter;
import com.uts.finalproject.databinding.ActivityMainBinding;
import com.uts.finalproject.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView categoryRecycle, productRecycle;
    List<ProductData> productList;

    ProductAdapter adapter;
    ProductData productData;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

//        setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Man", R.drawable.ic_men));
        productCategoryList.add(new ProductCategory(2, "Woman", R.drawable.ic_women));
        productCategoryList.add(new ProductCategory(3, "Electronic", R.drawable.ic_electric));
        productCategoryList.add(new ProductCategory(4, "F&B", R.drawable.ic_food));

        setCategoryRecycler(productCategoryList);


        productRecycle = findViewById(R.id.productMain_recyclerView);
        searchView = findViewById(R.id.search);

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
        productRecycle.setLayoutManager(gridLayoutManager);
        productList = new ArrayList<>();

        productData = new ProductData("Kemeja Flanel", "IDR 45.000", "Flannel Based", R.drawable.kemeja_flanel);
        productList.add(productData);

        productData = new ProductData("Kemeja Biru", "IDR 35.000", "Cotton Based", R.drawable.kemeja_biru);
        productList.add(productData);

        productData = new ProductData("Hoodie Berbulu", "IDR 125.000", "Fleece Based", R.drawable.hoodie_fleece);
        productList.add(productData);

        productData = new ProductData("Hoodie Pink", "IDR 39.000", "Cotton Based", R.drawable.hoodie_pink_cotton);
        productList.add(productData);

        productData = new ProductData("Celana Training", "IDR 89.000", "Sweatpants", R.drawable.celana_training);
        productList.add(productData);

        productData = new ProductData("Rujak Cireng", "IDR 21.000", "Cireng frozen yang perlu di goreng untuk dapat dimakan", R.drawable.rujak_cireng);
        productList.add(productData);

        productData = new ProductData("Brownies", "IDR 42.000", "Brownies panggang yang memiliki tekstur fudgy serta topping yang dapat dikreasikan", R.drawable.brownies);
        productList.add(productData);

        adapter = new ProductAdapter(MainActivity.this, productList);
        productRecycle.setAdapter(adapter);


        replaceFragment(new HomeFragment());
        binding.bottomNav.setBackground(null);

        binding.bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;

                case R.id.transaction:
                    replaceFragment(new TransactionFragment());
                    break;
            }
            return true;
        });
    }

    private void setCategoryRecycler(List<ProductCategory> productCategoryList){

        categoryRecycle = findViewById(R.id.category_recyclerView);
        RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycle.setLayoutManager(layoutmanager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        categoryRecycle.setAdapter(productCategoryAdapter);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottomNav, fragment);
        fragmentTransaction.commit();
    }

    private void searchList(String text){
        List<ProductData> productSearchList = new ArrayList<>();
        for(ProductData data : productList){
            if(data.getProdName().toLowerCase().contains(text.toLowerCase())){
                productSearchList.add(data);
            }
        }
        if(productSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        }else {
            adapter.setSearchList(productSearchList);
        }
    }

}