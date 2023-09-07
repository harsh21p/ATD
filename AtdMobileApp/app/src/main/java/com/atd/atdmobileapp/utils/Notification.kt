package com.atd.atdmobileapp.utils

import android.Manifest
import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.atd.atdmobileapp.MainActivity
import com.atd.atdmobileapp.R


class Notification : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val channelId = "channel_id"
        val channelName = "Channel Name"
        val notificationId = 123
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT).apply {
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
            }

            val notificationManager = context?.getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
        var notificationTitle: String =""
        var notificationContent: String =""

        val condition = intent?.getIntExtra("condition", -1) ?: -1
        when (condition) {
            1 -> {
                notificationTitle = "Order Now!"
                notificationContent = "End of business day approaching"
            }
            2 -> {
                notificationTitle = "Order Now!"
                notificationContent = "Local+ cut-off time within an hour"
            }
            // Add more cases as needed
            3 -> {
                notificationTitle = "Order Now!"
                notificationContent = "Local cut-off time within an hour"
            }
        }
        val launchIntent = context?.packageManager?.getLaunchIntentForPackage(context.packageName)
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            launchIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // Create the notification
        val notificationBuilder = NotificationCompat.Builder(context!!, channelId)
            .setSmallIcon(R.drawable.atdheader)
            .setContentTitle(notificationTitle)
            .setContentText(notificationContent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        // Display the notification
        val notificationManager = NotificationManagerCompat.from(context)
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        notificationManager.notify(notificationId, notificationBuilder.build())
    }

}