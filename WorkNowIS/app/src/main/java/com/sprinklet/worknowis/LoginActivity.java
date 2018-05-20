package com.sprinklet.worknowis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sprinklet.classes.MySQLConnection;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;

/**
 * A login screen that offers login via user/password.
 */
public class LoginActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);
         //*Asignacion de botones, a los botones :v*//
         Button LogIn= (Button)findViewById(R.id.btnLogIn);
         Button NewUser= (Button)findViewById(R.id.btnCrearUsuario);
         //boton para iniciar sesion, con credenciales definidas
         LogIn.setOnClickListener(new View.OnClickListener()
         {
            @Override
            public void onClick(View view)
            {
/*
 System.out.println("Nombre: " + m.registro.getString(1) + "\nApellido: " + m.registro.getString(2) +"\nEmail: " + m.registro.getString(3));
String user = ((EditText)findViewById(R.id.txtUsuario)).getText().toString();
                 String pass = ((EditText)findViewById(R.id.txtContraseña)).getText().toString();
                 if (user.equals("admin") & pass.equals("password"))
                 {
                     Intent In = new Intent(LoginActivity.this, MapsActivity.class);
                     startActivity(In);
                 }
                 else
                 {
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_SHORT);
                 }*/
             }

         });
    }
}

