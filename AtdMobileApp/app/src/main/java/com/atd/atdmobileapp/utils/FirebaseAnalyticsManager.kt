package com.atd.atdmobileapp.utils

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics

object FirebaseAnalyticsManager {
    private var firebaseAnalytics: FirebaseAnalytics? = null

    fun getInstance(context: Context): FirebaseAnalytics {
        if (firebaseAnalytics == null) {
            firebaseAnalytics = FirebaseAnalytics.getInstance(context)
        }
        return firebaseAnalytics!!
    }
}