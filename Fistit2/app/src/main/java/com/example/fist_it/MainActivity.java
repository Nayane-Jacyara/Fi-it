package com.example.fist_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.example.fist_it.BancoDeDados.Database;

public class MainActivity extends AppCompatActivity {

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= Room.databaseBuilder(getApplicationContext(), Database.class,"Fit-it").build();
    }
}