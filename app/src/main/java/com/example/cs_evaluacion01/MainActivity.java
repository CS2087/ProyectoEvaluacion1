package com.example.cs_evaluacion01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNom =(EditText)findViewById(R.id.etNom);
        editTextPass=(EditText)findViewById(R.id.etPass);
    }

    public void Menu (View v)
    {
        if (Validar())
        {
            Toast.makeText(this, "Ingreso de datos, Correctos!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, Menu_act.class);
            startActivity(i); //aqui paso el objeto el i para iniciar la  actividad
        }
    }

    public boolean Validar()
    {
        boolean regresa=true;

        String et1= editTextNom.getText().toString();
        String et2= editTextPass.getText().toString();

        if (et1.isEmpty())
        {
            editTextNom.setError("El campo Nombre está vacío");
            regresa=false;
        }
        if (et2.isEmpty())
        {
            editTextPass.setError("El campo Password está vacío");
            regresa=false;
        }


        else if ((et1.equalsIgnoreCase("android")) && (et2.equals("123")))
        {
            Toast.makeText(this, "User Correcto", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"usuario invalido", Toast.LENGTH_SHORT).show();
            regresa = false;
        }
        return regresa;
    }

}