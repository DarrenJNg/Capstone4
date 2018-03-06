package com.example.pineapple.practiceui;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 062020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(PracticeUI.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Text "+message);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        Log.i("THe Log", "the");
    }
    public void NotificationBClicked(View view){
        //build the notification

        Log.i("Log", "Loggy");

        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("This is the Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title");
        notification.setContentText("I am the body of the notification");

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());

        Log.i("Log","Complete");
    }

}
