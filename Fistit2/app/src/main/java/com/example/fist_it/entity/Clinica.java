package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

@Entity
public class Clinica {

    @PrimaryKey
    @ColumnInfo(name = "clinica_id")
    private int clinicaId;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "rua")
    private String rua;

    @ColumnInfo(name = "cidade")
    private String cidade;

    @ColumnInfo(name = "contato")
    private long contato;

    public Clinica(String nome, String rua, String cidade, long contato) {
        this.clinicaId = clinicaId;
        this.nome = nome;
        this.rua = rua;
        this.cidade = cidade;
        this.contato = contato;

    }

    public int getClinicaId() {
        return clinicaId;
    }

    public void setClinicaId(int clinicaId) {
        this.clinicaId = clinicaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getContato() {
        return contato;
    }

    public void setContato(long contato) {
        this.contato = contato;
    }
}