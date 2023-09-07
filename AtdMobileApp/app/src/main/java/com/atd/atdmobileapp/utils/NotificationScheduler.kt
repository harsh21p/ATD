package com.atd.atdmobileapp.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.atd.atdmobileapp.models.preferences.PreferencesConfiguration
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class NotificationScheduler @Inject constructor(@ApplicationContext context: Context, val sharedPrefManager: SharedPrefManager, val firestoreRepository: FirestoreRepository) {

    private val applicationContext = context
    fun scheduleNotification() {
        val alarmManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val gson = Gson()
        val data = gson.fromJson(sharedPrefManager.getUserPreferences(), PreferencesConfiguration::class.java)
        if(data!= null) {
            val endTime = data.endTime
            val calendar = Calendar.getInstance()
            val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
            val endDate = sdf.parse(endTime)
            if (endDate != null) {
                calendar.time = endDate
                val today = Calendar.getInstance()
                calendar.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH))
                val endTimeForBusiness =calendar.time
                calendar.add(Calendar.HOUR_OF_DAY, -1)
                if (shouldScheduleNotificationForEndTime(data, calendar,endTimeForBusiness)) {
                    toCheckTime(calendar.timeInMillis,"normal")
                    val pendingIntentForEndTime = createNotificationPendingIntent(1)
                    scheduleAlarm(alarmManager, calendar.timeInMillis, pendingIntentForEndTime)
                }
                if(sharedPrefManager.getLocalPlusTime() != null) {
                    val localPlusTimeInMillis = shouldScheduleNotificationForLocalPlus(data, calendar, endTimeForBusiness)
                    if (localPlusTimeInMillis != null) {
                        val localPlusTimeCalendar = Calendar.getInstance()
                        localPlusTimeCalendar.timeInMillis = localPlusTimeInMillis
                        localPlusTimeCalendar.add(Calendar.HOUR_OF_DAY, -1)
                        toCheckTime(localPlusTimeCalendar.timeInMillis, "localplus")
                        val pendingIntentForLocalPlus = createNotificationPendingIntent(2)
                        scheduleAlarm(
                            alarmManager,
                            localPlusTimeCalendar.timeInMillis,
                            pendingIntentForLocalPlus
                        )
                    }
                }
                if(sharedPrefManager.getLocalTime() != null) {
                    val localTimeInMillis = shouldScheduleNotificationForLocal(data, calendar, endTimeForBusiness)
                    if (localTimeInMillis != null) {
                        val localTimeCalendar = Calendar.getInstance()
                        localTimeCalendar.timeInMillis = localTimeInMillis
                        localTimeCalendar.add(Calendar.HOUR_OF_DAY, -1)
                        toCheckTime(localTimeCalendar.timeInMillis, "local")
                        val pendingIntentForLocal = createNotificationPendingIntent(3)
                        scheduleAlarm(
                            alarmManager,
                            localTimeCalendar.timeInMillis,
                            pendingIntentForLocal
                        )
                    }
                }
            }
        }

    }

    private fun toCheckTime(timeInMillis: Long, alarmTyp :String){
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val formattedTime = sdf.format(calendar.time)

        println(alarmTyp +" $ alarmTyp alarm schedule Time: $formattedTime")
    }

    private fun getDayOfWeekAbbreviation(dayOfWeek: Int): String {
        return when (dayOfWeek) {
            Calendar.MONDAY -> "mon"
            Calendar.TUESDAY -> "tue"
            Calendar.WEDNESDAY -> "wed"
            Calendar.THURSDAY -> "thu"
            Calendar.FRIDAY -> "fri"
            else -> ""
        }
    }

    private fun shouldScheduleNotificationForEndTime(data: PreferencesConfiguration, calendar: Calendar, endTimeForBusiness :Date): Boolean {
        val businessDays = data.businessDays
        val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val currentDateTime = Calendar.getInstance().apply { time = Date() }
        if (businessDays?.contains(getDayOfWeekAbbreviation(currentDayOfWeek)) == true && endTimeForBusiness!= null) {
            val timeDifference = endTimeForBusiness.time - currentDateTime.timeInMillis
            // Schedule the notification one hour before the end time
            val oneHourInMillis = 60 * 60 * 1000
            println( timeDifference > oneHourInMillis)
            return timeDifference > oneHourInMillis
        }

        return false
    }

    private fun shouldScheduleNotificationForLocalPlus(data: PreferencesConfiguration, calendar: Calendar,endTimeForBusiness :Date): Long? {
        val businessDays = data.businessDays
        val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val startTime = convertStringToDate(data.startTime.toString())
        val localPlusTime = convertStringToDate(sharedPrefManager.getLocalPlusTime().toString())
        return if (businessDays?.contains(getDayOfWeekAbbreviation(currentDayOfWeek)) == true &&
            localPlusTime != null &&
            localPlusTime.after(startTime) &&
            localPlusTime.before(endTimeForBusiness)
        ) {
            localPlusTime.time
        } else {
            null
        }
    }

    private fun shouldScheduleNotificationForLocal(data: PreferencesConfiguration, calendar: Calendar,endTimeForBusiness :Date): Long? {
        val businessDays = data.businessDays
        val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val startTime = convertStringToDate(data.startTime.toString())
        val localTime = convertStringToDate(sharedPrefManager.getLocalTime().toString())
        return if (businessDays?.contains(getDayOfWeekAbbreviation(currentDayOfWeek)) == true &&
            localTime != null &&
            localTime.after(startTime) &&
            localTime.before(endTimeForBusiness)
        ) {
            localTime.time
        } else {
            null
        }
    }
    private fun convertStringToDate(timeString: String): Date? {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("hh:mm a", Locale.getDefault())
        val newTime = format.parse(timeString)
        calendar.time = newTime
        val currentTime = Calendar.getInstance()
        calendar.set(currentTime.get(Calendar.YEAR), currentTime.get(Calendar.MONTH), currentTime.get(Calendar.DAY_OF_MONTH))
        return calendar.time
    }

    private fun createNotificationPendingIntent(condition :Int): PendingIntent {
        val notificationIntent = Intent(applicationContext, Notification::class.java)
        notificationIntent.putExtra("condition", condition)
        val flags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        return PendingIntent.getBroadcast(applicationContext, 0, notificationIntent, flags)
    }
    private fun scheduleAlarm(alarmManager: AlarmManager, timeInMillis: Long, pendingIntent: PendingIntent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
        } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent)
        }
    }

    private suspend fun hasRecordsInFirestore(): Boolean {
        val records = firestoreRepository.getRecordsBaseOnUserDetails(sharedPrefManager.getUserName().toString(), sharedPrefManager.getLocationNumber().toString())
        return records.isNotEmpty()
    }

    private suspend fun shouldScheduleNotification(): Boolean {
        return hasRecordsInFirestore()
    }
    suspend fun handleNotificationScheduling() {
        val shouldSchedule = shouldScheduleNotification()
        if (shouldSchedule) {
            scheduleNotification()
        }
    }

}