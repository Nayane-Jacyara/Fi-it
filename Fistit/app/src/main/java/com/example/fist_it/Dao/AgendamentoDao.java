package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fist_it.entity.Agendamento;

import java.util.List;

@Dao
public interface AgendamentoDao {
    @Query("SELECT * FROM Agendamento")
    List<Agendamento> getAll();

    @Query("SELECT * FROM Agendamento WHERE id IN (:agendamentoIds)")
    List<Agendamento> loadAllByIds(int[] agendamentoIds);

    @Insert
    void insertAll(Agendamento... agendamentos);

    @Delete
    void delete(Agendamento agendamento);
    // Outros métodos, se necessários, para operações relacionadas a Agendamento
}
