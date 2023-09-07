package com.atd.atdmobileapp

import android.app.Application
import com.atd.atdmobileapp.utils.FirebaseAnalyticsManager
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AtdMobileApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseAnalyticsManager.getInstance(this)
        FirebaseAuth.getInstance()
        AndroidThreeTen.init(this)
    }
}