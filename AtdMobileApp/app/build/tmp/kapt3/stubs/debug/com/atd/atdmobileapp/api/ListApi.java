package com.atd.atdmobileapp.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J5\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/atd/atdmobileapp/api/ListApi;", "", "DeleteItemFromList", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/mylist/DeleteItemResp;", "locationNumber", "", "listname", "productnumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteList", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getList", "Lcom/atd/atdmobileapp/models/mylist/MyListResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveList", "request", "Lcom/atd/atdmobileapp/models/mylist/CreateListRequest;", "(Ljava/lang/String;Lcom/atd/atdmobileapp/models/mylist/CreateListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateList", "(Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/mylist/MyListResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ListApi {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "/rs/3_6/list/{locationNumber}")
    public abstract java.lang.Object getList(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.mylist.MyListResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "/rs/3_6/list/{locationNumber}")
    public abstract java.lang.Object saveList(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.mylist.CreateListRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.mylist.MyListResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.PUT(value = "/rs/3_6/list/{locationNumber}/{listname}")
    public abstract java.lang.Object updateList(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "listname")
    java.lang.String listname, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Body
    com.atd.atdmobileapp.models.mylist.MyListResponse request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.mylist.MyListResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.DELETE(value = "/rs/3_6/list/{locationNumber}/{listname}/{productnumber_to_delete}")
    public abstract java.lang.Object DeleteItemFromList(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "listname")
    java.lang.String listname, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "productnumber_to_delete")
    java.lang.String productnumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.DELETE(value = "/rs/3_6/list/{locationNumber}/{listname}")
    public abstract java.lang.Object deleteList(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "locationNumber")
    java.lang.String locationNumber, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Path(value = "listname")
    java.lang.String listname, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> continuation);
}