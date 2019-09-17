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

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;

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
}
