package com.example.fist_it.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentReservasBinding;
import com.example.fist_it.databinding.FragmentTelaInicialBinding;

public class Reservas extends Fragment {
    private FragmentReservasBinding binding;

    public Reservas() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReservasBinding.inflate(inflater,container,false);

        binding.home2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_reservas_to_home3));
        binding.perfil2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_reservas_to_perfil3));

        return binding.getRoot();
    }
}