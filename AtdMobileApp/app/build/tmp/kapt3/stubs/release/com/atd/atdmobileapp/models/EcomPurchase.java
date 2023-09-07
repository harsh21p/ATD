package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J]\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/atd/atdmobileapp/models/EcomPurchase;", "", "transaction_id", "", "currency", "shipping", "", "tax", "value", "totalItems", "totalQuantity", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)V", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getShipping", "()Ljava/lang/Number;", "setShipping", "(Ljava/lang/Number;)V", "getTax", "setTax", "getTotalItems", "setTotalItems", "getTotalQuantity", "setTotalQuantity", "getTransaction_id", "setTransaction_id", "getValue", "setValue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class EcomPurchase {
    @org.jetbrains.annotations.Nullable
    private java.lang.String transaction_id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currency;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number shipping;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number tax;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number value;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number totalItems;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number totalQuantity;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.EcomPurchase copy(@org.jetbrains.annotations.Nullable
    java.lang.String transaction_id, @org.jetbrains.annotations.Nullable
    java.lang.String currency, @org.jetbrains.annotations.Nullable
    java.lang.Number shipping, @org.jetbrains.annotations.Nullable
    java.lang.Number tax, @org.jetbrains.annotations.Nullable
    java.lang.Number value, @org.jetbrains.annotations.Nullable
    java.lang.Number totalItems, @org.jetbrains.annotations.Nullable
    java.lang.Number totalQuantity) {
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
    
    public EcomPurchase() {
        super();
    }
    
    public EcomPurchase(@org.jetbrains.annotations.Nullable
    java.lang.String transaction_id, @org.jetbrains.annotations.Nullable
    java.lang.String currency, @org.jetbrains.annotations.Nullable
    java.lang.Number shipping, @org.jetbrains.annotations.Nullable
    java.lang.Number tax, @org.jetbrains.annotations.Nullable
    java.lang.Number value, @org.jetbrains.annotations.Nullable
    java.lang.Number totalItems, @org.jetbrains.annotations.Nullable
    java.lang.Number totalQuantity) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTransaction_id() {
        return null;
    }
    
    public final void setTransaction_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getShipping() {
        return null;
    }
    
    public final void setShipping(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getTax() {
        return null;
    }
    
    public final void setTax(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getTotalItems() {
        return null;
    }
    
    public final void setTotalItems(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getTotalQuantity() {
        return null;
    }
    
    public final void setTotalQuantity(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
}