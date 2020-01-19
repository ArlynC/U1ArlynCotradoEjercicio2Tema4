package com.example.u1arlyncotradoejercicio2tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Musica extends AppCompatActivity {

    MediaPlayer reproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        reproductor = MediaPlayer.create(this, R.raw.hozier_work);
        reproductor.start();
    }

    public void desinfectar(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.avast.android.mobilesecurity")));
    }
}
