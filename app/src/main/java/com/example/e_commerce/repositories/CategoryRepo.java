package com.example.e_commerce.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.e_commerce.models.Products;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryRepo {

    private MutableLiveData<List<Products>> mutableProductList;

    public LiveData<List<Products>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Products> productList = new ArrayList<>();
        productList.add(new Products(UUID.randomUUID().toString(), "iMac 21", 1299, true, "https://images.app.goo.gl/ePooEPKFbxuF42yR9"));
        productList.add(new Products(UUID.randomUUID().toString(), "iPad Air", 799, true, "https://images.app.goo.gl/eeGkeAQyX1hN4ocAA"));
        productList.add(new Products(UUID.randomUUID().toString(), "iPad Pro", 999, true, "https://images.app.goo.gl/x8UwHNgt5SiJEndC6"));
        productList.add(new Products(UUID.randomUUID().toString(), "iPhone 11", 699, false, "https://images.app.goo.gl/BMex9fnRp2CBAZ2J8"));
        productList.add(new Products(UUID.randomUUID().toString(), "iPhone 11 Pro", 999, true, "https://images.app.goo.gl/ctEkk22xVZgyecFbA"));
        productList.add(new Products(UUID.randomUUID().toString(), "iPhone 11 Pro Max", 1099, true, "https://images.app.goo.gl/sXpUNSMB2d3GwAX77"));
        productList.add(new Products(UUID.randomUUID().toString(), "iPhone SE", 399, true, "https://images.app.goo.gl/RwD7wNaXVPkWUCNe8"));
        productList.add(new Products(UUID.randomUUID().toString(), "MacBook Air", 999, true, "https://images.app.goo.gl/wCKtvaTmLZbipsea8"));
        productList.add(new Products(UUID.randomUUID().toString(), "MacBook Pro 13", 1299, true, "https://images.app.goo.gl/tUwBiYdRHCwxL5HD7"));
        productList.add(new Products(UUID.randomUUID().toString(), "MacBook Pro 16", 2399, true, "https://images.app.goo.gl/KR68kqBPQB5DoJsN7"));
    }
    }

