package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\u0010\u0017J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u000fH\u00c6\u0003J\t\u0010.\u001a\u00020\bH\u00c6\u0003J\t\u0010/\u001a\u00020\rH\u00c6\u0003J\t\u00100\u001a\u00020\rH\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0005H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\bH\u00c6\u0003J\t\u00105\u001a\u00020\nH\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\rH\u00c6\u0003J\t\u00108\u001a\u00020\u000fH\u00c6\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003H\u00c6\u0003J\u00a7\u0001\u0010:\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0001J\u0013\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010=\u001a\u00020\bH\u00d6\u0001J\t\u0010>\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010%R\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\u0015\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019\u00a8\u0006?"}, d2 = {"Lcom/atd/atdmobileapp/models/OrderlineX;", "", "addons", "", "atdproductnumber", "", "billto", "cartlinenumber", "", "cost", "", "description", "discontinued", "", "fet", "", "fulfillments", "Lcom/atd/atdmobileapp/models/FulfillmentX;", "linetotal", "quantityordered", "quickship", "replaced", "statusmessages", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;ZDLjava/util/List;DIZZLjava/util/List;)V", "getAddons", "()Ljava/util/List;", "getAtdproductnumber", "()Ljava/lang/String;", "getBillto", "getCartlinenumber", "()I", "getCost", "()F", "getDescription", "getDiscontinued", "()Z", "getFet", "()D", "getFulfillments", "getLinetotal", "getQuantityordered", "getQuickship", "getReplaced", "getStatusmessages", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class OrderlineX {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> addons = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String atdproductnumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String billto = null;
    private final int cartlinenumber = 0;
    private final float cost = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final boolean discontinued = false;
    private final double fet = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.FulfillmentX> fulfillments = null;
    private final double linetotal = 0.0;
    private final int quantityordered = 0;
    private final boolean quickship = false;
    private final boolean replaced = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> statusmessages = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.OrderlineX copy(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> addons, @org.jetbrains.annotations.NotNull
    java.lang.String atdproductnumber, @org.jetbrains.annotations.NotNull
    java.lang.String billto, int cartlinenumber, float cost, @org.jetbrains.annotations.NotNull
    java.lang.String description, boolean discontinued, double fet, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.FulfillmentX> fulfillments, double linetotal, int quantityordered, boolean quickship, boolean replaced, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> statusmessages) {
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
    
    public OrderlineX(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> addons, @org.jetbrains.annotations.NotNull
    java.lang.String atdproductnumber, @org.jetbrains.annotations.NotNull
    java.lang.String billto, int cartlinenumber, float cost, @org.jetbrains.annotations.NotNull
    java.lang.String description, boolean discontinued, double fet, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.FulfillmentX> fulfillments, double linetotal, int quantityordered, boolean quickship, boolean replaced, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> statusmessages) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getAddons() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAtdproductnumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBillto() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getCartlinenumber() {
        return 0;
    }
    
    public final float component5() {
        return 0.0F;
    }
    
    public final float getCost() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getDiscontinued() {
        return false;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double getFet() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.FulfillmentX> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.FulfillmentX> getFulfillments() {
        return null;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double getLinetotal() {
        return 0.0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getQuantityordered() {
        return 0;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean getQuickship() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean getReplaced() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getStatusmessages() {
        return null;
    }
}