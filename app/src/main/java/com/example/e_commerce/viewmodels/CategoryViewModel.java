package com.example.e_commerce.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.e_commerce.models.CartItem;
import com.example.e_commerce.models.Products;
import com.example.e_commerce.repositories.CartRepo;
import com.example.e_commerce.repositories.CategoryRepo;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    CategoryRepo shopRepo = new CategoryRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Products> mutableProduct = new MutableLiveData<>();

    public LiveData<List<Products>> getProducts() {
        return shopRepo.getProducts();
    }

    public void setProduct(Products product) {
        mutableProduct.setValue(product);
    }

    public LiveData<Products> getProduct() {
        return mutableProduct;
    }

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Products product) {
        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }
}
