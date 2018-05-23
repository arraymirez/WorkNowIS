package com.sprinklet.worknowis;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.sprinklet.worknowis.R;

public class CitasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        ObtenerInfo();
    }


    public void ObtenerInfo(){
        String id=getIntent().getStringExtra("idEmpleado");
        EditText inputTitulo= findViewById(R.id.txtServicio);
        EditText inputCosto= findViewById(R.id.txtCosto);
        inputTitulo.setText("Plomeeria", TextView.BufferType.NORMAL);
        inputCosto.setText("$350", TextView.BufferType.NORMAL);
        /*Aqui deberia poner el metodo o la busqueda de info del empleddo*/
    }

}
