package com.atd.atdmobileapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0011\u0010\u0018\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ \u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013H\u0002J\u0006\u0010#\u001a\u00020\u0019J\u0011\u0010$\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ \u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002J\'\u0010+\u001a\u0004\u0018\u00010!2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002\u00a2\u0006\u0002\u0010,J\'\u0010-\u001a\u0004\u0018\u00010!2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002\u00a2\u0006\u0002\u0010,J\u0018\u0010.\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010/\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/atd/atdmobileapp/utils/NotificationScheduler;", "", "context", "Landroid/content/Context;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "(Landroid/content/Context;Lcom/atd/atdmobileapp/utils/SharedPrefManager;Lcom/atd/atdmobileapp/utils/FirestoreRepository;)V", "applicationContext", "getFirestoreRepository", "()Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "convertStringToDate", "Ljava/util/Date;", "timeString", "", "createNotificationPendingIntent", "Landroid/app/PendingIntent;", "condition", "", "getDayOfWeekAbbreviation", "dayOfWeek", "handleNotificationScheduling", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasRecordsInFirestore", "", "scheduleAlarm", "alarmManager", "Landroid/app/AlarmManager;", "timeInMillis", "", "pendingIntent", "scheduleNotification", "shouldScheduleNotification", "shouldScheduleNotificationForEndTime", "data", "Lcom/atd/atdmobileapp/models/preferences/PreferencesConfiguration;", "calendar", "Ljava/util/Calendar;", "endTimeForBusiness", "shouldScheduleNotificationForLocal", "(Lcom/atd/atdmobileapp/models/preferences/PreferencesConfiguration;Ljava/util/Calendar;Ljava/util/Date;)Ljava/lang/Long;", "shouldScheduleNotificationForLocalPlus", "toCheckTime", "alarmTyp", "app_release"})
public final class NotificationScheduler {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository = null;
    private final android.content.Context applicationContext = null;
    
    @javax.inject.Inject
    public NotificationScheduler(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.FirestoreRepository getFirestoreRepository() {
        return null;
    }
    
    public final void scheduleNotification() {
    }
    
    private final void toCheckTime(long timeInMillis, java.lang.String alarmTyp) {
    }
    
    private final java.lang.String getDayOfWeekAbbreviation(int dayOfWeek) {
        return null;
    }
    
    private final boolean shouldScheduleNotificationForEndTime(com.atd.atdmobileapp.models.preferences.PreferencesConfiguration data, java.util.Calendar calendar, java.util.Date endTimeForBusiness) {
        return false;
    }
    
    private final java.lang.Long shouldScheduleNotificationForLocalPlus(com.atd.atdmobileapp.models.preferences.PreferencesConfiguration data, java.util.Calendar calendar, java.util.Date endTimeForBusiness) {
        return null;
    }
    
    private final java.lang.Long shouldScheduleNotificationForLocal(com.atd.atdmobileapp.models.preferences.PreferencesConfiguration data, java.util.Calendar calendar, java.util.Date endTimeForBusiness) {
        return null;
    }
    
    private final java.util.Date convertStringToDate(java.lang.String timeString) {
        return null;
    }
    
    private final android.app.PendingIntent createNotificationPendingIntent(int condition) {
        return null;
    }
    
    private final void scheduleAlarm(android.app.AlarmManager alarmManager, long timeInMillis, android.app.PendingIntent pendingIntent) {
    }
    
    private final java.lang.Object hasRecordsInFirestore(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    private final java.lang.Object shouldScheduleNotification(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object handleNotificationScheduling(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}