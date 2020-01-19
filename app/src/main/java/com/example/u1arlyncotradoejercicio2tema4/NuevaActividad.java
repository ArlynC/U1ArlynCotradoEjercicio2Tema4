package com.example.u1arlyncotradoejercicio2tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class NuevaActividad extends Activity {

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        setContentView(R.layout.activity_nueva_actividad);
        startService(new Intent(NuevaActividad.this,
                ServicioAntivirus.class));
        finish();

        Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    public void run() {
                        startActivity(new Intent(NuevaActividad.this, Musica.class));
                    }
                }, 5000L);
    }
}
