package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ8\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001fH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001fH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006("}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/myorderdetails/MyOrdersDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/myorderdetails/MyOrdersDetailsAdapter$DataViewHolder;", "Orders", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/orderdetails/Orderdetailline;", "Lkotlin/collections/ArrayList;", "orderApi", "Lcom/atd/atdmobileapp/api/OrderApi;", "(Ljava/util/ArrayList;Lcom/atd/atdmobileapp/api/OrderApi;)V", "comments", "", "getComments", "()Ljava/lang/String;", "setComments", "(Ljava/lang/String;)V", "confirmationNumber", "getConfirmationNumber", "setConfirmationNumber", "datePlaced", "getDatePlaced", "setDatePlaced", "location", "getLocation", "setLocation", "getOrderApi", "()Lcom/atd/atdmobileapp/api/OrderApi;", "addOrders", "", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DataViewHolder", "app_release"})
public final class MyOrdersDetailsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrdersDetailsAdapter.DataViewHolder> {
    private final java.util.ArrayList<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> Orders = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.api.OrderApi orderApi = null;
    public java.lang.String datePlaced;
    public java.lang.String comments;
    public java.lang.String location;
    public java.lang.String confirmationNumber;
    
    public MyOrdersDetailsAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> Orders, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.api.OrderApi orderApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.api.OrderApi getOrderApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDatePlaced() {
        return null;
    }
    
    public final void setDatePlaced(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getComments() {
        return null;
    }
    
    public final void setComments(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConfirmationNumber() {
        return null;
    }
    
    public final void setConfirmationNumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrdersDetailsAdapter.DataViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrdersDetailsAdapter.DataViewHolder holder, int position) {
    }
    
    public final void addOrders(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> Orders, @org.jetbrains.annotations.NotNull
    java.lang.String datePlaced, @org.jetbrains.annotations.NotNull
    java.lang.String comments, @org.jetbrains.annotations.Nullable
    java.lang.String location, @org.jetbrains.annotations.Nullable
    java.lang.String confirmationNumber) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J6\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/myorders/myorderdetails/MyOrdersDetailsAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/OrderDetailsItemBinding;", "(Lcom/atd/atdmobileapp/databinding/OrderDetailsItemBinding;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/OrderDetailsItemBinding;", "ReturnItemAvailability", "", "result", "Lretrofit2/Response;", "Lcom/atd/atdmobileapp/models/itemreturndetails/ItemReturnAvailableResponse;", "bind", "orderdetaillines", "Lcom/atd/atdmobileapp/models/orderdetails/Orderdetailline;", "orderApi", "Lcom/atd/atdmobileapp/api/OrderApi;", "datePlaced", "", "comments", "location", "confirmationNumber", "app_release"})
    public static final class DataViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.OrderDetailsItemBinding binding = null;
        
        public DataViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.OrderDetailsItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.OrderDetailsItemBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.orderdetails.Orderdetailline orderdetaillines, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.api.OrderApi orderApi, @org.jetbrains.annotations.NotNull
        java.lang.String datePlaced, @org.jetbrains.annotations.NotNull
        java.lang.String comments, @org.jetbrains.annotations.NotNull
        java.lang.String location, @org.jetbrains.annotations.NotNull
        java.lang.String confirmationNumber) {
        }
        
        private final void ReturnItemAvailability(retrofit2.Response<com.atd.atdmobileapp.models.itemreturndetails.ItemReturnAvailableResponse> result) {
        }
    }
}