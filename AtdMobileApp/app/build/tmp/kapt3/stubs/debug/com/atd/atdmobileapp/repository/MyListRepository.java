package com.atd.atdmobileapp.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0!H\u0002J\u0016\u0010\"\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!H\u0002J\u0016\u0010#\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!H\u0002J\u0016\u0010$\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0!H\u0002J!\u0010%\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J)\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/atd/atdmobileapp/repository/MyListRepository;", "", "listApi", "Lcom/atd/atdmobileapp/api/ListApi;", "(Lcom/atd/atdmobileapp/api/ListApi;)V", "_deleteResponseLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/mylist/DeleteItemResp;", "get_deleteResponseLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_myListResponseLiveData", "Lcom/atd/atdmobileapp/models/mylist/MyListResponse;", "get_myListResponseLiveData", "deleteResponseLiveData", "Landroidx/lifecycle/LiveData;", "getDeleteResponseLiveData", "()Landroidx/lifecycle/LiveData;", "myListResponseLiveData", "getMyListResponseLiveData", "DeleteItemFromList", "", "location", "", "listName", "productNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteList", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyList", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDeleteResponse", "response", "Lretrofit2/Response;", "handleResponse", "handleSavedResponse", "handleUpdateResponse", "saveMyList", "request", "Lcom/atd/atdmobileapp/models/mylist/CreateListRequest;", "(Ljava/lang/String;Lcom/atd/atdmobileapp/models/mylist/CreateListRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMyList", "(Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/mylist/MyListResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MyListRepository {
    private final com.atd.atdmobileapp.api.ListApi listApi = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.MyListResponse>> _myListResponseLiveData = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> _deleteResponseLiveData = null;
    
    @javax.inject.Inject
    public MyListRepository(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.ListApi listApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.MyListResponse>> get_myListResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.MyListResponse>> getMyListResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> get_deleteResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> getDeleteResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMyList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveMyList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.mylist.CreateListRequest request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateMyList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String listName, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.mylist.MyListResponse request, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object DeleteItemFromList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String listName, @org.jetbrains.annotations.NotNull
    java.lang.String productNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String listName, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final void handleDeleteResponse(retrofit2.Response<com.atd.atdmobileapp.models.mylist.DeleteItemResp> response) {
    }
    
    private final void handleUpdateResponse(retrofit2.Response<com.atd.atdmobileapp.models.mylist.MyListResponse> response) {
    }
    
    private final void handleSavedResponse(retrofit2.Response<com.atd.atdmobileapp.models.mylist.MyListResponse> response) {
    }
    
    private final void handleResponse(retrofit2.Response<com.atd.atdmobileapp.models.mylist.MyListResponse> response) {
    }
}