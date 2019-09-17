package com.example.roompelicula;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roompelicula.controller.PeliculaController;
import com.example.roompelicula.R;
import com.example.roompelicula.model.Pelicula;

public class CreatePeliculaActivity extends AppCompatActivity {

    EditText et_titol, et_descripcio, et_any, et_puntuacio , et_imatge;
    PeliculaController controller;
    Pelicula pelicula;
    String id;
    Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pelicula);

        et_titol = findViewById(R.id.et_titol);
        et_descripcio = findViewById(R.id.et_descripcio);
        et_any = findViewById(R.id.et_any);
        et_puntuacio = findViewById(R.id.et_puntuacio);
        et_imatge = findViewById(R.id.et_imatge);
        btn_create = findViewById(R.id.btn_create);

        controller = PeliculaController.get(this);

        /*Recollim l'extra ID per veure si estem editant*/
        id = getIntent().getStringExtra("idPelicula");
        if (id != null) //si no es null, recollir dades de la persona
        {
            pelicula = controller.getPelicula(id);
            //Mostrar les dades per pantalla
            showPelicula();
        }
    }

    private void showPelicula() {
        et_titol.setText(pelicula.getTitol());
        et_descripcio.setText(pelicula.getDescripcio());
        et_imatge.setText(pelicula.getImatge());
        et_any.setText(String.valueOf(pelicula.getAny()));
        et_puntuacio.setText(String.valueOf(pelicula.getPuntuacio()));

        btn_create.setText("Modificar"); //Modificar el text del botó
    }

    public void createPressed(View view) {
        String titol = et_titol.getText().toString();
        String descripcio = et_descripcio.getText().toString();
        String imatge = et_imatge.getText().toString();
        String any = et_any.getText().toString();
        String puntuacio = et_puntuacio.getText().toString();

        //comprovar buits
        if (checkFields(titol, descripcio, any, puntuacio, imatge)) {
            if (id != null) {
                //Si tenim ID, estem editant, fem SETS
                pelicula.setTitol(titol);
                pelicula.setDescripcio(descripcio);
                pelicula.setAny(Integer.parseInt(any));
                pelicula.setPuntuacio(Integer.parseInt(puntuacio));
                pelicula.setImatge(imatge);
                //Cridem al update a la bbdd:
                controller.updatePelicula(pelicula);

            } else {
                Pelicula p = new Pelicula(titol, descripcio, Integer.parseInt(any), Integer.parseInt(puntuacio), imatge);
                controller.createPelicula(p); //crear pelicula al sqlite

            }
            finish(); //Tancar pantalla
        }
    }

    private boolean checkFields(String titol, String descripcio, String any, String puntuacio, String imatge) {
        boolean valid = true;
        if ("".equals(titol)) {
            et_titol.setError("Título no puede ser vacío");
            valid = false;
        }
        if ("".equals(descripcio)) {
            et_descripcio.setError("Descripción no puede ser vacío");
            valid = false;
        }
        if ("".equals(any)) {
            et_any.setError("Año no puede ser vacío");
            valid = false;
        }
        if ("".equals(puntuacio)) {
            et_puntuacio.setError("Puntuación no puede ser vacío");
            valid = false;
        }
        if ("".equals(imatge)) {
            et_imatge.setError("Imagen no puede ser vacío");
            valid = false;
        }
        return valid;
    }
}
