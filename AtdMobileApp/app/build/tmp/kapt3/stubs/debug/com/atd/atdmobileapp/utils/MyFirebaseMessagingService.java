package com.atd.atdmobileapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/atd/atdmobileapp/utils/MyFirebaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "generateNotification", "", "title", "", "message", "getRemoteView", "Landroid/widget/RemoteViews;", "onMessageReceived", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "app_debug"})
public final class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    
    public MyFirebaseMessagingService() {
        super();
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.RemoteMessage message) {
    }
    
    private final android.widget.RemoteViews getRemoteView(java.lang.String title, java.lang.String message) {
        return null;
    }
    
    private final void generateNotification(java.lang.String title, java.lang.String message) {
    }
    
    @java.lang.Override
    public void onNewToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
}