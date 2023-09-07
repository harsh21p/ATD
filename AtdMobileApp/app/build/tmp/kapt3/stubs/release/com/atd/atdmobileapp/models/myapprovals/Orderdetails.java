package com.atd.atdmobileapp.models.myapprovals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\bH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003Ji\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006,"}, d2 = {"Lcom/atd/atdmobileapp/models/myapprovals/Orderdetails;", "", "customeraddress", "", "customercomments", "customername", "customernumber", "freight", "", "locationnumber", "orderdetaillines", "", "Lcom/atd/atdmobileapp/models/myapprovals/OrderDetaillinesItem;", "ordertotal", "subtotal", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;DLjava/lang/String;)V", "getCustomeraddress", "()Ljava/lang/String;", "getCustomercomments", "getCustomername", "getCustomernumber", "getFreight", "()D", "getLocationnumber", "getOrderdetaillines", "()Ljava/util/List;", "getOrdertotal", "getSubtotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class Orderdetails {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customeraddress = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customercomments = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customername = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customernumber = null;
    private final double freight = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationnumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem> orderdetaillines = null;
    private final double ordertotal = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String subtotal = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myapprovals.Orderdetails copy(@org.jetbrains.annotations.NotNull
    java.lang.String customeraddress, @org.jetbrains.annotations.NotNull
    java.lang.String customercomments, @org.jetbrains.annotations.NotNull
    java.lang.String customername, @org.jetbrains.annotations.NotNull
    java.lang.String customernumber, double freight, @org.jetbrains.annotations.NotNull
    java.lang.String locationnumber, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem> orderdetaillines, double ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String subtotal) {
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
    
    public Orderdetails(@org.jetbrains.annotations.NotNull
    java.lang.String customeraddress, @org.jetbrains.annotations.NotNull
    java.lang.String customercomments, @org.jetbrains.annotations.NotNull
    java.lang.String customername, @org.jetbrains.annotations.NotNull
    java.lang.String customernumber, double freight, @org.jetbrains.annotations.NotNull
    java.lang.String locationnumber, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem> orderdetaillines, double ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String subtotal) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomeraddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomercomments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomernumber() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double getFreight() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationnumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem> getOrderdetaillines() {
        return null;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double getOrdertotal() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSubtotal() {
        return null;
    }
}