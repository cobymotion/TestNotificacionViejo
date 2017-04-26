package com.example.luiscobian.testnotificacionviejo;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button boton = (Button) findViewById(R.id.boton1);
        boton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {




               NotificationCompat.Builder constructorNotificacion = new
                        NotificationCompat.Builder (MainActivity.this)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setLargeIcon((((BitmapDrawable)getResources()
                                .getDrawable(R.drawable.admin)).getBitmap()))
                        .setContentTitle("Mensaje de Alerta")
                        .setContentText("Ejemplo de notificación.")
                        .setContentInfo("4")
                        .setTicker("Alerta!");
                //Se establece el icono para la vista ampliada por medio de un objeto Bitmap
                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                constructorNotificacion.setLargeIcon(bm);
                //se crea un intent para una Activity
                Intent nuevoIntent = new Intent(MainActivity.this, MainActivity.class);
                TaskStackBuilder pilaArtificial = TaskStackBuilder.create(MainActivity.this);
                //Se agrega la activity a la pila artificial para el intent
                pilaArtificial.addParentStack(MainActivity.class);
                //se agrega el Intent que inicia la Activity y la coloca en el la parte superior de la pila
                pilaArtificial.addNextIntent(nuevoIntent);
                //Se crea el PendingIntent que lanzara la activity desde la notificacion
                PendingIntent nuevoPendingIntent = pilaArtificial
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                constructorNotificacion.setContentIntent(nuevoPendingIntent);
                NotificationManager mNotificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                //se establece que se cancele automáticamente la notificación cuando el usuario hace "click" sobre ella.
                constructorNotificacion.setAutoCancel(true);
                mNotificationManager.notify(2, constructorNotificacion.build());
            }
        });
    }


}
