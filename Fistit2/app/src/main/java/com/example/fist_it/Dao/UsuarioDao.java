package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fist_it.entity.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM Usuario")
    List<Usuario> getAll();
    @Query("SELECT * FROM Usuario WHERE nome LIKE :nome limit 1")
    Usuario findByName(String nome);
    @Insert
    void insert(Usuario... usuarios);
    @Insert
    void insertAll(List<Usuario> usuarios);

    @Update
    void update(Usuario... usuarios);
    @Delete
    void delete(Usuario usuario);
}
