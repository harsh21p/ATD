package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersAdapter$DataViewHolder;", "Orders", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/myordersdata/Orderstatuse;", "Lkotlin/collections/ArrayList;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Ljava/util/ArrayList;Landroidx/fragment/app/FragmentActivity;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "showAll", "", "addOrders", "", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "viewAll", "DataViewHolder", "app_release"})
public final class MyOrdersAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersAdapter.DataViewHolder> {
    private final java.util.ArrayList<com.atd.atdmobileapp.models.myordersdata.Orderstatuse> Orders = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    private boolean showAll = false;
    
    public MyOrdersAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.myordersdata.Orderstatuse> Orders, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersAdapter.DataViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersAdapter.DataViewHolder holder, int position) {
    }
    
    public final void addOrders(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myordersdata.Orderstatuse> Orders) {
    }
    
    public final void viewAll(boolean showAll) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/MyOrdersAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "datePlaced", "Landroid/widget/TextView;", "getDatePlaced", "()Landroid/widget/TextView;", "setDatePlaced", "(Landroid/widget/TextView;)V", "orderNum", "getOrderNum", "setOrderNum", "orderStatus", "getOrderStatus", "setOrderStatus", "tvCnfNum", "getTvCnfNum", "setTvCnfNum", "bind", "", "orderstatuse", "Lcom/atd/atdmobileapp/models/myordersdata/Orderstatuse;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "app_release"})
    public static final class DataViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView tvCnfNum;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView orderStatus;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView orderNum;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView datePlaced;
        
        public DataViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTvCnfNum() {
            return null;
        }
        
        public final void setTvCnfNum(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getOrderStatus() {
            return null;
        }
        
        public final void setOrderStatus(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getOrderNum() {
            return null;
        }
        
        public final void setOrderNum(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getDatePlaced() {
            return null;
        }
        
        public final void setDatePlaced(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.myordersdata.Orderstatuse orderstatuse, @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity requireActivity) {
        }
    }
}