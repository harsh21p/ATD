package com.atd.atdmobileapp.models.keywordsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00cb\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\"J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\tH\u00c6\u0003J\t\u0010G\u001a\u00020\u0013H\u00c6\u0003J\t\u0010H\u001a\u00020\tH\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0017H\u00c6\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eH\u00c6\u0003J\t\u0010L\u001a\u00020\tH\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\tH\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u001fH\u00c6\u0003\u00a2\u0006\u0002\u0010<J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000eH\u00c6\u0003J\t\u0010S\u001a\u00020\u0003H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\tH\u00c6\u0003J\t\u0010V\u001a\u00020\tH\u00c6\u0003J\t\u0010W\u001a\u00020\fH\u00c6\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\u00f8\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\t2\b\u0010]\u001a\u0004\u0018\u00010^H\u00d6\u0003J\t\u0010_\u001a\u00020\u001fH\u00d6\u0001J\t\u0010`\u001a\u00020\u0003H\u00d6\u0001R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0011\u0010\u0011\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0014\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0011\u0010\u001a\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010.R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010(R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0011\u0010\u001c\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010.\u00a8\u0006a"}, d2 = {"Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "Ljava/io/Serializable;", "atdproductnumber", "", "availability", "Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;", "brand", "description", "discontinued", "", "flaggedbrand", "images", "Lcom/atd/atdmobileapp/models/keywordsearch/ImagesX;", "marketingprograms", "", "Lcom/atd/atdmobileapp/models/keywordsearch/Marketingprograms;", "mfgproductnumber", "preferredbrand", "price", "Lcom/atd/atdmobileapp/models/keywordsearch/PriceX;", "privatebrand", "productgroup", "productspec", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;", "rebates", "Lcom/atd/atdmobileapp/models/keywordsearch/Rebate;", "replaced", "style", "valuebuysproduct", "type", "quantity", "", "appliedtaxes", "Lcom/atd/atdmobileapp/models/myquotes/AppliedTaxes;", "(Ljava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;Ljava/lang/String;Ljava/lang/String;ZZLcom/atd/atdmobileapp/models/keywordsearch/ImagesX;Ljava/util/List;Ljava/lang/String;ZLcom/atd/atdmobileapp/models/keywordsearch/PriceX;ZLjava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;Ljava/util/List;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getAppliedtaxes", "()Ljava/util/List;", "setAppliedtaxes", "(Ljava/util/List;)V", "getAtdproductnumber", "()Ljava/lang/String;", "getAvailability", "()Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;", "getBrand", "getDescription", "getDiscontinued", "()Z", "getFlaggedbrand", "getImages", "()Lcom/atd/atdmobileapp/models/keywordsearch/ImagesX;", "getMarketingprograms", "getMfgproductnumber", "getPreferredbrand", "getPrice", "()Lcom/atd/atdmobileapp/models/keywordsearch/PriceX;", "getPrivatebrand", "getProductgroup", "getProductspec", "()Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;", "getQuantity", "()Ljava/lang/Integer;", "setQuantity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRebates", "getReplaced", "getStyle", "getType", "getValuebuysproduct", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/AvailabilityX;Ljava/lang/String;Ljava/lang/String;ZZLcom/atd/atdmobileapp/models/keywordsearch/ImagesX;Ljava/util/List;Ljava/lang/String;ZLcom/atd/atdmobileapp/models/keywordsearch/PriceX;ZLjava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;Ljava/util/List;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class Product implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String atdproductnumber = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String brand = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    private final boolean discontinued = false;
    private final boolean flaggedbrand = false;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.keywordsearch.ImagesX images = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Marketingprograms> marketingprograms = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String mfgproductnumber = null;
    private final boolean preferredbrand = false;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.keywordsearch.PriceX price = null;
    private final boolean privatebrand = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String productgroup = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.keywordsearch.ProductspecX productspec = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Rebate> rebates = null;
    private final boolean replaced = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String style = null;
    private final boolean valuebuysproduct = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String type = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer quantity;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.myquotes.AppliedTaxes> appliedtaxes;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.Product copy(@org.jetbrains.annotations.NotNull
    java.lang.String atdproductnumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability, @org.jetbrains.annotations.NotNull
    java.lang.String brand, @org.jetbrains.annotations.NotNull
    java.lang.String description, boolean discontinued, boolean flaggedbrand, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.ImagesX images, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Marketingprograms> marketingprograms, @org.jetbrains.annotations.NotNull
    java.lang.String mfgproductnumber, boolean preferredbrand, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.PriceX price, boolean privatebrand, @org.jetbrains.annotations.NotNull
    java.lang.String productgroup, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.ProductspecX productspec, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Rebate> rebates, boolean replaced, @org.jetbrains.annotations.NotNull
    java.lang.String style, boolean valuebuysproduct, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.Integer quantity, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.myquotes.AppliedTaxes> appliedtaxes) {
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
    
    public Product(@org.jetbrains.annotations.NotNull
    java.lang.String atdproductnumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.AvailabilityX availability, @org.jetbrains.annotations.NotNull
    java.lang.String brand, @org.jetbrains.annotations.NotNull
    java.lang.String description, boolean discontinued, boolean flaggedbrand, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.ImagesX images, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Marketingprograms> marketingprograms, @org.jetbrains.annotations.NotNull
    java.lang.String mfgproductnumber, boolean preferredbrand, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.PriceX price, boolean privatebrand, @org.jetbrains.annotations.NotNull
    java.lang.String productgroup, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.ProductspecX productspec, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Rebate> rebates, boolean replaced, @org.jetbrains.annotations.NotNull
    java.lang.String style, boolean valuebuysproduct, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.Integer quantity, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.myquotes.AppliedTaxes> appliedtaxes) {
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
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.AvailabilityX component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.AvailabilityX getAvailability() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBrand() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getDiscontinued() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getFlaggedbrand() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.ImagesX component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.ImagesX getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Marketingprograms> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Marketingprograms> getMarketingprograms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMfgproductnumber() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getPreferredbrand() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.PriceX component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.PriceX getPrice() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean getPrivatebrand() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProductgroup() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.ProductspecX component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.ProductspecX getProductspec() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Rebate> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Rebate> getRebates() {
        return null;
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean getReplaced() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStyle() {
        return null;
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final boolean getValuebuysproduct() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getQuantity() {
        return null;
    }
    
    public final void setQuantity(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.AppliedTaxes> component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.AppliedTaxes> getAppliedtaxes() {
        return null;
    }
    
    public final void setAppliedtaxes(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.myquotes.AppliedTaxes> p0) {
    }
}