package com.atd.atdmobileapp.ui.mylists;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001ABi\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0010\u00a2\u0006\u0002\u0010\u0012J\u001e\u00105\u001a\u00020\r2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\b\u00107\u001a\u00020\u000bH\u0016J\u0018\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000bH\u0016J\u000e\u0010+\u001a\u00020\r2\u0006\u0010+\u001a\u00020,J\u001d\u0010?\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\f\u00a2\u0006\u0002\u0010@R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010$R1\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104\u00a8\u0006B"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/mylists/MyListDetailsAdapter$ViewHolder;", "productList", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "Lkotlin/collections/ArrayList;", "activity", "Landroidx/fragment/app/FragmentActivity;", "updateItems", "Lkotlin/reflect/KFunction4;", "", "", "", "themeColor", "callProductDetails", "Lkotlin/Function1;", "Landroid/os/Bundle;", "(Ljava/util/ArrayList;Landroidx/fragment/app/FragmentActivity;Lkotlin/reflect/KFunction;ILkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "atdProductNumber", "getAtdProductNumber", "()Ljava/lang/String;", "setAtdProductNumber", "(Ljava/lang/String;)V", "getCallProductDetails", "()Lkotlin/jvm/functions/Function1;", "increasedQuantity", "getIncreasedQuantity", "()Ljava/lang/Integer;", "setIncreasedQuantity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "items", "getItems", "()I", "setItems", "(I)V", "getProductList", "()Ljava/util/ArrayList;", "setProductList", "(Ljava/util/ArrayList;)V", "selectAll", "", "getSelectAll", "()Ljava/lang/Boolean;", "setSelectAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getThemeColor", "getUpdateItems", "()Lkotlin/reflect/KFunction;", "Update", "result", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateQuantity", "(Ljava/lang/Integer;Ljava/lang/String;)V", "ViewHolder", "app_debug"})
public final class MyListDetailsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.mylists.MyListDetailsAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> productList;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity activity = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.reflect.KFunction<kotlin.Unit> updateItems = null;
    private final int themeColor = 0;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<android.os.Bundle, kotlin.Unit> callProductDetails = null;
    private int items = 0;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean selectAll;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer increasedQuantity = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String atdProductNumber = "";
    
    public MyListDetailsAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> productList, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull
    kotlin.reflect.KFunction<kotlin.Unit> updateItems, int themeColor, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> callProductDetails) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> getProductList() {
        return null;
    }
    
    public final void setProductList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KFunction<kotlin.Unit> getUpdateItems() {
        return null;
    }
    
    public final int getThemeColor() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<android.os.Bundle, kotlin.Unit> getCallProductDetails() {
        return null;
    }
    
    public final int getItems() {
        return 0;
    }
    
    public final void setItems(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getSelectAll() {
        return null;
    }
    
    public final void setSelectAll(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getIncreasedQuantity() {
        return null;
    }
    
    public final void setIncreasedQuantity(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAtdProductNumber() {
        return null;
    }
    
    public final void setAtdProductNumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.mylists.MyListDetailsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.mylists.MyListDetailsAdapter.ViewHolder holder, int position) {
    }
    
    public final void Update(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> result) {
    }
    
    public final void selectAll(boolean selectAll) {
    }
    
    public final void updateQuantity(@org.jetbrains.annotations.Nullable
    java.lang.Integer increasedQuantity, @org.jetbrains.annotations.NotNull
    java.lang.String atdProductNumber) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListDetailsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/MyListDetailsChildItemsBinding;", "(Lcom/atd/atdmobileapp/databinding/MyListDetailsChildItemsBinding;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/MyListDetailsChildItemsBinding;", "bind", "", "themeColor", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.MyListDetailsChildItemsBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.MyListDetailsChildItemsBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.MyListDetailsChildItemsBinding getBinding() {
            return null;
        }
        
        public final void bind(int themeColor, @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity activity) {
        }
    }
}