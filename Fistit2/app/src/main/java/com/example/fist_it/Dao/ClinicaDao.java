package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.fist_it.entity.Clinica;

import java.util.List;

@Dao
public interface ClinicaDao {

    @Query("SELECT * FROM Clinica WHERE cidade LIKE :cidade")
    List<Clinica> findByAddress(String cidade);


    @Query("SELECT * FROM Clinica")
    List<Clinica> getAll(); // Método para obter todas as clínica

    @Insert
    void insert(Clinica... clinicas);

    @Update
    void update(Clinica... clinicas);

    @Delete
    void delete(Clinica clinica);

}
