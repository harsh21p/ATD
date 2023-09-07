package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003Jo\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012\u00a8\u0006+"}, d2 = {"Lcom/atd/atdmobileapp/models/Location;", "", "address", "Lcom/atd/atdmobileapp/models/Address;", "customernumber", "", "localplusdcs", "", "locationattributes", "locationlogourl", "locationname", "locationnumber", "phonenumber", "servicingdc", "(Lcom/atd/atdmobileapp/models/Address;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/atd/atdmobileapp/models/Address;", "getCustomernumber", "()Ljava/lang/String;", "getLocalplusdcs", "()Ljava/util/List;", "getLocationattributes", "getLocationlogourl", "getLocationname", "getLocationnumber", "getPhonenumber", "getServicingdc", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Location {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Address address = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String customernumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> localplusdcs = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> locationattributes = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationlogourl = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationname = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String locationnumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String phonenumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String servicingdc = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Location copy(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Address address, @org.jetbrains.annotations.NotNull
    java.lang.String customernumber, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> localplusdcs, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> locationattributes, @org.jetbrains.annotations.NotNull
    java.lang.String locationlogourl, @org.jetbrains.annotations.NotNull
    java.lang.String locationname, @org.jetbrains.annotations.NotNull
    java.lang.String locationnumber, @org.jetbrains.annotations.NotNull
    java.lang.String phonenumber, @org.jetbrains.annotations.NotNull
    java.lang.String servicingdc) {
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
    
    public Location(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Address address, @org.jetbrains.annotations.NotNull
    java.lang.String customernumber, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> localplusdcs, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> locationattributes, @org.jetbrains.annotations.NotNull
    java.lang.String locationlogourl, @org.jetbrains.annotations.NotNull
    java.lang.String locationname, @org.jetbrains.annotations.NotNull
    java.lang.String locationnumber, @org.jetbrains.annotations.NotNull
    java.lang.String phonenumber, @org.jetbrains.annotations.NotNull
    java.lang.String servicingdc) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Address component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Address getAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCustomernumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getLocalplusdcs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getLocationattributes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationlogourl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationname() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationnumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPhonenumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getServicingdc() {
        return null;
    }
}