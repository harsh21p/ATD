package com.atd.atdmobileapp.models.productsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\bD\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00a5\u0002\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0014J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00a9\u0002\u0010G\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010K\u001a\u00020LH\u00d6\u0001J\t\u0010M\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018\u00a8\u0006N"}, d2 = {"Lcom/atd/atdmobileapp/models/productsearch/Criteria;", "", "productgroup", "", "", "size", "brand", "winterdesignation", "speedrating", "mfgproductnumber", "atdproductnumber", "atdfinish", "boltpattern", "wheeldiameter", "wheelwidth", "productsubgroup", "categories", "suspensionsize", "style", "upc", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAtdfinish", "()Ljava/util/List;", "setAtdfinish", "(Ljava/util/List;)V", "getAtdproductnumber", "setAtdproductnumber", "getBoltpattern", "setBoltpattern", "getBrand", "setBrand", "getCategories", "setCategories", "getMfgproductnumber", "setMfgproductnumber", "getProductgroup", "setProductgroup", "getProductsubgroup", "setProductsubgroup", "getSize", "setSize", "getSpeedrating", "setSpeedrating", "getStyle", "setStyle", "getSuspensionsize", "setSuspensionsize", "getUpc", "setUpc", "getWheeldiameter", "setWheeldiameter", "getWheelwidth", "setWheelwidth", "getWinterdesignation", "setWinterdesignation", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Criteria {
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> productgroup;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> size;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> brand;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> winterdesignation;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> speedrating;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> mfgproductnumber;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> atdproductnumber;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> atdfinish;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> boltpattern;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> wheeldiameter;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> wheelwidth;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> productsubgroup;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> categories;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> suspensionsize;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> style;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> upc;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.productsearch.Criteria copy(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> productgroup, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> size, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> brand, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> winterdesignation, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> speedrating, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> mfgproductnumber, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> atdproductnumber, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> atdfinish, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> boltpattern, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> wheeldiameter, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> wheelwidth, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> productsubgroup, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> suspensionsize, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> style, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> upc) {
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
    
    public Criteria() {
        super();
    }
    
    public Criteria(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> productgroup, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> size, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> brand, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> winterdesignation, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> speedrating, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> mfgproductnumber, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> atdproductnumber, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> atdfinish, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> boltpattern, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> wheeldiameter, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> wheelwidth, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> productsubgroup, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> suspensionsize, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> style, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> upc) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getProductgroup() {
        return null;
    }
    
    public final void setProductgroup(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getSize() {
        return null;
    }
    
    public final void setSize(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getBrand() {
        return null;
    }
    
    public final void setBrand(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getWinterdesignation() {
        return null;
    }
    
    public final void setWinterdesignation(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getSpeedrating() {
        return null;
    }
    
    public final void setSpeedrating(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getMfgproductnumber() {
        return null;
    }
    
    public final void setMfgproductnumber(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getAtdproductnumber() {
        return null;
    }
    
    public final void setAtdproductnumber(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getAtdfinish() {
        return null;
    }
    
    public final void setAtdfinish(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getBoltpattern() {
        return null;
    }
    
    public final void setBoltpattern(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getWheeldiameter() {
        return null;
    }
    
    public final void setWheeldiameter(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getWheelwidth() {
        return null;
    }
    
    public final void setWheelwidth(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getProductsubgroup() {
        return null;
    }
    
    public final void setProductsubgroup(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getCategories() {
        return null;
    }
    
    public final void setCategories(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getSuspensionsize() {
        return null;
    }
    
    public final void setSuspensionsize(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getStyle() {
        return null;
    }
    
    public final void setStyle(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getUpc() {
        return null;
    }
    
    public final void setUpc(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
}