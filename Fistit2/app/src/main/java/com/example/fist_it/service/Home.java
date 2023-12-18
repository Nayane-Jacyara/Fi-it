package com.example.fist_it.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fist_it.BancoDeDados.Database;
import com.example.fist_it.Dao.ClinicaDao;
import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentHomeBinding;
import com.example.fist_it.databinding.FragmentTelaInicialBinding;
import com.example.fist_it.entity.Clinica;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private FragmentHomeBinding binding;

    public Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.agenda.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_home3_to_reservas));
        binding.perfil.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_home3_to_perfil3));
        return binding.getRoot();
    }
}