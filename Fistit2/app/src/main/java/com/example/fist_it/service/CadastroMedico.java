package com.example.fist_it.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.example.fist_it.BancoDeDados.Database;
import com.example.fist_it.R;
import com.example.fist_it.databinding.FragmentCadastroMedicoBinding;
import com.example.fist_it.entity.Medico;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroMedico extends Fragment {

    private FragmentCadastroMedicoBinding binding;
    private Database db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastroMedicoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        db = Room.databaseBuilder(requireContext(), Database.class, "Fit-it").allowMainThreadQueries().build();

        binding.buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = binding.TextNome.getText().toString();
                String especialidade = binding.TextCidade.getText().toString();
                int CRM = Integer.parseInt(binding.editTextCRM.getText().toString());
                double valorConsulta = Double.parseDouble(binding.editTextValor.getText().toString());
                String dataString = binding.editTextData.getText().toString();
                String horaString = binding.editTextTime.getText().toString();

                Date dataDisponivel = null;
                String horaDisponivel = null;


                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    dataDisponivel = dateFormat.parse(dataString);

                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    horaDisponivel = timeFormat.format(timeFormat.parse(horaString));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (dataDisponivel != null && horaDisponivel != null) {
                    Map<Date, List<String>> datasEHorarios = new HashMap<>();
                    List<String> horarios = new ArrayList<>();
                    horarios.add(horaDisponivel);
                    datasEHorarios.put(dataDisponivel, horarios);

                    if (!nome.isEmpty() && !especialidade.isEmpty()) {
                        Medico medico = new Medico(0, 0, nome, especialidade, CRM, valorConsulta, datasEHorarios);
                        // Verifica se já há uma lista de horários disponíveis para a data selecionada
                        List<String> novosHorarios = medico.getDatasEHorariosDisponiveis().get(dataDisponivel);
                        if (novosHorarios == null) {
                            novosHorarios = new ArrayList<>();
                        }
                        // Adiciona o horário disponível à lista de horários
                        novosHorarios.add(horaDisponivel);
                        // Atualiza o mapa com a nova lista de horários
                        medico.getDatasEHorariosDisponiveis().put(dataDisponivel, novosHorarios);

                        db.medicoDao().insert(medico);
                        Navigation.findNavController(v).navigate(R.id.homeClinica);
                    } else {
                        // Error
                        Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null)
                                .show();
                    }
                }
            }
        });

        return view;
    }
}
