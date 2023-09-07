package com.atd.atdmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.PreferencesFragment
import com.atd.atdmobileapp.utils.FirestoreRepository
import com.atd.atdmobileapp.utils.NotificationScheduler
import com.atd.atdmobileapp.utils.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var notificationScheduler: NotificationScheduler
    @Inject
    lateinit var sharedPrefManager: SharedPrefManager
    @Inject
    lateinit var firestoreRepository: FirestoreRepository
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        notificationScheduler = NotificationScheduler(this, sharedPrefManager,firestoreRepository )
        handleNotificationScheduling()

        mainViewModel.preferenceChanged.observe(this) { preferenceChanged ->
            if (preferenceChanged) {
                handleNotificationScheduling()
                mainViewModel.resetPreferenceChangedFlag()
            }
        }

    }

     private fun handleNotificationScheduling() {
        if (sharedPrefManager.getUserName() != null) {
            lifecycleScope.launch {
                notificationScheduler.handleNotificationScheduling()
            }
        }
    }

}