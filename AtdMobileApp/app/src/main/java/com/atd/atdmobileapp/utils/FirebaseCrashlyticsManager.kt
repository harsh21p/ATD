package com.atd.atdmobileapp.utils

import com.google.firebase.crashlytics.FirebaseCrashlytics

object FirebaseCrashlyticsManager {
    private var firebaseCrashlytics: FirebaseCrashlytics? = null

    fun getInstance(): FirebaseCrashlytics {
        if (firebaseCrashlytics == null) {
            firebaseCrashlytics = FirebaseCrashlytics.getInstance()
        }
        return firebaseCrashlytics!!
    }
}