package com.example.fist_it.service;

import android.os.Binder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fist_it.BancoDeDados.Database;
import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentCadastroBinding;
import com.example.fist_it.entity.Admin;
import com.example.fist_it.entity.Paciente;
import com.google.android.material.snackbar.Snackbar;

public class Cadastro extends Fragment {
    private FragmentCadastroBinding binding;
    private Database db;
    public Cadastro() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastroBinding.inflate(inflater, container, false);
        db = Room.databaseBuilder(requireContext(), Database.class, "Fit-it").allowMainThreadQueries().build();

        binding.textJaTemConta.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_cadastro_to_login));

        binding.buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = binding.TextNome.getText().toString();
                String cidade = binding.TextCidade.getText().toString();
                String telefone = binding.TextPhone.getText().toString();
                String email = binding.editTextTextEmailAddress2.getText().toString();
                String senha = binding.TextSenha.getText().toString();

                boolean checkBox1Checked = binding.boxPaciente.isChecked();
                boolean checkBox2Checked = binding.boxClinica.isChecked();

                if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !cidade.isEmpty() && !telefone.isEmpty()) {
                    if (checkBox1Checked) {
                        // Criar paciente
                        Paciente paciente = new Paciente(nome, email, senha, Long.parseLong(telefone), cidade);
                        db.pacienteDao().insert(paciente);
                        Navigation.findNavController(v).navigate(R.id.login);
                    } else if (checkBox2Checked) {
                        // Criar admin
                        Admin admin = new Admin(nome, email, senha);
                        db.adminDao().insert(admin);
                        Navigation.findNavController(v).navigate(R.id.login);
                    } else {
                        // Error
                        Snackbar.make(v, "Erro ao cadastrar", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                    }
                } else {
                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null)
                            .show();
                }
            }
        });

        return binding.getRoot();
    }
}
