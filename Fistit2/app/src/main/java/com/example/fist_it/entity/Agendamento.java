package com.example.fist_it.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Agendamento")
public class Agendamento {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "data")
    private String data;

    @ColumnInfo(name = "hora")
    private String hora;

    @ColumnInfo(name = "status")
    private String status;

    public Agendamento(String data, String hora, String status) {
        this.data = data;
        this.hora = hora;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
