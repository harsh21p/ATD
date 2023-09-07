package com.atd.atdmobileapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ#\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "usersCollection", "Lcom/google/firebase/firestore/CollectionReference;", "createCart", "", "cart", "Lcom/atd/atdmobileapp/models/Cart;", "(Lcom/atd/atdmobileapp/models/Cart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecord", "", "documentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecords", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecordsBaseOnUserDetails", "username", "locationNumber", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCart", "currentQuantity", "", "(Lcom/atd/atdmobileapp/models/Cart;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCartQuantity", "app_debug"})
@javax.inject.Singleton
public final class FirestoreRepository {
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    private final com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager = null;
    private final com.google.firebase.firestore.CollectionReference usersCollection = null;
    
    @javax.inject.Inject
    public FirestoreRepository(@org.jetbrains.annotations.NotNull
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createCart(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Cart cart, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object updateCart(com.atd.atdmobileapp.models.Cart cart, java.lang.Integer currentQuantity, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateCartQuantity(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Cart cart, @org.jetbrains.annotations.Nullable
    java.lang.Integer currentQuantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecordsBaseOnUserDetails(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.atd.atdmobileapp.models.Cart>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRecords(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.atd.atdmobileapp.models.Cart>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteRecord(@org.jetbrains.annotations.NotNull
    java.lang.String documentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}