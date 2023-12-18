package com.example.fist_it.BancoDeDados;

import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.fist_it.Dao.AdminDao;
import com.example.fist_it.Dao.AgendamentoDao;
import com.example.fist_it.Dao.ClinicaDao;
import com.example.fist_it.Dao.MedicoDao;
import com.example.fist_it.Dao.PacienteDao;
import com.example.fist_it.Dao.UsuarioDao;
import com.example.fist_it.entity.Admin;
import com.example.fist_it.entity.Agendamento;
import com.example.fist_it.entity.Clinica;
import com.example.fist_it.entity.Converters;
import com.example.fist_it.entity.Medico;
import com.example.fist_it.entity.Paciente;
import com.example.fist_it.entity.Usuario;

@androidx.room.Database(entities = {Usuario.class,Paciente.class,Medico.class, Clinica.class,
        Admin.class, Agendamento.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class Database extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();
    public abstract PacienteDao pacienteDao();
    public abstract AdminDao adminDao();
    public abstract MedicoDao medicoDao();
    public abstract ClinicaDao clinicaDao();
    public  abstract AgendamentoDao agendamentoDao();

}
