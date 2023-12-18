package com.example.fist_it.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.fist_it.entity.Admin;
import com.example.fist_it.entity.Usuario;

import java.util.List;

@Dao
public interface AdminDao {
    @Query("SELECT * FROM Administrador")
    List<Admin> getAll();

    @Query("SELECT * FROM Administrador WHERE user_id = :userId")
    List<Admin> getAdminsByUserId(int userId);
    @Insert
    void insert(Admin... admins);
    @Insert
    void insertAll(Admin... admins);

    @Delete
    void delete(Admin admin);
    // Outros métodos, se necessários, para operações relacionadas a Admin
}
