package com.example.fist_it.entity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Administrador")
public class Admin extends Usuario {

    public Admin(String nome, String email, String senha) {
        super(nome, email, senha);
    }
}
