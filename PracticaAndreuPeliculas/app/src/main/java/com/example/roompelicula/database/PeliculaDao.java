package com.example.roompelicula.database;

//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;
//import android.arch.persistence.room.Update;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roompelicula.model.Pelicula;

import java.util.List;

@Dao
public interface PeliculaDao {
    @Query("SELECT * From pelicula")
    List<Pelicula> getPeliculas();

    @Query("SELECT * FROM pelicula where id like :uuid")
    Pelicula getPelicula(String uuid);

    @Insert
    void addPelicula(Pelicula n);

    @Delete
    void deletePelicula(Pelicula n);

    @Update
    void updatePelicula(Pelicula n);
}
