package com.example.cs_evaluacion01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        getSupportActionBar().hide();
    }

    public void Productos (View v)
    {
        Intent i = new Intent(this, Product_act.class);
        startActivity(i);
    }

    public void Comentarios (View v)
    {
        Intent i = new Intent(this, Commentary_act.class);
        startActivity(i);
    }

    public void Clientes (View v)
    {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }

    public void Info (View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

}