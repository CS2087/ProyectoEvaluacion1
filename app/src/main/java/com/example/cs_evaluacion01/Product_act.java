package com.example.cs_evaluacion01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Product_act extends AppCompatActivity {

    //declaro los objetos de mi parte logica
    private EditText etpro, etmonto;
    private CheckBox checkeDom, checkeSuc, checkeGrat;

    private TextView tvcalculo;
    // 3 columnas y 3 filas
    private static String[][] losProductos = { {"Televisor", "129000"}, {"Microondas", "50000"}, {"Lavadora", "100000"} };
    private static String[][] costoEnvio =   { {"EnvioTv", "14500"},    {"EnvioMicro", "5500"},  {"EnvioLava", "25000"} };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_act);
        //id creados desde la parte grafica conexion de objetos y componentes
        etpro = (EditText)findViewById(R.id.etpro);
        etmonto = (EditText)findViewById(R.id.etmonto);
        checkeDom = (CheckBox)findViewById(R.id.cbEdom);
        checkeSuc = (CheckBox)findViewById(R.id.cbRsuc);
        checkeGrat = (CheckBox)findViewById(R.id.cbEgrat);
        tvcalculo = (TextView)findViewById(R.id.tvTotal);    }

   public void calcularProducto(View v) { //declaro las variables y tipos de datos
        String ingresoprod_string = etpro.getText().toString();
        String monto_prod = etmonto.getText().toString();
        int valorMonto_int = Integer.parseInt(monto_prod);
//      String productoss = spinnerCli.getSelectedItem().toString();
        boolean isCorrect=false;
        int valortotal = 0;

        //Aquí Falle  //no pude lograrlo
        for (String[] losprod: losProductos){
            if (ingresoprod_string.equalsIgnoreCase(losprod[0])){
                isCorrect = true;

                for (String[] costoE : costoEnvio){
                    if ( (valorMonto_int!=0) && (checkeDom.isChecked()==true) ){
                        valortotal = Integer.parseInt(losprod[1]) + Integer.parseInt(costoE[1]) - valorMonto_int;
                        tvcalculo.setText("Calculo: " + valortotal + ".-");
                    }
                }
            }
        }

        if (!isCorrect){
            Toast.makeText(this, "Calculo sin Exito!", Toast.LENGTH_SHORT).show();
        }

    }

/* //Este metodo funciona pero es muy largo quise comprimir codigo y no pude

    //Metodo del Boton / funcion con if respaldo
    public void calcularProducto(View v) {
        String val1_String = etpro.getText().toString();
        String val2_String = etmonto.getText().toString();
        int valor2_Int = Integer.parseInt(val2_String);

        String resultado="";
        if ( (val1_String.equalsIgnoreCase("Televisor")) && (valor2_Int >=0) && (checkeDom.isChecked() ==true ))
        {
            int sumaenvio = 129000 + 14500 - valor2_Int;
            resultado =  " / " + "El Calculo es: " + sumaenvio;
        }
        else if ((val1_String.equalsIgnoreCase("Microondas")) && (valor2_Int >=0) && (checkeDom.isChecked() ==true ) )
        {
            int sumaenvio = 50000 + 5500 -valor2_Int;
            resultado =  " / " + "El Calculo es: " + sumaenvio ;
        }
        else if ((val1_String.equalsIgnoreCase("Lavadora")) && (valor2_Int >=0) && (checkeDom.isChecked() ==true ))
        {
            int sumaenvio = 50000 + 5500 -valor2_Int;
            resultado = "/" + "El Calculo es: " + sumaenvio ;
        }

        tvcalculo.setText(resultado);

    }
    */




}