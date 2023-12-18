package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.fist_it.entity.Medico;

import java.util.Date;
import java.util.List;

@Dao
public interface MedicoDao {
    @Query("SELECT * FROM Medico")
    List<Medico> getAll();

    @Query("SELECT * FROM Medico WHERE medico_id IN (:medicoIds)")
    List<Medico> loadAllByIds(int[] medicoIds);

    @Transaction
    @Query("SELECT * FROM Medico WHERE medico_id = :medicoId")
    Medico getClinicasByMedicoId(int medicoId);

    @Query("SELECT * FROM Medico WHERE datas_e_horarios_disponiveis LIKE :data")
    List<Medico> findByDate(Date data);

    @Query("SELECT * FROM Medico WHERE :dateTime BETWEEN :startDate AND :endDate")
    List<Medico> findMedicosAvailableBetweenDates(long dateTime, long startDate, long endDate);

    @Insert
    void insert(Medico... medicos);

    @Update
    void update(Medico... medicos);

    @Delete
    void delete(Medico medico);
}
