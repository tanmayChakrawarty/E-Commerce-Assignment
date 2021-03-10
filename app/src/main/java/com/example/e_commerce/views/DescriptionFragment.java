package com.example.e_commerce.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_commerce.R;
import com.example.e_commerce.databinding.FragmentDescriptionBinding;
import com.example.e_commerce.viewmodels.CategoryViewModel;

public class DescriptionFragment extends Fragment {

    FragmentDescriptionBinding fragmentDescriptionBinding;
    CategoryViewModel shopViewModel;

    public DescriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_description, container, false);
        fragmentDescriptionBinding = FragmentDescriptionBinding.inflate(inflater, container, false);
        return fragmentDescriptionBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shopViewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);
        fragmentDescriptionBinding.setShopViewModel(shopViewModel);
    }
}