package com.example.cs_evaluacion01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Commentary_act extends AppCompatActivity {

    //declaro la variable que me traigo el progress bar
    private ProgressBar progresoBarra;
    private int progreso; // Aquí incrementar el progreso

    private Spinner spin; // Muestra la lista de productos
    private RatingBar ratingBar; // Evaluación de estrellas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentary_act);

        //Aquí llamo al id deñ progreso de la barra
        progresoBarra = (ProgressBar)findViewById(R.id.pbar);


        ratingBar = (RatingBar)findViewById(R.id.rbar);
        ratingBar.setIsIndicator(true);

        spin = (Spinner)findViewById(R.id.spinner);
        //declaro diccionario de datos para crear lista desplegable a spin
        String [] prs = {"MICROONDAS","TELEVISOR", "REFRIGERADOR", "HORNO", "LAVADORA"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,prs);
        spin.setAdapter(adapter);
    }


    public void Calificar(View v)
    {
        // clase que manejamos a nivel servicio
        Timer t= new Timer(); //esto es un temporizador

        //creo la tarea.
        TimerTask tt= new TimerTask() { //declaro el hilo //Timer Task: te implementa el metodo
            @Override  //implementa un
            public void run() {
                progreso++; //incrementa el valor del progresso.
                progresoBarra.setProgress(progreso); //dentro de la tarea relleno el progress bar
            }
        };

        long period = 100;
        long delay = 0;
        t.schedule(tt, delay, period);
        //Fin de barra

        //declara las opciones y variables a evaluar con estrellas
        int IniMicro=3;
        int IniTele=5;
        int IniRefri=3;
        int IniHorno=2;
        int IniLava=3;


        //sentencia de selección con condicion if
        if (spin.getSelectedItem().toString().equals("MICROONDAS"))
        {
            ratingBar.setRating(IniMicro);
        }

        else if (spin.getSelectedItem().toString().equals("TELEVISOR"))
        {
            ratingBar.setRating(IniTele);
        }

        else if (spin.getSelectedItem().toString().equals("REFRIGERADOR"))
        {
            ratingBar.setRating(IniRefri);
        }
        else if (spin.getSelectedItem().toString().equals("HORNO"))
        {
            ratingBar.setRating(IniHorno);
        }

        else if (spin.getSelectedItem().toString().equals("LAVADORA"))
        {
            ratingBar.setRating(IniLava);
        }

    }


}