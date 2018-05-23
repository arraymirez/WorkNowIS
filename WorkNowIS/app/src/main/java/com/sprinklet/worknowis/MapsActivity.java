package com.sprinklet.worknowis;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.sprinklet.classes.MySQLConnection;
import com.sprinklet.worknowis.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sprinklet.worknowis.R;

import static android.widget.Toast.*;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener,OnMapReadyCallback {

    private GoogleMap mMap;
    Marker seleccionado;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button crearCita=(Button)findViewById(R.id.btnCita);
        crearCita.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(seleccionado!=null){

                    Intent aCita=new Intent(MapsActivity.this,CitasActivity.class);
                    aCita.putExtra("idEmpleado",seleccionado.getId());
                    startActivity(aCita);
                }
            }


        });
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);

        // Se deben generar los puntos de los empleados
        Marcadores(googleMap);

    }
 public void Marcadores(GoogleMap googleMap){
        mMap =googleMap;
        int cantidad=1;//estos deberian ser la consulta de la bd
        for (int a=0; a<cantidad;a++){
            final LatLng p=new LatLng(32.52,-116.88);//aqui deben de ir las coordenadas de la bd
            Marker punto= mMap.addMarker(new MarkerOptions().position(p).title("Nombre de empleado"));

         }
     mMap.setOnMarkerClickListener(this);
 }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.isInfoWindowShown()){
            marker.hideInfoWindow();
            seleccionado=null;
        }else {

            marker.showInfoWindow();
            seleccionado=marker;

            Log.d("Marker:",seleccionado.getId());
        }

        return true;
    }
}
