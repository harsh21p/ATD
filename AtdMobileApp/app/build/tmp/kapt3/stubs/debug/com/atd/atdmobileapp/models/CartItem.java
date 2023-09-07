package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u000fH\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0012H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u0095\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00108\u001a\u00020\u0007H\u00d6\u0001J\t\u00109\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016\u00a8\u0006:"}, d2 = {"Lcom/atd/atdmobileapp/models/CartItem;", "", "brand", "", "style", "description", "quantity", "", "quantityBackOrder", "quantityBackOrderString", "productImage", "supplier", "cost", "fet", "freight", "", "itemSubtotal", "discontinued", "", "createdDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;ZLjava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getCost", "getCreatedDate", "getDescription", "getDiscontinued", "()Z", "getFet", "getFreight", "()D", "getItemSubtotal", "getProductImage", "getQuantity", "()I", "getQuantityBackOrder", "getQuantityBackOrderString", "getStyle", "getSupplier", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class CartItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String brand = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String style = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final int quantity = 0;
    private final int quantityBackOrder = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String quantityBackOrderString = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String productImage = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String supplier = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cost = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String fet = null;
    private final double freight = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String itemSubtotal = null;
    private final boolean discontinued = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String createdDate = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.CartItem copy(@org.jetbrains.annotations.NotNull
    java.lang.String brand, @org.jetbrains.annotations.NotNull
    java.lang.String style, @org.jetbrains.annotations.NotNull
    java.lang.String description, int quantity, int quantityBackOrder, @org.jetbrains.annotations.NotNull
    java.lang.String quantityBackOrderString, @org.jetbrains.annotations.NotNull
    java.lang.String productImage, @org.jetbrains.annotations.NotNull
    java.lang.String supplier, @org.jetbrains.annotations.NotNull
    java.lang.String cost, @org.jetbrains.annotations.NotNull
    java.lang.String fet, double freight, @org.jetbrains.annotations.NotNull
    java.lang.String itemSubtotal, boolean discontinued, @org.jetbrains.annotations.NotNull
    java.lang.String createdDate) {
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
    
    public CartItem(@org.jetbrains.annotations.NotNull
    java.lang.String brand, @org.jetbrains.annotations.NotNull
    java.lang.String style, @org.jetbrains.annotations.NotNull
    java.lang.String description, int quantity, int quantityBackOrder, @org.jetbrains.annotations.NotNull
    java.lang.String quantityBackOrderString, @org.jetbrains.annotations.NotNull
    java.lang.String productImage, @org.jetbrains.annotations.NotNull
    java.lang.String supplier, @org.jetbrains.annotations.NotNull
    java.lang.String cost, @org.jetbrains.annotations.NotNull
    java.lang.String fet, double freight, @org.jetbrains.annotations.NotNull
    java.lang.String itemSubtotal, boolean discontinued, @org.jetbrains.annotations.NotNull
    java.lang.String createdDate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBrand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getQuantity() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getQuantityBackOrder() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getQuantityBackOrderString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProductImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSupplier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCost() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFet() {
        return null;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    public final double getFreight() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getItemSubtotal() {
        return null;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean getDiscontinued() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreatedDate() {
        return null;
    }
}