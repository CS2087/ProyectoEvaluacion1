package com.example.cs_evaluacion01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Clientes_act extends AppCompatActivity {
    //declaro las variables que me traigo por id ej (Spinner id= spClientes)
    private Spinner spinnerCli; //
    private EditText tvProd;    //Ingrese Producto
    private TextView tvSaldo;   //

    private static String[][] clientes = {{"Mario", "500000"}, {"Constanza", "320000"}, {"Fernanda", "120000"}};
    private static String[][] productos = {{"Horno", "45000"}, {"Espejo", "100000"}, {"Sillas", "80000"}};
    //users[0][1]
    @Override
    protected void onCreate(Bundle savedInstanceState) {     super.onCreate(savedInstanceState);    setContentView(R.layout.activity_clientes_act);

        tvProd = (EditText) findViewById(R.id.tvProd);
        tvSaldo = (TextView)findViewById(R.id.tvSaldo);
        spinnerCli = (Spinner)findViewById(R.id.spClientes);
        //Declaro el diccionario de clientes con mi objeto lsClientes
        String [] lsClientes = {"MARIO", "CONSTANZA", "FERNANDA"}; //Objeto adapterCli
        ArrayAdapter<String> adapterCli = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lsClientes);
        spinnerCli.setAdapter(adapterCli);
    }

    public void calcularValor(View v)
    {
        //declara las variables y el tipo
        String producto_string = tvProd.getText().toString();
        String seleccion = spinnerCli.getSelectedItem().toString();
        boolean isCorrect=false;
        int total = 0;

        for (String[] producto: productos){
            if (producto_string.equalsIgnoreCase(producto[0])){
                isCorrect = true;

                for (String[] cliente : clientes){
                    if (seleccion.equalsIgnoreCase(cliente[0])){
                        total = Integer.parseInt(cliente[1]) - Integer.parseInt(producto[1]);
                        tvSaldo.setText("Saldo: " + total + "");
                    }
                }
            }
        }

        if (!isCorrect){
            Toast.makeText(this, "Producto no encontrado", Toast.LENGTH_SHORT).show();
        }




    }


}