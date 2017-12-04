package com.example.adrianch.eva2_11_cuadros_dialogo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        contexto = getApplicationContext();
    }

    public void cuadroNormal(View v) {
        new AlertDialog.Builder(this)
                .setTitle("Titulo")
                .setMessage("Mi primer mensaje de texto")
                .setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(contexto, "Boton positivo", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(contexto, "Boton neutral", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(contexto, "Boton negativo", Toast.LENGTH_SHORT).show();
                    }
                })
                .create().show();
    }

    public void cuadroPersonalizado(View v) {
        final Dialog dialogo = new Dialog(this);
        dialogo.setContentView(R.layout.cuadro_dialogo_personalizado);
        TextView txtVw;
        final EditText edtTxt;
        Button btn;

        txtVw = (TextView) dialogo.findViewById(R.id.txtVw);
        edtTxt = (EditText) dialogo.findViewById(R.id.edtTxt);
        btn = (Button) dialogo.findViewById(R.id.btn);

        txtVw.setText("Titulo personalizado");
        btn.setText("Click personalizado");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto, edtTxt.getText().toString(), Toast.LENGTH_SHORT).show();
                dialogo.dismiss();
            }
        });
        dialogo.show();
    }
}
