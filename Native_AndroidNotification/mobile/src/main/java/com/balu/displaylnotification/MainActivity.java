package com.balu.displaylnotification;

import android.app.Activity;
import android.app.Notification;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText editText;
    Button actionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        actionButton = (Button) findViewById(R.id.actionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transmitNotification(editText.getText().toString());
            }
        });
    }
    public void sendNotification(View view) {
        String toSend = editText.getText().toString();
        if(toSend.isEmpty())
            toSend = "You sent an empty notification";
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Balu'sNotification")
                .setContentText(toSend)
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }
    public void transmitNotification(String toSend) {
        if(toSend.isEmpty())
            toSend = "You sent an empty notification";
        System.out.println("$$$$$ getApplication() : "+getApplication());
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Balu'sNotification")
                .setContentText(toSend)
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }
}
