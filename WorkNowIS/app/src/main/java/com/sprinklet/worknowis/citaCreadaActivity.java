package com.sprinklet.worknowis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class citaCreadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita_creada);

        Button regresar=findViewById(R.id.btnAceptar);
        regresar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(citaCreadaActivity.this,MapsActivity.class);
                startActivity(m);
            }
        });
    }
}
