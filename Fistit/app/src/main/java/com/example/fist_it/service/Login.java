package com.example.fist_it.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fist_it.BancoDeDados.Database;
import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentLoginBinding;
import com.example.fist_it.databinding.FragmentTelaInicialBinding;
import com.example.fist_it.entity.Admin;
import com.example.fist_it.entity.Paciente;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Login extends Fragment {
    private FragmentLoginBinding binding;
    private Database db;

    public Login() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.buttonAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.editTextTextEmailAddress.getText().toString();
                String senha = binding.editTextTextPassword2.getText().toString();
                db = Room.databaseBuilder(requireContext(), Database.class, "Fit-it").allowMainThreadQueries().build();
                Bundle bundle = new Bundle();

                if (!email.isEmpty() && !senha.isEmpty()) {
                    List<Paciente> pacientes = db.pacienteDao().getAll();
                    List<Admin> admins = db.adminDao().getAll();
                    boolean achouPaciente = false;
                    boolean achouAdmin = false;

                    for (Paciente paciente : pacientes) {
                        if (paciente.getEmail().equals(email) && paciente.getSenha().equals(senha)) {
                            achouPaciente = true;
                            bundle.putString("usuario", paciente.getNome());
                            Navigation.findNavController(v).navigate(R.id.action_login_to_home3, bundle);
                            return;
                        }
                    }

                    for (Admin admin : admins) {
                        if (admin.getEmail().equals(email) && admin.getSenha().equals(senha)) {
                            achouAdmin = true;
                            bundle.putString("usuario", admin.getNome());
                            Navigation.findNavController(v).navigate(R.id.action_login_to_home3, bundle);
                            return;
                        }
                    }

                    if (!achouPaciente && !achouAdmin) {
                        Snackbar.make(v, "Senha ou usuário incorreto", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                    }
                } else {
                    Snackbar.make(v, "Por favor, preencha todos os campos", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }
            }
        });

        binding.textCriarConta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login_to_cadastro));
        return binding.getRoot();
    }
}