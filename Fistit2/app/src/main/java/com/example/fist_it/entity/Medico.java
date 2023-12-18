package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity(foreignKeys = @ForeignKey(entity = Clinica.class,
        parentColumns = "clinica_id",
        childColumns = "clinica_id",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index("clinica_id")})
public class Medico {
    @PrimaryKey
    @ColumnInfo(name = "medico_id")
    private int medicoId;
    @ColumnInfo(name = "clinica_id")
    private int clinicaId; // Chave estrangeira
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "especializacao")
    private String especializacao;
    @ColumnInfo(name = "CRM")
    private int CRM;
    @ColumnInfo(name = "valorConsulta")
    private double valorConsulta;
    @TypeConverters({Converters.class})
    @ColumnInfo(name = "datas_e_horarios_disponiveis")
    private Map<Date, List<String>> datasEHorariosDisponiveis; // Mapeamento de datas para horários disponíveis

    public Medico(int medicoId, int clinicaId, String nome, String especializacao, int CRM, double valorConsulta, Map<Date, List<String>> datasEHorariosDisponiveis) {
        this.medicoId = medicoId;
        this.clinicaId = clinicaId;
        this.nome = nome;
        this.especializacao = especializacao;
        this.CRM = CRM;
        this.valorConsulta = valorConsulta;
        this.datasEHorariosDisponiveis = datasEHorariosDisponiveis;
    }
    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
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

    public Map<Date, List<String>> getDatasEHorariosDisponiveis() {
        return datasEHorariosDisponiveis;
    }

    public void setDatasEHorariosDisponiveis(Map<Date, List<String>> datasEHorariosDisponiveis) {
        this.datasEHorariosDisponiveis = datasEHorariosDisponiveis;
    }
}