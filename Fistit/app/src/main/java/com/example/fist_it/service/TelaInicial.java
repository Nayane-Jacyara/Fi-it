package com.example.fist_it.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentTelaInicialBinding;

public class TelaInicial extends Fragment {
    private FragmentTelaInicialBinding binding;

    public TelaInicial() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTelaInicialBinding.inflate(inflater,container,false);

        binding.buttonLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaInicial_to_login));
        binding.buttonCriarConta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_telaInicial_to_cadastro));

        return binding.getRoot();
    }
}