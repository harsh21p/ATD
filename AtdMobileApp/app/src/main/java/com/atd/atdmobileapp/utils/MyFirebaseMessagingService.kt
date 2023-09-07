package com.atd.atdmobileapp.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.atd.atdmobileapp.MainActivity
import com.atd.atdmobileapp.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId = "notification_channel"

class MyFirebaseMessagingService : FirebaseMessagingService() {


    override fun onMessageReceived(message: RemoteMessage) {
        if (message.notification != null) {
            generateNotification(message.notification!!.title!!, message.notification!!.body!!)
        }
    }

    private fun getRemoteView(title: String, message: String): RemoteViews {
        val remoteView = RemoteViews("com.atd.atdmobileapp", R.layout.notification)
        remoteView.setTextViewText(R.id.tvTitle, title)
        remoteView.setTextViewText(R.id.tvDescription, message)
        remoteView.setImageViewResource(R.id.ivAppLogo, R.drawable.icon)
        return remoteView
    }

    private fun generateNotification(title: String, message: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        var builder: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)
                .setContent(getRemoteView(title, message))

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "com.atd.atdmobileapp",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, builder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Store or send the new FCM token to your server
        println( "Refreshed token: $token")

    }

}