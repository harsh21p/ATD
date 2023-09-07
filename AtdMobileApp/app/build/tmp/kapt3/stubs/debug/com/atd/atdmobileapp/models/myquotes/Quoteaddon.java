package com.atd.atdmobileapp.models.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\u0011H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\nH\u00c6\u0003J\t\u0010.\u001a\u00020\nH\u00c6\u0003J\u008d\u0001\u0010/\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u000204H\u00d6\u0001J\t\u00105\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u00066"}, d2 = {"Lcom/atd/atdmobileapp/models/myquotes/Quoteaddon;", "", "appliedtaxes", "", "applyper", "", "childaddons", "description", "entrynumber", "linetotal", "", "name", "quantity", "taxamount", "type", "unitprice", "vehicleinfo", "Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;)V", "getAppliedtaxes", "()Ljava/util/List;", "getApplyper", "()Ljava/lang/String;", "getChildaddons", "getDescription", "getEntrynumber", "getLinetotal", "()Ljava/lang/Number;", "getName", "getQuantity", "getTaxamount", "getType", "getUnitprice", "getVehicleinfo", "()Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Quoteaddon {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> appliedtaxes = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String applyper = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Object> childaddons = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String entrynumber = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Number linetotal = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Number quantity = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Number taxamount = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String type = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.Number unitprice = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.myquotes.VehicleinfoX vehicleinfo = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Quoteaddon copy(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> appliedtaxes, @org.jetbrains.annotations.NotNull
    java.lang.String applyper, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> childaddons, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String entrynumber, @org.jetbrains.annotations.NotNull
    java.lang.Number linetotal, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.Number quantity, @org.jetbrains.annotations.NotNull
    java.lang.Number taxamount, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.Number unitprice, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.VehicleinfoX vehicleinfo) {
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
    
    public Quoteaddon(@org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> appliedtaxes, @org.jetbrains.annotations.NotNull
    java.lang.String applyper, @org.jetbrains.annotations.NotNull
    java.util.List<? extends java.lang.Object> childaddons, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String entrynumber, @org.jetbrains.annotations.NotNull
    java.lang.Number linetotal, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.Number quantity, @org.jetbrains.annotations.NotNull
    java.lang.Number taxamount, @org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.Number unitprice, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.VehicleinfoX vehicleinfo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getAppliedtaxes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getApplyper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Object> getChildaddons() {
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
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEntrynumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number getLinetotal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number getQuantity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number getTaxamount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Number getUnitprice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.VehicleinfoX component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.VehicleinfoX getVehicleinfo() {
        return null;
    }
}