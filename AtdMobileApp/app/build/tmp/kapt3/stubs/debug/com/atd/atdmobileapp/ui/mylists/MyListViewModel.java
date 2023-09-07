package com.atd.atdmobileapp.ui.mylists;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0013J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ*\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListViewModel;", "Landroidx/lifecycle/ViewModel;", "Repository", "Lcom/atd/atdmobileapp/repository/MyListRepository;", "(Lcom/atd/atdmobileapp/repository/MyListRepository;)V", "deleteHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "deleteItemResponse", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "Lcom/atd/atdmobileapp/models/mylist/DeleteItemResp;", "getDeleteItemResponse", "()Landroidx/lifecycle/LiveData;", "handler", "myListLiveData", "Lcom/atd/atdmobileapp/models/mylist/MyListResponse;", "getMyListLiveData", "deleteItemFromList", "location", "", "listName", "productNumber", "deleteList", "getMyList", "", "locationNumber", "saveMyList", "request", "Lcom/atd/atdmobileapp/models/mylist/CreateListRequest;", "updateMyList", "app_debug"})
public final class MyListViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.MyListRepository Repository = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler handler = null;
    private final kotlinx.coroutines.CoroutineExceptionHandler deleteHandler = null;
    
    @javax.inject.Inject
    public MyListViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.MyListRepository Repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> getDeleteItemResponse() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.MyListResponse>> getMyListLiveData() {
        return null;
    }
    
    public final void getMyList(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.MyListResponse>> saveMyList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.mylist.CreateListRequest request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.MyListResponse>> updateMyList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String listName, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.mylist.MyListResponse request) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> deleteItemFromList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String listName, @org.jetbrains.annotations.NotNull
    java.lang.String productNumber) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<com.atd.atdmobileapp.models.mylist.DeleteItemResp>> deleteList(@org.jetbrains.annotations.NotNull
    java.lang.String location, @org.jetbrains.annotations.NotNull
    java.lang.String listName) {
        return null;
    }
}