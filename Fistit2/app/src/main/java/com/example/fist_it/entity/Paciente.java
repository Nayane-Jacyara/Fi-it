package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(tableName = "Paciente")
public class Paciente extends Usuario{

    @ColumnInfo(name = "numero")
    private long numero;
    @ColumnInfo(name = "endereco")
    private String endereco;

    /*@ColumnInfo(name = "historico_medico")
    private String historicoMedico;*/

    public Paciente(String nome, String email, String senha, long numero, String endereco) {
        super(nome, email, senha);
        this.numero = numero;
        this.endereco = endereco;

    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
