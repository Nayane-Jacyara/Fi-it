package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fist_it.entity.Clinica;
import com.example.fist_it.entity.Medico;

import java.util.List;

@Dao
public interface ClinicaDao {
    @Query("SELECT * FROM Clinica")
    List<Clinica> getAll();

    @Query("SELECT * FROM Clinica WHERE id IN (:clinicaIds)")
    List<Clinica> loadAllByIds(int[] clinicaIds);

    @Insert
    void insertAll(Clinica... clinicas);

    @Update
    void update(Clinica... clinicas);

    @Delete
    void delete(Clinica clinica);
    // Outros métodos, se necessários, para operações relacionadas a Clinica
}
