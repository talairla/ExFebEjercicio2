package com.example.teo.exfebejercicio2;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /*Valor total del ejercicio 20pt*/
    /*1- Cada vez que se pulse el botón Rellenar GridLayout con id btnRellenar, el grid layout glNumeros
      se debe rellenar con 16 números al azar entre 1 al 5 (5pt) dispuestos en 4 filas y 4 columnas de igual
      ancho y alto a ser posible. (5pt). Total (10puntos)
      2- Al pulsar cada uno de los números, que pueden ser textViews, botones o lo que queráis,
        se debe poner la letra del texto del elemento pulsado en negrita (5pt) y lanzar un  toast con el Texto "Has pulsado el número N", donde N será el número del 1 al 5 contenido por la casilla. (5pt). Total (10pt)
     */
    GridLayout glNumeros;
    Button btnRellenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glNumeros = (GridLayout) findViewById(R.id.glNumeros);
        btnRellenar = (Button) findViewById(R.id.btnRellenar);
        btnRellenar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnRellenar){
            for(int i = 0; i<16;i++){
                int num = (int) (Math.random()*4+1);
                Button b = new Button(this);
                b.setLayoutParams(new ViewGroup.LayoutParams(
                                            ViewGroup.LayoutParams.WRAP_CONTENT,
                                            ViewGroup.LayoutParams.WRAP_CONTENT));
                b.setText(""+num);
                b.setId(View.generateViewId());
                b.setOnClickListener(this);
                b.setTypeface(null,Typeface.NORMAL);
                glNumeros.addView(b,i);
            }
        }else{
            Button pulsado = (Button) view;
            Toast.makeText(this, "Has pulsado "+pulsado.getText(), Toast.LENGTH_SHORT).show();
            pulsado.setTypeface(null, Typeface.BOLD);
        }


    }
}
