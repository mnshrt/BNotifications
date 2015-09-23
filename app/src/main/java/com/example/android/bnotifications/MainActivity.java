package com.example.android.bnotifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueId=45612;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);


    }

        public void clicked(View view){
//build the notifiacation

        notification.setSmallIcon(R.mipmap.ic_launcher);
            notification.setTicker("this is the ticker");
            notification.setWhen(System.currentTimeMillis());
            notification.setContentTitle("here is the title");
            notification.setContentText("i m the body text of ur notificqation");
            Intent intent = new Intent(this,MainActivity.class);
            PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);


            //builds the notification and issues it
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(uniqueId,notification.build());
        }

}
