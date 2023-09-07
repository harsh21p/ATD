package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001aJ\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0019H\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0085\u0002\u0010`\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00c6\u0001J\u0013\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010d\u001a\u00020eH\u00d6\u0001J\t\u0010f\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010*\"\u0004\bB\u0010,R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010*\"\u0004\bH\u0010,R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001c\"\u0004\bJ\u0010\u001e\u00a8\u0006g"}, d2 = {"Lcom/atd/atdmobileapp/models/EcomProduct;", "", "item_id", "", "item_name", "quantity", "", "affiliation", "coupon", "discount", "index", "item_brand", "item_category", "item_list_name", "item_list_id", "item_variant", "price", "currency", "promotion_id", "promotion_name", "cost", "retail", "map", "hasRebates", "availability", "Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;)V", "getAffiliation", "()Ljava/lang/String;", "setAffiliation", "(Ljava/lang/String;)V", "getAvailability", "()Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;", "setAvailability", "(Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;)V", "getCost", "setCost", "getCoupon", "setCoupon", "getCurrency", "setCurrency", "getDiscount", "()Ljava/lang/Number;", "setDiscount", "(Ljava/lang/Number;)V", "getHasRebates", "setHasRebates", "getIndex", "setIndex", "getItem_brand", "setItem_brand", "getItem_category", "setItem_category", "getItem_id", "setItem_id", "getItem_list_id", "setItem_list_id", "getItem_list_name", "setItem_list_name", "getItem_name", "setItem_name", "getItem_variant", "setItem_variant", "getMap", "setMap", "getPrice", "setPrice", "getPromotion_id", "setPromotion_id", "getPromotion_name", "setPromotion_name", "getQuantity", "setQuantity", "getRetail", "setRetail", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class EcomProduct {
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_name;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number quantity;
    @org.jetbrains.annotations.Nullable
    private java.lang.String affiliation;
    @org.jetbrains.annotations.Nullable
    private java.lang.String coupon;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number discount;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number index;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_brand;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_category;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_list_name;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_list_id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String item_variant;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number price;
    @org.jetbrains.annotations.Nullable
    private java.lang.String currency;
    @org.jetbrains.annotations.Nullable
    private java.lang.String promotion_id;
    @org.jetbrains.annotations.Nullable
    private java.lang.String promotion_name;
    @org.jetbrains.annotations.Nullable
    private java.lang.String cost;
    @org.jetbrains.annotations.Nullable
    private java.lang.String retail;
    @org.jetbrains.annotations.Nullable
    private java.lang.String map;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number hasRebates;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.EcomProduct copy(@org.jetbrains.annotations.Nullable
    java.lang.String item_id, @org.jetbrains.annotations.Nullable
    java.lang.String item_name, @org.jetbrains.annotations.Nullable
    java.lang.Number quantity, @org.jetbrains.annotations.Nullable
    java.lang.String affiliation, @org.jetbrains.annotations.Nullable
    java.lang.String coupon, @org.jetbrains.annotations.Nullable
    java.lang.Number discount, @org.jetbrains.annotations.Nullable
    java.lang.Number index, @org.jetbrains.annotations.Nullable
    java.lang.String item_brand, @org.jetbrains.annotations.Nullable
    java.lang.String item_category, @org.jetbrains.annotations.Nullable
    java.lang.String item_list_name, @org.jetbrains.annotations.Nullable
    java.lang.String item_list_id, @org.jetbrains.annotations.Nullable
    java.lang.String item_variant, @org.jetbrains.annotations.Nullable
    java.lang.Number price, @org.jetbrains.annotations.Nullable
    java.lang.String currency, @org.jetbrains.annotations.Nullable
    java.lang.String promotion_id, @org.jetbrains.annotations.Nullable
    java.lang.String promotion_name, @org.jetbrains.annotations.Nullable
    java.lang.String cost, @org.jetbrains.annotations.Nullable
    java.lang.String retail, @org.jetbrains.annotations.Nullable
    java.lang.String map, @org.jetbrains.annotations.Nullable
    java.lang.Number hasRebates, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability) {
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
    
    public EcomProduct() {
        super();
    }
    
    public EcomProduct(@org.jetbrains.annotations.Nullable
    java.lang.String item_id, @org.jetbrains.annotations.Nullable
    java.lang.String item_name, @org.jetbrains.annotations.Nullable
    java.lang.Number quantity, @org.jetbrains.annotations.Nullable
    java.lang.String affiliation, @org.jetbrains.annotations.Nullable
    java.lang.String coupon, @org.jetbrains.annotations.Nullable
    java.lang.Number discount, @org.jetbrains.annotations.Nullable
    java.lang.Number index, @org.jetbrains.annotations.Nullable
    java.lang.String item_brand, @org.jetbrains.annotations.Nullable
    java.lang.String item_category, @org.jetbrains.annotations.Nullable
    java.lang.String item_list_name, @org.jetbrains.annotations.Nullable
    java.lang.String item_list_id, @org.jetbrains.annotations.Nullable
    java.lang.String item_variant, @org.jetbrains.annotations.Nullable
    java.lang.Number price, @org.jetbrains.annotations.Nullable
    java.lang.String currency, @org.jetbrains.annotations.Nullable
    java.lang.String promotion_id, @org.jetbrains.annotations.Nullable
    java.lang.String promotion_name, @org.jetbrains.annotations.Nullable
    java.lang.String cost, @org.jetbrains.annotations.Nullable
    java.lang.String retail, @org.jetbrains.annotations.Nullable
    java.lang.String map, @org.jetbrains.annotations.Nullable
    java.lang.Number hasRebates, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability) {
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
    public final java.lang.String getAffiliation() {
        return null;
    }
    
    public final void setAffiliation(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCoupon() {
        return null;
    }
    
    public final void setCoupon(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getDiscount() {
        return null;
    }
    
    public final void setDiscount(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getIndex() {
        return null;
    }
    
    public final void setIndex(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_brand() {
        return null;
    }
    
    public final void setItem_brand(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
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
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_list_name() {
        return null;
    }
    
    public final void setItem_list_name(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getItem_list_id() {
        return null;
    }
    
    public final void setItem_list_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
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
    public final java.lang.Number component13() {
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
    public final java.lang.String component14() {
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
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPromotion_id() {
        return null;
    }
    
    public final void setPromotion_id(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPromotion_name() {
        return null;
    }
    
    public final void setPromotion_name(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCost() {
        return null;
    }
    
    public final void setCost(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRetail() {
        return null;
    }
    
    public final void setRetail(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMap() {
        return null;
    }
    
    public final void setMap(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getHasRebates() {
        return null;
    }
    
    public final void setHasRebates(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.AvailabilityX component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.AvailabilityX getAvailability() {
        return null;
    }
    
    public final void setAvailability(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.AvailabilityX p0) {
    }
}