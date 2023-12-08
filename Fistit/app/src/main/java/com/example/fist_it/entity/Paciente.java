package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity(tableName = "Paciente")
public class Paciente extends Usuario{

    @ColumnInfo(name = "numero")
    private int numero;
    @ColumnInfo(name = "endereco")
    private String endereco;

    /*@ColumnInfo(name = "historico_medico")
    private String historicoMedico;*/

    public Paciente(String nome, String email, String senha, String endereco, int numero) {
        super(nome, email, senha);
        this.numero = numero;
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

  /* public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }
    */
}
