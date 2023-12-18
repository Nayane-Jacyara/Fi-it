package com.example.fist_it.BancoDeDados;

import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.fist_it.Dao.ClinicaDao;
import com.example.fist_it.Dao.MedicoDao;
import com.example.fist_it.entity.Clinica;
import com.example.fist_it.entity.Converters;
import com.example.fist_it.entity.Medico;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@androidx.room.Database(entities = {Clinica.class, Medico.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract ClinicaDao clinicaDao();

    public abstract MedicoDao medicoDao();

    private static final String DATABASE_NAME = "fit-it";

    public void initializeClinicas() {
        ClinicaDao clinicaDao = this.clinicaDao();

        Clinica clinica1 = new Clinica("Clinica A", "Rua A", "Capoeiras", 123456789);
        Clinica clinica2 = new Clinica("Clinica B", "Rua B", "Garanhuns", 987654321);

        clinicaDao.insert(clinica1);
        clinicaDao.insert(clinica2);
    }

    // Método para inicializar dados de exemplo de médicos
    public void initializeMedicos() {
        MedicoDao medicoDao = this.medicoDao();
        ClinicaDao clinicaDao = this.clinicaDao();

        // Recupera a lista de clínicas cadastradas no banco de dados
        List<Clinica> clinicas = clinicaDao.getAll();

        if (clinicas != null && !clinicas.isEmpty()) {
            Clinica clinica1 = clinicas.get(0);
            Clinica clinica2 = clinicas.get(1);

            Map<Date, List<String>> datasHorariosMedico1 = new HashMap<>();
            // Adiciona datas e horários para o médico 1
            Date data1Medico1 = new Date(20/12/2023); // Use a data desejada
            List<String> horarios1Medico1 = new ArrayList<>();
            horarios1Medico1.add("08:00");
            horarios1Medico1.add("10:00");
            datasHorariosMedico1.put(data1Medico1, horarios1Medico1);

            Map<Date, List<String>> datasHorariosMedico2 = new HashMap<>();
            Date data1Medico2 = new Date(25/12/2023);
            List<String> horarios1Medico2 = new ArrayList<>();
            horarios1Medico2.add("08:00");
            horarios1Medico2.add("10:00");
            datasHorariosMedico1.put(data1Medico2, horarios1Medico2);

            Map<Date, List<String>> datasHorariosMedico3 = new HashMap<>();
            Date data1Medico3 = new Date(24/12/2023);
            List<String> horarios1Medico3 = new ArrayList<>();
            horarios1Medico2.add("08:00");
            horarios1Medico2.add("10:00");
            datasHorariosMedico1.put(data1Medico3, horarios1Medico3);

            // Adiciona médicos relacionados a cada clínica
            Medico medico1 = new Medico(0, clinica1.getClinicaId(), "Dr. Médico 1", "Especialidade 1", 12345, 100.0, datasHorariosMedico1);
            Medico medico2 = new Medico(0, clinica1.getClinicaId(), "Dr. Médico 2", "Especialidade 2", 67890, 150.0, datasHorariosMedico2);
            Medico medico3 = new Medico(0, clinica2.getClinicaId(), "Dr. Médico 3", "Especialidade 3", 54321, 200.0, datasHorariosMedico3);

            medicoDao.insert(medico1, medico2, medico3);
        }
    }
}

