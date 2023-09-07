package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\nH\u00c6\u0003J\t\u0010(\u001a\u00020\u0001H\u00c6\u0003J\t\u0010)\u001a\u00020\u0001H\u00c6\u0003J\t\u0010*\u001a\u00020\u0001H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\t\u0010-\u001a\u00020\nH\u00c6\u0003J\t\u0010.\u001a\u00020\u0001H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0001H\u00c6\u0001J\u0013\u00102\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u000205H\u00d6\u0001J\t\u00106\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017\u00a8\u00067"}, d2 = {"Lcom/atd/atdmobileapp/models/OrderX;", "", "consumerdata", "Lcom/atd/atdmobileapp/models/Consumerdata;", "consumername", "customercomment", "customerponumber", "", "fillkill", "localplus", "", "needbydate", "orderlines", "", "Lcom/atd/atdmobileapp/models/Orderline;", "ordertotal", "ordertype", "pickup", "thresholdmessage", "(Lcom/atd/atdmobileapp/models/Consumerdata;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/Object;)V", "getConsumerdata", "()Lcom/atd/atdmobileapp/models/Consumerdata;", "getConsumername", "()Ljava/lang/Object;", "getCustomercomment", "getCustomerponumber", "()Ljava/lang/String;", "getFillkill", "getLocalplus", "()Z", "getNeedbydate", "getOrderlines", "()Ljava/util/List;", "getOrdertotal", "getOrdertype", "getPickup", "getThresholdmessage", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class OrderX {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Consumerdata consumerdata = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object consumername = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object customercomment = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customerponumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String fillkill = null;
    private final boolean localplus = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object needbydate = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.Orderline> orderlines = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Object ordertotal = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String ordertype = null;
    private final boolean pickup = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Object thresholdmessage = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.OrderX copy(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Consumerdata consumerdata, @org.jetbrains.annotations.NotNull
    java.lang.Object consumername, @org.jetbrains.annotations.NotNull
    java.lang.Object customercomment, @org.jetbrains.annotations.NotNull
    java.lang.String customerponumber, @org.jetbrains.annotations.NotNull
    java.lang.String fillkill, boolean localplus, @org.jetbrains.annotations.NotNull
    java.lang.Object needbydate, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.Orderline> orderlines, @org.jetbrains.annotations.Nullable
    java.lang.Object ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String ordertype, boolean pickup, @org.jetbrains.annotations.NotNull
    java.lang.Object thresholdmessage) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public OrderX(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Consumerdata consumerdata, @org.jetbrains.annotations.NotNull
    java.lang.Object consumername, @org.jetbrains.annotations.NotNull
    java.lang.Object customercomment, @org.jetbrains.annotations.NotNull
    java.lang.String customerponumber, @org.jetbrains.annotations.NotNull
    java.lang.String fillkill, boolean localplus, @org.jetbrains.annotations.NotNull
    java.lang.Object needbydate, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.Orderline> orderlines, @org.jetbrains.annotations.Nullable
    java.lang.Object ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String ordertype, boolean pickup, @org.jetbrains.annotations.NotNull
    java.lang.Object thresholdmessage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Consumerdata component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Consumerdata getConsumerdata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getConsumername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getCustomercomment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomerponumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFillkill() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getLocalplus() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getNeedbydate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.Orderline> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.Orderline> getOrderlines() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOrdertotal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOrdertype() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getPickup() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object getThresholdmessage() {
        return null;
    }
}