package com.example.roompelicula.database;

//import android.arch.persistence.room.Database;
//import android.arch.persistence.room.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roompelicula.model.Pelicula;

@Database(entities = {Pelicula.class}, version = 1)
public abstract class PeliculaDatabase extends RoomDatabase {
    public abstract PeliculaDao getPeliculaDao();
}
