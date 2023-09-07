package com.atd.atdmobileapp.models.orderdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0006H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\tH\u00c6\u0003J\t\u0010D\u001a\u00020\tH\u00c6\u0003J\t\u0010E\u001a\u00020\tH\u00c6\u0003J\t\u0010F\u001a\u00020\tH\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\u009f\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020\tH\u00d6\u0001J\t\u0010M\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018\u00a8\u0006N"}, d2 = {"Lcom/atd/atdmobileapp/models/orderdetails/Fulfillment;", "", "carriername", "", "deliveryreceiptnumber", "linetotal", "", "ordernumber", "quantity", "", "quantitybackordered", "quantityreturnable", "quantityshipped", "shipmethod", "sourcetype", "sourcetypedc", "status", "trackingurl", "invoicenumber", "actualdeliverydate", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActualdeliverydate", "()Ljava/lang/String;", "setActualdeliverydate", "(Ljava/lang/String;)V", "getCarriername", "setCarriername", "getDeliveryreceiptnumber", "setDeliveryreceiptnumber", "getInvoicenumber", "setInvoicenumber", "getLinetotal", "()D", "setLinetotal", "(D)V", "getOrdernumber", "setOrdernumber", "getQuantity", "()I", "setQuantity", "(I)V", "getQuantitybackordered", "setQuantitybackordered", "getQuantityreturnable", "setQuantityreturnable", "getQuantityshipped", "setQuantityshipped", "getShipmethod", "setShipmethod", "getSourcetype", "setSourcetype", "getSourcetypedc", "setSourcetypedc", "getStatus", "setStatus", "getTrackingurl", "setTrackingurl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
public final class Fulfillment {
    @org.jetbrains.annotations.NotNull
    private java.lang.String carriername;
    @org.jetbrains.annotations.NotNull
    private java.lang.String deliveryreceiptnumber;
    private double linetotal;
    @org.jetbrains.annotations.NotNull
    private java.lang.String ordernumber;
    private int quantity;
    private int quantitybackordered;
    private int quantityreturnable;
    private int quantityshipped;
    @org.jetbrains.annotations.NotNull
    private java.lang.String shipmethod;
    @org.jetbrains.annotations.NotNull
    private java.lang.String sourcetype;
    @org.jetbrains.annotations.NotNull
    private java.lang.String sourcetypedc;
    @org.jetbrains.annotations.NotNull
    private java.lang.String status;
    @org.jetbrains.annotations.NotNull
    private java.lang.String trackingurl;
    @org.jetbrains.annotations.NotNull
    private java.lang.String invoicenumber;
    @org.jetbrains.annotations.NotNull
    private java.lang.String actualdeliverydate;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.orderdetails.Fulfillment copy(@org.jetbrains.annotations.NotNull
    java.lang.String carriername, @org.jetbrains.annotations.NotNull
    java.lang.String deliveryreceiptnumber, double linetotal, @org.jetbrains.annotations.NotNull
    java.lang.String ordernumber, int quantity, int quantitybackordered, int quantityreturnable, int quantityshipped, @org.jetbrains.annotations.NotNull
    java.lang.String shipmethod, @org.jetbrains.annotations.NotNull
    java.lang.String sourcetype, @org.jetbrains.annotations.NotNull
    java.lang.String sourcetypedc, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    java.lang.String trackingurl, @org.jetbrains.annotations.NotNull
    java.lang.String invoicenumber, @org.jetbrains.annotations.NotNull
    java.lang.String actualdeliverydate) {
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
    
    public Fulfillment(@org.jetbrains.annotations.NotNull
    java.lang.String carriername, @org.jetbrains.annotations.NotNull
    java.lang.String deliveryreceiptnumber, double linetotal, @org.jetbrains.annotations.NotNull
    java.lang.String ordernumber, int quantity, int quantitybackordered, int quantityreturnable, int quantityshipped, @org.jetbrains.annotations.NotNull
    java.lang.String shipmethod, @org.jetbrains.annotations.NotNull
    java.lang.String sourcetype, @org.jetbrains.annotations.NotNull
    java.lang.String sourcetypedc, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    java.lang.String trackingurl, @org.jetbrains.annotations.NotNull
    java.lang.String invoicenumber, @org.jetbrains.annotations.NotNull
    java.lang.String actualdeliverydate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCarriername() {
        return null;
    }
    
    public final void setCarriername(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDeliveryreceiptnumber() {
        return null;
    }
    
    public final void setDeliveryreceiptnumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double getLinetotal() {
        return 0.0;
    }
    
    public final void setLinetotal(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOrdernumber() {
        return null;
    }
    
    public final void setOrdernumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final void setQuantity(int p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getQuantitybackordered() {
        return 0;
    }
    
    public final void setQuantitybackordered(int p0) {
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getQuantityreturnable() {
        return 0;
    }
    
    public final void setQuantityreturnable(int p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getQuantityshipped() {
        return 0;
    }
    
    public final void setQuantityshipped(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShipmethod() {
        return null;
    }
    
    public final void setShipmethod(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSourcetype() {
        return null;
    }
    
    public final void setSourcetype(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSourcetypedc() {
        return null;
    }
    
    public final void setSourcetypedc(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTrackingurl() {
        return null;
    }
    
    public final void setTrackingurl(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInvoicenumber() {
        return null;
    }
    
    public final void setInvoicenumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getActualdeliverydate() {
        return null;
    }
    
    public final void setActualdeliverydate(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
}