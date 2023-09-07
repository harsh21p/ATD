package com.atd.atdmobileapp.models.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u008d\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00c6\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020?H\u00d6\u0001J\t\u0010@\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006A"}, d2 = {"Lcom/atd/atdmobileapp/models/myquotes/SubTotalAddOns;", "", "entrynumber", "", "name", "", "description", "quantity", "unitprice", "linetotal", "type", "applyper", "taxamount", "vehicleinfo", "Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;", "appliedtaxes", "(Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;Ljava/lang/Object;)V", "getAppliedtaxes", "()Ljava/lang/Object;", "setAppliedtaxes", "(Ljava/lang/Object;)V", "getApplyper", "()Ljava/lang/String;", "setApplyper", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getEntrynumber", "()Ljava/lang/Number;", "setEntrynumber", "(Ljava/lang/Number;)V", "getLinetotal", "setLinetotal", "getName", "setName", "getQuantity", "setQuantity", "getTaxamount", "setTaxamount", "getType", "setType", "getUnitprice", "setUnitprice", "getVehicleinfo", "()Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;", "setVehicleinfo", "(Lcom/atd/atdmobileapp/models/myquotes/VehicleinfoX;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
public final class SubTotalAddOns {
    @org.jetbrains.annotations.Nullable
    private java.lang.Number entrynumber;
    @org.jetbrains.annotations.Nullable
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number quantity;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number unitprice;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number linetotal;
    @org.jetbrains.annotations.Nullable
    private java.lang.String type;
    @org.jetbrains.annotations.Nullable
    private java.lang.String applyper;
    @org.jetbrains.annotations.Nullable
    private java.lang.Number taxamount;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.myquotes.VehicleinfoX vehicleinfo;
    @org.jetbrains.annotations.Nullable
    private java.lang.Object appliedtaxes;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.SubTotalAddOns copy(@org.jetbrains.annotations.Nullable
    java.lang.Number entrynumber, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.Number quantity, @org.jetbrains.annotations.Nullable
    java.lang.Number unitprice, @org.jetbrains.annotations.Nullable
    java.lang.Number linetotal, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String applyper, @org.jetbrains.annotations.Nullable
    java.lang.Number taxamount, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.myquotes.VehicleinfoX vehicleinfo, @org.jetbrains.annotations.Nullable
    java.lang.Object appliedtaxes) {
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
    
    public SubTotalAddOns() {
        super();
    }
    
    public SubTotalAddOns(@org.jetbrains.annotations.Nullable
    java.lang.Number entrynumber, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String description, @org.jetbrains.annotations.Nullable
    java.lang.Number quantity, @org.jetbrains.annotations.Nullable
    java.lang.Number unitprice, @org.jetbrains.annotations.Nullable
    java.lang.Number linetotal, @org.jetbrains.annotations.Nullable
    java.lang.String type, @org.jetbrains.annotations.Nullable
    java.lang.String applyper, @org.jetbrains.annotations.Nullable
    java.lang.Number taxamount, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.myquotes.VehicleinfoX vehicleinfo, @org.jetbrains.annotations.Nullable
    java.lang.Object appliedtaxes) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getEntrynumber() {
        return null;
    }
    
    public final void setEntrynumber(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component4() {
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
    public final java.lang.Number component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getUnitprice() {
        return null;
    }
    
    public final void setUnitprice(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getLinetotal() {
        return null;
    }
    
    public final void setLinetotal(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getApplyper() {
        return null;
    }
    
    public final void setApplyper(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Number getTaxamount() {
        return null;
    }
    
    public final void setTaxamount(@org.jetbrains.annotations.Nullable
    java.lang.Number p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.myquotes.VehicleinfoX component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.myquotes.VehicleinfoX getVehicleinfo() {
        return null;
    }
    
    public final void setVehicleinfo(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.myquotes.VehicleinfoX p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAppliedtaxes() {
        return null;
    }
    
    public final void setAppliedtaxes(@org.jetbrains.annotations.Nullable
    java.lang.Object p0) {
    }
}