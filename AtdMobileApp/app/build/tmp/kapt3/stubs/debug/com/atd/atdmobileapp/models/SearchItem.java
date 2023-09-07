package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0014J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010.\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u009c\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00108\u001a\u000209H\u00d6\u0001J\t\u0010:\u001a\u00020\bH\u00d6\u0001R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0004\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001d\u00a8\u0006;"}, d2 = {"Lcom/atd/atdmobileapp/models/SearchItem;", "", "product", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "isVisualizerAvailable", "", "oeProduct", "title", "", "details", "productspec", "Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;", "productgroup", "price", "Lcom/atd/atdmobileapp/models/keywordsearch/PriceX;", "imageThumbUrl", "imageProductUrl", "defaultQuantity", "", "cardElipsisState", "(Lcom/atd/atdmobileapp/models/keywordsearch/Product;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;Ljava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/PriceX;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;)V", "getCardElipsisState", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDefaultQuantity", "()Ljava/lang/Number;", "getDetails", "()Ljava/lang/Object;", "getImageProductUrl", "()Ljava/lang/String;", "getImageThumbUrl", "getOeProduct", "getPrice", "()Lcom/atd/atdmobileapp/models/keywordsearch/PriceX;", "getProduct", "()Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "getProductgroup", "getProductspec", "()Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;", "getTitle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/atd/atdmobileapp/models/keywordsearch/Product;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;Lcom/atd/atdmobileapp/models/keywordsearch/ProductspecX;Ljava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/PriceX;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Boolean;)Lcom/atd/atdmobileapp/models/SearchItem;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class SearchItem {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.keywordsearch.Product product = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Boolean isVisualizerAvailable = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Boolean oeProduct = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String title = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Object details = null;
    @org.jetbrains.annotations.Nullable
    private final com.atd.atdmobileapp.models.keywordsearch.ProductspecX productspec = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String productgroup = null;
    @org.jetbrains.annotations.Nullable
    private final com.atd.atdmobileapp.models.keywordsearch.PriceX price = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String imageThumbUrl = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String imageProductUrl = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Number defaultQuantity = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Boolean cardElipsisState = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.SearchItem copy(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.Product product, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isVisualizerAvailable, @org.jetbrains.annotations.Nullable
    java.lang.Boolean oeProduct, @org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.Object details, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.ProductspecX productspec, @org.jetbrains.annotations.Nullable
    java.lang.String productgroup, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.PriceX price, @org.jetbrains.annotations.Nullable
    java.lang.String imageThumbUrl, @org.jetbrains.annotations.Nullable
    java.lang.String imageProductUrl, @org.jetbrains.annotations.Nullable
    java.lang.Number defaultQuantity, @org.jetbrains.annotations.Nullable
    java.lang.Boolean cardElipsisState) {
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
    
    public SearchItem(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.keywordsearch.Product product, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isVisualizerAvailable, @org.jetbrains.annotations.Nullable
    java.lang.Boolean oeProduct, @org.jetbrains.annotations.Nullable
    java.lang.String title, @org.jetbrains.annotations.Nullable
    java.lang.Object details, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.ProductspecX productspec, @org.jetbrains.annotations.Nullable
    java.lang.String productgroup, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.PriceX price, @org.jetbrains.annotations.Nullable
    java.lang.String imageThumbUrl, @org.jetbrains.annotations.Nullable
    java.lang.String imageProductUrl, @org.jetbrains.annotations.Nullable
    java.lang.Number defaultQuantity, @org.jetbrains.annotations.Nullable
    java.lang.Boolean cardElipsisState) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.Product component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.Product getProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean isVisualizerAvailable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getOeProduct() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.ProductspecX component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.ProductspecX getProductspec() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProductgroup() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.PriceX component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.PriceX getPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getImageThumbUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getImageProductUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getDefaultQuantity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getCardElipsisState() {
        return null;
    }
}