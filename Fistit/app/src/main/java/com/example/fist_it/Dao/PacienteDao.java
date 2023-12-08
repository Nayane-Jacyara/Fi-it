package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fist_it.entity.Admin;
import com.example.fist_it.entity.Paciente;
import com.example.fist_it.entity.Usuario;

import java.util.List;

@Dao
public interface PacienteDao {
    @Query("SELECT * FROM Paciente")
    List<Paciente> getAll();

    @Query("SELECT * FROM Paciente WHERE user_id = :userId")
    List<Paciente> loadAllByIds(int userId);

    @Insert
    void insert(Paciente... pacientes);
    @Insert
    void insertAll(Paciente... pacientes);
    @Update
    void update(Paciente...pacientes);
    @Delete
    void delete(Paciente paciente);
    // Outros métodos, se necessários, para operações relacionadas a Paciente
}
