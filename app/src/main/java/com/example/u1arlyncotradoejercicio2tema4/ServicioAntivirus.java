package com.example.u1arlyncotradoejercicio2tema4;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.text.Html;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ServicioAntivirus extends Service {
    private static final int ID_NOTIFICACION_CREAR = 1;
    public static final String NOTIFICATION_CHANNEL_ID = "1000";
    public static final String NOTIFICATION_CHANNEL_NAME = "UNJBG";

    @Override //notificacion
    public int onStartCommand(Intent intenc, int flags, int idArranque) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        PendingIntent  inicio= PendingIntent.getActivity(this,0, i,0);

        NotificationCompat.Builder notific = new NotificationCompat.Builder(this)
                .setContentTitle("Creando Servicio de Música")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("información adicional")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        android.R.drawable.ic_media_play))
                .setWhen(System.currentTimeMillis() + 1000 * 60 * 60)//vibrar
                .setContentInfo("más info")
                .setTicker("Texto en barra de estado")
                .addAction(android.R.drawable.ic_dialog_alert, "INICIAR", inicio)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentText(Html.fromHtml("<b>Notificación</b> <u>Android<i>UPT</i></u>"))
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Nueva Conferencia Los neutrinos")
                        .setBigContentTitle("2 notificaciones UPT")
                        .setSummaryText("info@upt.pe"))
                .setNumber(2)
                .setDefaults(Notification.DEFAULT_VIBRATE);

        // Para lanzar una actividad
        /*PendingIntent intencionPendiente = PendingIntent.getActivity(
                this, 0, new Intent(this, Servicio.class), 0);
        notific.setContentIntent(intencionPendiente);*/


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
        notificationManager.notify(ID_NOTIFICACION_CREAR, notific.build());//construye la notificacion

        //   notificationManager.notify(3,notific.build());
        Toast.makeText(this, "Servicio arrancado " + idArranque,
                Toast.LENGTH_SHORT).show();
         //startForeground(101,notific.build());
        return START_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
