package com.example.u1arlyncotradoejercicio2tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

public class NuevaActividad extends Activity {

    private static final int ID_NOTIFICACION_CREAR = 1;


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nueva_actividad);
        finish();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(new Intent(NuevaActividad.this, ServicioAntivirus.class));
        } else {
            startService(new Intent(NuevaActividad.this,
                    ServicioAntivirus.class));
        }


        Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    public void run() {
                            startActivity(new Intent(NuevaActividad.this, Musica.class));

                    }
                }, 5000L);


    }
    @Override public void onDestroy() {
        super.onDestroy();
        //Eliminando la notificacion
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(ID_NOTIFICACION_CREAR);
    }
}
