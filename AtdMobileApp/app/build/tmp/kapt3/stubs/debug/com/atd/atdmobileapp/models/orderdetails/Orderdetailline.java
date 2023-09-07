package com.atd.atdmobileapp.models.orderdetails;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003J_\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0006H\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b\'\u0010\u0019\u00a8\u00066"}, d2 = {"Lcom/atd/atdmobileapp/models/orderdetails/Orderdetailline;", "", "atdproductnumber", "", "billto", "cartlinenumber", "", "cost", "", "description", "fet", "fulfillments", "", "Lcom/atd/atdmobileapp/models/orderdetails/Fulfillment;", "quantity", "(Ljava/lang/String;Ljava/lang/String;IDLjava/lang/String;DLjava/util/List;I)V", "getAtdproductnumber", "()Ljava/lang/String;", "setAtdproductnumber", "(Ljava/lang/String;)V", "getBillto", "setBillto", "getCartlinenumber", "()I", "setCartlinenumber", "(I)V", "getCost", "()D", "setCost", "(D)V", "getDescription", "setDescription", "getFet", "setFet", "getFulfillments", "()Ljava/util/List;", "setFulfillments", "(Ljava/util/List;)V", "getQuantity", "setQuantity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Orderdetailline {
    @org.jetbrains.annotations.NotNull
    private java.lang.String atdproductnumber;
    @org.jetbrains.annotations.NotNull
    private java.lang.String billto;
    private int cartlinenumber;
    private double cost;
    @org.jetbrains.annotations.NotNull
    private java.lang.String description;
    private double fet;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.atd.atdmobileapp.models.orderdetails.Fulfillment> fulfillments;
    private int quantity;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.orderdetails.Orderdetailline copy(@org.jetbrains.annotations.NotNull
    java.lang.String atdproductnumber, @org.jetbrains.annotations.NotNull
    java.lang.String billto, int cartlinenumber, double cost, @org.jetbrains.annotations.NotNull
    java.lang.String description, double fet, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Fulfillment> fulfillments, int quantity) {
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
    
    public Orderdetailline(@org.jetbrains.annotations.NotNull
    java.lang.String atdproductnumber, @org.jetbrains.annotations.NotNull
    java.lang.String billto, int cartlinenumber, double cost, @org.jetbrains.annotations.NotNull
    java.lang.String description, double fet, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Fulfillment> fulfillments, int quantity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAtdproductnumber() {
        return null;
    }
    
    public final void setAtdproductnumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBillto() {
        return null;
    }
    
    public final void setBillto(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getCartlinenumber() {
        return 0;
    }
    
    public final void setCartlinenumber(int p0) {
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double getCost() {
        return 0.0;
    }
    
    public final void setCost(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getFet() {
        return 0.0;
    }
    
    public final void setFet(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.orderdetails.Fulfillment> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.orderdetails.Fulfillment> getFulfillments() {
        return null;
    }
    
    public final void setFulfillments(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.orderdetails.Fulfillment> p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final void setQuantity(int p0) {
    }
}