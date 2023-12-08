package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Clinica")
public class Clinica {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "endereco")
    private String endereco;
    @ColumnInfo(name = "contato")
    private int contato;

    public Clinica(String nome, String endereco, int contato) {
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getContato() {
        return contato;
    }

    public void setContato(int contato) {
        this.contato = contato;
    }
}
