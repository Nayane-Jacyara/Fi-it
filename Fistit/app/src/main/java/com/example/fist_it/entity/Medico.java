package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Medico {
    @PrimaryKey
    @ColumnInfo(name = "medico_id")
    private int medicoId;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "especializacao")
    private String especializacao;
    @ColumnInfo(name = "CRM")
    private int CRM;
    @ColumnInfo(name = "valorConsulta")
    private double valorConsulta;

    public Medico(int medicoId, String nome, String especializacao, int CRM, double valorConsulta) {
        this.medicoId = medicoId;
        this.nome = nome;
        this.especializacao = especializacao;
        this.CRM = CRM;
        this.valorConsulta = valorConsulta;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    // Métodos específicos do Médico
    public void atenderPaciente() {
        // Lógica para atender um paciente
    }

    public void registrarConsulta() {
        // Lógica para registrar uma consulta
    }
}
