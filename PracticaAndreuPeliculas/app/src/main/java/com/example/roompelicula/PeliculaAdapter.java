package com.example.roompelicula;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roompelicula.R;
import com.example.roompelicula.model.Pelicula;

import java.util.ArrayList;

/*public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;
    //private View tv_titol;
    private View tv_puntuacio;

    public PeliculaAdapter(Context context, int layoutResourceId, ArrayList<Pelicula> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_text = row.findViewById(R.id.text);
        String titol = data.get(position).getTitol() + " " + data.get(position).getDescripcio();
        tv_text.setText(titol);

        return row;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        tv_titol = row.findViewById(R.id.tv_titol);
        String titol = data.get(position).getTitol();
        tv_titol.setText(titol);
        tv_puntuacio = row.findViewById(R.id.tv_puntuacio);
        int puntuacio = data.get(position).getPuntuacio();
        tv_puntuacio.setText(String.valueOf(puntuacio));
        String titolPeli = data.get(position).getTitol();
        tv_titol.setText(titolPeli);
        int puntuation = data.get(position).getPuntuacio();
        if (puntuacio <= 1)
        {
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.colorRedCorp));
        }else if (puntuation > 1 && puntuation <= 3)
        {
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }else
        {
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.colorGreenCorp));
        }        return row;
    }
}*/
public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;
    TextView tv_titol, tv_puntuacio;
    public PeliculaAdapter(Context context, int layoutResourceId, ArrayList<Pelicula> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        tv_titol = row.findViewById(R.id.tv_titol);
        String titol = data.get(position).getTitol();
        tv_titol.setText(titol);
        tv_puntuacio = row.findViewById(R.id.tv_puntuacio);
        int puntuacio = data.get(position).getPuntuacio();
        tv_puntuacio.setText(String.valueOf(puntuacio));
        String titolPeli = data.get(position).getTitol();
        tv_titol.setText(titolPeli);
        int puntuation = data.get(position).getPuntuacio();
        /*if (puntuation <= 1)
        {
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.colorRedCorp));
        }else if (puntuation > 1 && puntuation <= 3)
        {
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }else
        {
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.colorGreenCorp));
        }*/        return row;
    }
}
