package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\t\u0010&\u001a\u00020\u000eH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\tH\u00c6\u0003Ji\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\tH\u00c6\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019\u00a8\u0006/"}, d2 = {"Lcom/atd/atdmobileapp/models/OrderXXX;", "", "confirmationnumber", "", "consumerdata", "Lcom/atd/atdmobileapp/models/ConsumerdataX;", "customercomment", "customerponumber", "localplus", "", "orderlines", "", "Lcom/atd/atdmobileapp/models/OrderlineX;", "ordertotal", "", "ordertype", "pickup", "(Ljava/lang/String;Lcom/atd/atdmobileapp/models/ConsumerdataX;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;DLjava/lang/String;Z)V", "getConfirmationnumber", "()Ljava/lang/String;", "getConsumerdata", "()Lcom/atd/atdmobileapp/models/ConsumerdataX;", "getCustomercomment", "getCustomerponumber", "getLocalplus", "()Z", "getOrderlines", "()Ljava/util/List;", "getOrdertotal", "()D", "getOrdertype", "getPickup", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class OrderXXX {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String confirmationnumber = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.ConsumerdataX consumerdata = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customercomment = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customerponumber = null;
    private final boolean localplus = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.OrderlineX> orderlines = null;
    private final double ordertotal = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String ordertype = null;
    private final boolean pickup = false;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.OrderXXX copy(@org.jetbrains.annotations.NotNull
    java.lang.String confirmationnumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.ConsumerdataX consumerdata, @org.jetbrains.annotations.NotNull
    java.lang.String customercomment, @org.jetbrains.annotations.NotNull
    java.lang.String customerponumber, boolean localplus, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.OrderlineX> orderlines, double ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String ordertype, boolean pickup) {
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
    
    public OrderXXX(@org.jetbrains.annotations.NotNull
    java.lang.String confirmationnumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.ConsumerdataX consumerdata, @org.jetbrains.annotations.NotNull
    java.lang.String customercomment, @org.jetbrains.annotations.NotNull
    java.lang.String customerponumber, boolean localplus, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.OrderlineX> orderlines, double ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String ordertype, boolean pickup) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConfirmationnumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.ConsumerdataX component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.ConsumerdataX getConsumerdata() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomercomment() {
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
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getLocalplus() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.OrderlineX> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.OrderlineX> getOrderlines() {
        return null;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double getOrdertotal() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOrdertype() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getPickup() {
        return false;
    }
}