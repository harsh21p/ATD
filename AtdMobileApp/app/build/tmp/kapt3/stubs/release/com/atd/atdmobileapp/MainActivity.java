package com.atd.atdmobileapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/atd/atdmobileapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "getFirestoreRepository", "()Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "setFirestoreRepository", "(Lcom/atd/atdmobileapp/utils/FirestoreRepository;)V", "mainViewModel", "Lcom/atd/atdmobileapp/MainViewModel;", "notificationScheduler", "Lcom/atd/atdmobileapp/utils/NotificationScheduler;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "handleNotificationScheduling", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.atd.atdmobileapp.utils.NotificationScheduler notificationScheduler;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository;
    private com.atd.atdmobileapp.MainViewModel mainViewModel;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.FirestoreRepository getFirestoreRepository() {
        return null;
    }
    
    public final void setFirestoreRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void handleNotificationScheduling() {
    }
}