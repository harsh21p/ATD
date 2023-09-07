package com.atd.atdmobileapp.models.orderdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\nH\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\nH\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\nH\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\u0087\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\nH\u00c6\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010A\u001a\u00020BH\u00d6\u0001J\t\u0010C\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010\u0011\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$\u00a8\u0006D"}, d2 = {"Lcom/atd/atdmobileapp/models/orderdetails/Orderstatusdetail;", "", "approvedby", "", "confirmationnumber", "consumername", "customercomments", "customerponumber", "dateplaced", "freight", "", "locationnumber", "orderdetaillines", "", "Lcom/atd/atdmobileapp/models/orderdetails/Orderdetailline;", "ordertotal", "pickup", "taxes", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/util/List;DLjava/lang/String;D)V", "getApprovedby", "()Ljava/lang/String;", "setApprovedby", "(Ljava/lang/String;)V", "getConfirmationnumber", "setConfirmationnumber", "getConsumername", "setConsumername", "getCustomercomments", "setCustomercomments", "getCustomerponumber", "setCustomerponumber", "getDateplaced", "setDateplaced", "getFreight", "()D", "setFreight", "(D)V", "getLocationnumber", "setLocationnumber", "getOrderdetaillines", "()Ljava/util/List;", "setOrderdetaillines", "(Ljava/util/List;)V", "getOrdertotal", "setOrdertotal", "getPickup", "setPickup", "getTaxes", "setTaxes", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Orderstatusdetail {
    @org.jetbrains.annotations.NotNull
    private java.lang.String approvedby;
    @org.jetbrains.annotations.NotNull
    private java.lang.String confirmationnumber;
    @org.jetbrains.annotations.NotNull
    private java.lang.String consumername;
    @org.jetbrains.annotations.NotNull
    private java.lang.String customercomments;
    @org.jetbrains.annotations.NotNull
    private java.lang.String customerponumber;
    @org.jetbrains.annotations.NotNull
    private java.lang.String dateplaced;
    private double freight;
    @org.jetbrains.annotations.NotNull
    private java.lang.String locationnumber;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> orderdetaillines;
    private double ordertotal;
    @org.jetbrains.annotations.NotNull
    private java.lang.String pickup;
    private double taxes;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.orderdetails.Orderstatusdetail copy(@org.jetbrains.annotations.NotNull
    java.lang.String approvedby, @org.jetbrains.annotations.NotNull
    java.lang.String confirmationnumber, @org.jetbrains.annotations.NotNull
    java.lang.String consumername, @org.jetbrains.annotations.NotNull
    java.lang.String customercomments, @org.jetbrains.annotations.NotNull
    java.lang.String customerponumber, @org.jetbrains.annotations.NotNull
    java.lang.String dateplaced, double freight, @org.jetbrains.annotations.NotNull
    java.lang.String locationnumber, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> orderdetaillines, double ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String pickup, double taxes) {
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
    
    public Orderstatusdetail(@org.jetbrains.annotations.NotNull
    java.lang.String approvedby, @org.jetbrains.annotations.NotNull
    java.lang.String confirmationnumber, @org.jetbrains.annotations.NotNull
    java.lang.String consumername, @org.jetbrains.annotations.NotNull
    java.lang.String customercomments, @org.jetbrains.annotations.NotNull
    java.lang.String customerponumber, @org.jetbrains.annotations.NotNull
    java.lang.String dateplaced, double freight, @org.jetbrains.annotations.NotNull
    java.lang.String locationnumber, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> orderdetaillines, double ordertotal, @org.jetbrains.annotations.NotNull
    java.lang.String pickup, double taxes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApprovedby() {
        return null;
    }
    
    public final void setApprovedby(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConfirmationnumber() {
        return null;
    }
    
    public final void setConfirmationnumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConsumername() {
        return null;
    }
    
    public final void setConsumername(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomercomments() {
        return null;
    }
    
    public final void setCustomercomments(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomerponumber() {
        return null;
    }
    
    public final void setCustomerponumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDateplaced() {
        return null;
    }
    
    public final void setDateplaced(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double getFreight() {
        return 0.0;
    }
    
    public final void setFreight(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationnumber() {
        return null;
    }
    
    public final void setLocationnumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> getOrderdetaillines() {
        return null;
    }
    
    public final void setOrderdetaillines(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Orderdetailline> p0) {
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double getOrdertotal() {
        return 0.0;
    }
    
    public final void setOrdertotal(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPickup() {
        return null;
    }
    
    public final void setPickup(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double getTaxes() {
        return 0.0;
    }
    
    public final void setTaxes(double p0) {
    }
}