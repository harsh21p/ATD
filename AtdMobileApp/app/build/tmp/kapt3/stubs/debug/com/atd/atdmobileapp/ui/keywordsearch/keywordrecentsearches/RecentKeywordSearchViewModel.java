package com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011J\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\bJ\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\b2\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0015J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/RecentKeywordSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "rdbKeywordSearchRepository", "Lcom/atd/atdmobileapp/repository/RDBKeywordSearchRepository;", "firestoreRepository", "Lcom/atd/atdmobileapp/utils/FirestoreRepository;", "(Lcom/atd/atdmobileapp/repository/RDBKeywordSearchRepository;Lcom/atd/atdmobileapp/utils/FirestoreRepository;)V", "keywordResponseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/atd/atdmobileapp/utils/NetworkResult;", "", "Lcom/atd/atdmobileapp/roomdatabase/keywordsearch/PreviousKeywordSearchEntity;", "getKeywordResponseLiveData", "()Landroidx/lifecycle/LiveData;", "userCartData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/atd/atdmobileapp/models/Cart;", "getUserCartData", "()Landroidx/lifecycle/MutableLiveData;", "createCartRecordInFireStore", "", "cart", "getAllCartRecords", "getCreatedCartRecordInFireStore", "getMyKeywords", "saveKeyword", "Keyword", "app_debug"})
public final class RecentKeywordSearchViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.repository.RDBKeywordSearchRepository rdbKeywordSearchRepository = null;
    private final com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> userCartData = null;
    
    @javax.inject.Inject
    public RecentKeywordSearchViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.repository.RDBKeywordSearchRepository rdbKeywordSearchRepository, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.FirestoreRepository firestoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.NetworkResult<java.util.List<com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity>>> getKeywordResponseLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> getUserCartData() {
        return null;
    }
    
    public final void getMyKeywords() {
    }
    
    public final void saveKeyword(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity Keyword) {
    }
    
    public final void createCartRecordInFireStore(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Cart cart) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> getCreatedCartRecordInFireStore(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Cart cart) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.atd.atdmobileapp.models.Cart>> getAllCartRecords() {
        return null;
    }
}