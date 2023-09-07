package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\bD\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00c3\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u00c7\u0001\u0010I\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010M\u001a\u00020NH\u00d6\u0001J\t\u0010O\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001c\u00a8\u0006P"}, d2 = {"Lcom/atd/atdmobileapp/models/EcomPurchaseItem;", "", "item_id", "", "item_name", "quantity", "", "item_brand", "currency", "item_category", "item_variant", "tax", "price", "lineItemNum", "sku", "total", "status", "freight", "shippingMethod", "shippingDC", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;)V", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getFreight", "()Ljava/lang/Number;", "setFreight", "(Ljava/lang/Number;)V", "getItem_brand", "setItem_brand", "getItem_category", "setItem_category", "getItem_id", "setItem_id", "getItem_name", "setItem_name", "getItem_variant", "setItem_variant", "getLineItemNum", "setLineItemNum", "getPrice", "setPrice", "getQuantity", "setQuantity", "getShippingDC", "setShippingDC", "getShippingMethod", "setShippingMethod", "getSku", "setSku", "getStatus", "setStatus", "getTax", "setTax", "getTotal", "setTotal", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class EcomPurchaseItem {
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_name;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number quantity;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_brand;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currency;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_category;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_variant;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number tax;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number price;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number lineItemNum;
    @org.jetbrains.annotations.Nullable
    private java.lang.String sku;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number total;
    @org.jetbrains.annotations.Nullable
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number freight;
    @org.jetbrains.annotations.Nullable
    private java.lang.String shippingMethod;
    @org.jetbrains.annotations.Nullable
    private java.lang.String shippingDC;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.EcomPurchaseItem copy(@org.jetbrains.annotations.Nullable
    java.lang.String item_id, @org.jetbrains.annotations.Nullable
    java.lang.String item_name, @org.jetbrains.annotations.Nullable
    java.lang.Number quantity, @org.jetbrains.annotations.Nullable
    java.lang.String item_brand, @org.jetbrains.annotations.NotNull
    java.lang.String currency, @org.jetbrains.annotations.Nullable
    java.lang.String item_category, @org.jetbrains.annotations.Nullable
    java.lang.String item_variant, @org.jetbrains.annotations.Nullable
    java.lang.Number tax, @org.jetbrains.annotations.Nullable
    java.lang.Number price, @org.jetbrains.annotations.Nullable
    java.lang.Number lineItemNum, @org.jetbrains.annotations.Nullable
    java.lang.String sku, @org.jetbrains.annotations.Nullable
    java.lang.Number total, @org.jetbrains.annotations.Nullable
    java.lang.String status, @org.jetbrains.annotations.Nullable
    java.lang.Number freight, @org.jetbrains.annotations.Nullable
    java.lang.String shippingMethod, @org.jetbrains.annotations.Nullable
    java.lang.String shippingDC) {
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
    
    public EcomPurchaseItem() {
        super();
    }
    
    public EcomPurchaseItem(@org.jetbrains.annotations.Nullable
    java.lang.String item_id, @org.jetbrains.annotations.Nullable
    java.lang.String item_name, @org.jetbrains.annotations.Nullable
    java.lang.Number quantity, @org.jetbrains.annotations.Nullable
    java.lang.String item_brand, @org.jetbrains.annotations.NotNull
    java.lang.String currency, @org.jetbrains.annotations.Nullable
    java.lang.String item_category, @org.jetbrains.annotations.Nullable
    java.lang.String item_variant, @org.jetbrains.annotations.Nullable
    java.lang.Number tax, @org.jetbrains.annotations.Nullable
    java.lang.Number price, @org.jetbrains.annotations.Nullable
    java.lang.Number lineItemNum, @org.jetbrains.annotations.Nullable
    java.lang.String sku, @org.jetbrains.annotations.Nullable
    java.lang.Number total, @org.jetbrains.annotations.Nullable
    java.lang.String status, @org.jetbrains.annotations.Nullable
    java.lang.Number freight, @org.jetbrains.annotations.Nullable
    java.lang.String shippingMethod, @org.jetbrains.annotations.Nullable
    java.lang.String shippingDC) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_id() {
        return null;
    }
    
    public final void setItem_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_name() {
        return null;
    }
    
    public final void setItem_name(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getQuantity() {
        return null;
    }
    
    public final void setQuantity(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_brand() {
        return null;
    }
    
    public final void setItem_brand(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_category() {
        return null;
    }
    
    public final void setItem_category(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_variant() {
        return null;
    }
    
    public final void setItem_variant(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component8() {
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
    public final java.lang.Number component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getLineItemNum() {
        return null;
    }
    
    public final void setLineItemNum(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSku() {
        return null;
    }
    
    public final void setSku(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getTotal() {
        return null;
    }
    
    public final void setTotal(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getFreight() {
        return null;
    }
    
    public final void setFreight(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getShippingMethod() {
        return null;
    }
    
    public final void setShippingMethod(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getShippingDC() {
        return null;
    }
    
    public final void setShippingDC(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}