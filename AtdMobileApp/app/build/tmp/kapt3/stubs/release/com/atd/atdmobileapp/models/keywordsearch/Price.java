package com.atd.atdmobileapp.models.keywordsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003JN\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\'\u001a\u00020(H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r\u00a8\u0006)"}, d2 = {"Lcom/atd/atdmobileapp/models/keywordsearch/Price;", "", "cost", "", "fet", "map", "msrp", "retail", "specialdiscount", "(IILjava/lang/Integer;Ljava/lang/Integer;II)V", "getCost", "()I", "setCost", "(I)V", "getFet", "setFet", "getMap", "()Ljava/lang/Integer;", "setMap", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMsrp", "setMsrp", "getRetail", "setRetail", "getSpecialdiscount", "setSpecialdiscount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;II)Lcom/atd/atdmobileapp/models/keywordsearch/Price;", "equals", "", "other", "hashCode", "toString", "", "app_release"})
public final class Price {
    private int cost;
    private int fet;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer map;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer msrp;
    private int retail;
    private int specialdiscount;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.Price copy(int cost, int fet, @org.jetbrains.annotations.Nullable
    java.lang.Integer map, @org.jetbrains.annotations.Nullable
    java.lang.Integer msrp, int retail, int specialdiscount) {
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
    
    public Price() {
        super();
    }
    
    public Price(int cost, int fet, @org.jetbrains.annotations.Nullable
    java.lang.Integer map, @org.jetbrains.annotations.Nullable
    java.lang.Integer msrp, int retail, int specialdiscount) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getCost() {
        return 0;
    }
    
    public final void setCost(int p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getFet() {
        return 0;
    }
    
    public final void setFet(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getMap() {
        return null;
    }
    
    public final void setMap(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getMsrp() {
        return null;
    }
    
    public final void setMsrp(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getRetail() {
        return 0;
    }
    
    public final void setRetail(int p0) {
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getSpecialdiscount() {
        return 0;
    }
    
    public final void setSpecialdiscount(int p0) {
    }
}