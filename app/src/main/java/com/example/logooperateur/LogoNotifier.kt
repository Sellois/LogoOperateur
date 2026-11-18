package com.example.logooperateur

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.widget.RemoteViews

object LogoNotifier {
    fun show(ctx: Context) {
        val nm = ctx.getSystemService(NotificationManager::class.java)
        // IMPORTANCE_LOW : silencieuse, mais l'icône reste visible dans la barre de statut
        nm.createNotificationChannel(
            NotificationChannel("logo", "Logo opérateur", NotificationManager.IMPORTANCE_LOW)
        )
        val views = RemoteViews(ctx.packageName, R.layout.notif_logo)
        val n = Notification.Builder(ctx, "logo")
            .setSmallIcon(R.drawable.ic_logo_status)   // barre de statut (monochrome)
            .setStyle(Notification.DecoratedCustomViewStyle())
            .setCustomContentView(views)               // logo complet en couleur dans le volet
            .setOngoing(true)
            .setShowWhen(false)
            .build()
        nm.notify(1, n)
    }
}
