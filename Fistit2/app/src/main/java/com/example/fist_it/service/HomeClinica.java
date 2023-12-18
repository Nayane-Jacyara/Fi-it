package com.example.fist_it.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentHomeBinding;
import com.example.fist_it.databinding.FragmentHomeClinicaBinding;


public class HomeClinica extends Fragment {

    private FragmentHomeClinicaBinding binding;

    public HomeClinica() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeClinicaBinding.inflate(inflater, container, false);
        binding.getRoot();


        binding.buttonClinica.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeClinica_to_cadastroClinica));
        binding.buttonAddMedico.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeClinica_to_cadastroMedico));
        binding.buttonListaDeMedico.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeClinica_to_listaDosMedicos));
        binding.perfil4.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeClinica_to_perfilClinica));
        binding.agenda4.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeClinica_to_agendaDaClinica));
        return binding.getRoot();
    }
}
