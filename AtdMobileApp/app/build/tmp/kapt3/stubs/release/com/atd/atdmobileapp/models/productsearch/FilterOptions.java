package com.atd.atdmobileapp.models.productsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00a5\u0002\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0014J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00a9\u0002\u0010G\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010K\u001a\u00020LH\u00d6\u0001J\t\u0010M\u001a\u00020NH\u00d6\u0001R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018\u00a8\u0006O"}, d2 = {"Lcom/atd/atdmobileapp/models/productsearch/FilterOptions;", "", "Availability", "", "Lcom/atd/atdmobileapp/models/productsearch/FilterItem;", "Size", "PreferredBrands", "Brands", "Style", "SpeedRating", "MileageWarranty", "SeasonalDesignation", "RunFlat", "MarketingPrograms", "Rebates", "WheelDiameter", "WheelWidth", "BoltPattern", "ATDFinish", "OffsetDescription", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getATDFinish", "()Ljava/util/List;", "setATDFinish", "(Ljava/util/List;)V", "getAvailability", "setAvailability", "getBoltPattern", "setBoltPattern", "getBrands", "setBrands", "getMarketingPrograms", "setMarketingPrograms", "getMileageWarranty", "setMileageWarranty", "getOffsetDescription", "setOffsetDescription", "getPreferredBrands", "setPreferredBrands", "getRebates", "setRebates", "getRunFlat", "setRunFlat", "getSeasonalDesignation", "setSeasonalDesignation", "getSize", "setSize", "getSpeedRating", "setSpeedRating", "getStyle", "setStyle", "getWheelDiameter", "setWheelDiameter", "getWheelWidth", "setWheelWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"})
public final class FilterOptions {
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Availability;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Size;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> PreferredBrands;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Brands;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Style;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> SpeedRating;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> MileageWarranty;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> SeasonalDesignation;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> RunFlat;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> MarketingPrograms;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Rebates;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> WheelDiameter;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> WheelWidth;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> BoltPattern;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> ATDFinish;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> OffsetDescription;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.productsearch.FilterOptions copy(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Availability, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Size, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> PreferredBrands, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Brands, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Style, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> SpeedRating, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> MileageWarranty, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> SeasonalDesignation, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> RunFlat, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> MarketingPrograms, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Rebates, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> WheelDiameter, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> WheelWidth, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> BoltPattern, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> ATDFinish, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> OffsetDescription) {
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
    
    public FilterOptions() {
        super();
    }
    
    public FilterOptions(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Availability, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Size, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> PreferredBrands, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Brands, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Style, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> SpeedRating, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> MileageWarranty, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> SeasonalDesignation, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> RunFlat, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> MarketingPrograms, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> Rebates, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> WheelDiameter, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> WheelWidth, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> BoltPattern, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> ATDFinish, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> OffsetDescription) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getAvailability() {
        return null;
    }
    
    public final void setAvailability(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getSize() {
        return null;
    }
    
    public final void setSize(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getPreferredBrands() {
        return null;
    }
    
    public final void setPreferredBrands(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getBrands() {
        return null;
    }
    
    public final void setBrands(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getStyle() {
        return null;
    }
    
    public final void setStyle(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getSpeedRating() {
        return null;
    }
    
    public final void setSpeedRating(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getMileageWarranty() {
        return null;
    }
    
    public final void setMileageWarranty(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getSeasonalDesignation() {
        return null;
    }
    
    public final void setSeasonalDesignation(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getRunFlat() {
        return null;
    }
    
    public final void setRunFlat(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getMarketingPrograms() {
        return null;
    }
    
    public final void setMarketingPrograms(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getRebates() {
        return null;
    }
    
    public final void setRebates(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getWheelDiameter() {
        return null;
    }
    
    public final void setWheelDiameter(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getWheelWidth() {
        return null;
    }
    
    public final void setWheelWidth(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getBoltPattern() {
        return null;
    }
    
    public final void setBoltPattern(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getATDFinish() {
        return null;
    }
    
    public final void setATDFinish(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> getOffsetDescription() {
        return null;
    }
    
    public final void setOffsetDescription(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.productsearch.FilterItem> p0) {
    }
}