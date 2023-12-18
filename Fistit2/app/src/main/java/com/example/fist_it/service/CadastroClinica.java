package com.example.fist_it.service;

import android.os.Bundle;

import androidx.collection.CircularIntArray;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fist_it.BancoDeDados.Database;
import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentCadastroClinicaBinding;
import com.example.fist_it.entity.Admin;
import com.example.fist_it.entity.Clinica;
import com.example.fist_it.entity.Paciente;
import com.google.android.material.snackbar.Snackbar;

public class CadastroClinica extends Fragment {

    private FragmentCadastroClinicaBinding binding;
    private Database db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastroClinicaBinding.inflate(inflater, container, false);
        db = Room.databaseBuilder(requireContext(), Database.class, "Fit-it").allowMainThreadQueries().build();

        binding.buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeClinica = binding.TextNome.getText().toString();
                String cidade = binding.TextCidade.getText().toString();
                String rua = binding.textRua.getText().toString();
                String telefone = binding.TextPhone.getText().toString();
                if (!nomeClinica.isEmpty() && !cidade.isEmpty() && !rua.isEmpty() && !telefone.isEmpty()) {
                    Clinica clinica = new Clinica(nomeClinica,rua,cidade, Long.parseLong(telefone));
                    db.clinicaDao().insert(clinica);
                    Navigation.findNavController(v).navigate(R.id.homeClinica);
                } else {
                    // Error
                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }
            }
        });

        return binding.getRoot();
    }
}
