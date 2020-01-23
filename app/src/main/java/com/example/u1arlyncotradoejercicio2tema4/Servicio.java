package com.example.u1arlyncotradoejercicio2tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.WindowManager;

public class Servicio extends Activity {

    private static final int ID_NOTIFICACION_CREAR = 1;
    public static final String NOTIFICATION_CHANNEL_ID = "1000";
    public static final String NOTIFICATION_CHANNEL_NAME = "Antivirus";
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        setContentView(R.layout.activity_servicio);

        Intent resultIntent = new Intent(this, NuevaActividad.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notific = new NotificationCompat.Builder(this)
                .setContentTitle(Html.fromHtml("<b>Antivirus</b>"))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Presione INICIAR para realizar búsqueda de virus.")
                /* .setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_media_play))
               / .setWhen(System.currentTimeMillis() + 1000 * 60 * 60)//vibrar
                 .setContentInfo("más info")
                 .setTicker("Texto en barra de estado")*/

                .addAction(android.R.drawable.ic_dialog_alert, "INICIAR", resultPendingIntent);

        // Para lanzar una actividad
        PendingIntent intencionPendiente = PendingIntent.getActivity(
                this, 0, new Intent(this, Servicio.class), 0);
        notific.setContentIntent(intencionPendiente);


        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { //si es mayor a android oreo=8
            NotificationChannel notificationChannel =
                    new NotificationChannel(
                            NOTIFICATION_CHANNEL_ID,
                            NOTIFICATION_CHANNEL_NAME,
                            NotificationManager.IMPORTANCE_LOW);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(R.color.colorAccent);
            notificationManager.createNotificationChannel(notificationChannel);
            notific.setChannelId(NOTIFICATION_CHANNEL_ID);

        }
        notificationManager.notify(ID_NOTIFICACION_CREAR, notific.build());
        finish();


    }/*
    @Override public void onDestroy() {
        //Eliminando la notificacion
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(ID_NOTIFICACION_CREAR);
    }*/
}
