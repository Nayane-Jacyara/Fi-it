package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fist_it.entity.Medico;
import com.example.fist_it.entity.Usuario;

import java.util.List;

@Dao
public interface MedicoDao {
    @Query("SELECT * FROM Medico")
    List<Medico> getAll();

    @Query("SELECT * FROM Medico WHERE medico_id IN (:medicoIds)")
    List<Medico> loadAllByIds(int[] medicoIds);

    @Insert
    void insertAll(Medico... medicos);

    @Update
    void update(Medico... medicos);

    @Delete
    void delete(Medico medico);
    // Outros métodos, se necessários, para operações relacionadas a Medico
}
