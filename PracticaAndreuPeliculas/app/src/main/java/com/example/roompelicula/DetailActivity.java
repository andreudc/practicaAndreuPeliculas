package com.example.roompelicula;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roompelicula.controller.PeliculaController;
import com.example.roompelicula.R;
import com.example.roompelicula.model.Pelicula;

public class DetailActivity extends AppCompatActivity {

    PeliculaController controller;
    Pelicula pelicula;

    TextView tv_id, tv_titol, tv_descripcio, tv_any, tv_puntuacio, tv_imatge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        /*Recollir l'id de la pelicula seleccionada a la llista*/
        String id = getIntent().getStringExtra("idPelicula");

        /*Agafem la persona de la base de dades SQLite per ID*/
        controller = PeliculaController.get(this);
        pelicula = controller.getPelicula(id);

        /*Inicialitzar els TextView*/
        tv_id = findViewById(R.id.tv_id);
        tv_titol = findViewById(R.id.tv_titol);
        //tv_titol = findViewById(R.id.tv_titol);
        tv_descripcio = findViewById(R.id.tv_descripcio);
        tv_any = findViewById(R.id.tv_any);
        //tv_age = findViewById(R.id.tv_age);
        tv_puntuacio = findViewById(R.id.tv_puntuacio);
        tv_imatge = findViewById(R.id.tv_imatge);
        //tv_mail = findViewById(R.id.tv_mail);

        showPelicula();
    }

    /*Mostrar les dades de persona als TextView*/
    private void showPelicula()
    {
        tv_id.setText(pelicula.getId());
        tv_titol.setText(pelicula.getTitol());
        tv_descripcio.setText(pelicula.getDescripcio());
        tv_imatge.setText(pelicula.getImatge());
        tv_any.setText(String.valueOf(pelicula.getAny()));
        tv_puntuacio.setText(String.valueOf(pelicula.getPuntuacio()));
    }

    public void deletePressed(View view) {
        controller.deletePelicula(pelicula);
        finish();
    }

    public void editPressed(View view) {
        Intent intent = new Intent(DetailActivity.this, CreatePeliculaActivity.class);
        intent.putExtra("idPelicula",pelicula.getId());
        startActivity(intent);
        finish();
    }
}
