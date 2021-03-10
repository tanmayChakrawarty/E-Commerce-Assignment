package com.example.e_commerce.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerce.R;
import com.example.e_commerce.adapters.ShopListAdapter;
import com.example.e_commerce.databinding.FragmentCategoryBinding;
import com.example.e_commerce.models.Products;
import com.example.e_commerce.viewmodels.CategoryViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CategoryFragment extends Fragment implements ShopListAdapter.ShopInterface {

    private static final String TAG = "ShopFragment";
    FragmentCategoryBinding fragmentCategoryBinding;
    private ShopListAdapter shopListAdapter;
    private CategoryViewModel shopViewModel;
    private NavController navController;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_category, container, false);
        fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater,container,false);
        return fragmentCategoryBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopListAdapter = new ShopListAdapter(this);
        fragmentCategoryBinding.categoryRecyclerView.setAdapter(shopListAdapter);
        fragmentCategoryBinding.categoryRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentCategoryBinding.categoryRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));

        shopViewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Products>>() {
            @Override
            public void onChanged(List<Products> products) {
                shopListAdapter.submitList(products);
            }
        });

        navController = Navigation.findNavController(view);

    }

    @Override
    public void addItem(Products product) {
        boolean isAdded = shopViewModel.addItemToCart(product);
        if (isAdded) {
            Snackbar.make(requireView(), product.getName() + " added to cart.", Snackbar.LENGTH_LONG)
                    .setAction("Checkout", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            navController.navigate(R.id.action_categoryFragment_to_cartFragment);
                        }
                    })
                    .show();
        } else {
            Snackbar.make(requireView(), "Already have the max quantity in cart.", Snackbar.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onItemClick(Products product) {
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_categoryFragment_to_descriptionFragment);
    }
}