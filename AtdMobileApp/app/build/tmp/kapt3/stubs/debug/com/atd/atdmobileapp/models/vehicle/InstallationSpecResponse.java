package com.atd.atdmobileapp.models.vehicle;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u00a2\u0006\u0002\u0010!J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0014H\u00c6\u0003J\t\u0010C\u001a\u00020\u0016H\u00c6\u0003J\t\u0010D\u001a\u00020\u0018H\u00c6\u0003J\t\u0010E\u001a\u00020\u001aH\u00c6\u0003J\t\u0010F\u001a\u00020\u001cH\u00c6\u0003J\t\u0010G\u001a\u00020\u001eH\u00c6\u0003J\t\u0010H\u001a\u00020 H\u00c6\u0003J\t\u0010I\u001a\u00020\u0005H\u00c6\u0003J\t\u0010J\u001a\u00020\u0005H\u00c6\u0003J\t\u0010K\u001a\u00020\bH\u00c6\u0003J\t\u0010L\u001a\u00020\nH\u00c6\u0003J\t\u0010M\u001a\u00020\fH\u00c6\u0003J\t\u0010N\u001a\u00020\u000eH\u00c6\u0003J\t\u0010O\u001a\u00020\u0010H\u00c6\u0003J\t\u0010P\u001a\u00020\u0012H\u00c6\u0003J\u00a9\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u00c6\u0001J\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010U\u001a\u00020VH\u00d6\u0001J\t\u0010W\u001a\u00020XH\u00d6\u0001R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@\u00a8\u0006Y"}, d2 = {"Lcom/atd/atdmobileapp/models/vehicle/InstallationSpecResponse;", "", "psi", "Lcom/atd/atdmobileapp/models/vehicle/TirePressure;", "minrim", "Lcom/atd/atdmobileapp/models/vehicle/RimSize;", "maxrim", "torque", "Lcom/atd/atdmobileapp/models/vehicle/Torque;", "diameter", "Lcom/atd/atdmobileapp/models/vehicle/Diameter;", "speed", "Lcom/atd/atdmobileapp/models/vehicle/Speed;", "weight", "Lcom/atd/atdmobileapp/models/vehicle/Weight;", "height", "Lcom/atd/atdmobileapp/models/vehicle/Height;", "offset", "Lcom/atd/atdmobileapp/models/vehicle/Offset;", "bolts", "Lcom/atd/atdmobileapp/models/vehicle/Bolts;", "boltcircle", "Lcom/atd/atdmobileapp/models/vehicle/BoltCircle;", "boltoetiressize", "Lcom/atd/atdmobileapp/models/vehicle/BoltOEtiressize;", "vehiclehubsize", "Lcom/atd/atdmobileapp/models/vehicle/VehicleHubSize;", "oerimwidth", "Lcom/atd/atdmobileapp/models/vehicle/OERimWidth;", "oewheelsize", "Lcom/atd/atdmobileapp/models/vehicle/OEWheelSize;", "oelugsize", "Lcom/atd/atdmobileapp/models/vehicle/OELugSize;", "(Lcom/atd/atdmobileapp/models/vehicle/TirePressure;Lcom/atd/atdmobileapp/models/vehicle/RimSize;Lcom/atd/atdmobileapp/models/vehicle/RimSize;Lcom/atd/atdmobileapp/models/vehicle/Torque;Lcom/atd/atdmobileapp/models/vehicle/Diameter;Lcom/atd/atdmobileapp/models/vehicle/Speed;Lcom/atd/atdmobileapp/models/vehicle/Weight;Lcom/atd/atdmobileapp/models/vehicle/Height;Lcom/atd/atdmobileapp/models/vehicle/Offset;Lcom/atd/atdmobileapp/models/vehicle/Bolts;Lcom/atd/atdmobileapp/models/vehicle/BoltCircle;Lcom/atd/atdmobileapp/models/vehicle/BoltOEtiressize;Lcom/atd/atdmobileapp/models/vehicle/VehicleHubSize;Lcom/atd/atdmobileapp/models/vehicle/OERimWidth;Lcom/atd/atdmobileapp/models/vehicle/OEWheelSize;Lcom/atd/atdmobileapp/models/vehicle/OELugSize;)V", "getBoltcircle", "()Lcom/atd/atdmobileapp/models/vehicle/BoltCircle;", "getBoltoetiressize", "()Lcom/atd/atdmobileapp/models/vehicle/BoltOEtiressize;", "getBolts", "()Lcom/atd/atdmobileapp/models/vehicle/Bolts;", "getDiameter", "()Lcom/atd/atdmobileapp/models/vehicle/Diameter;", "getHeight", "()Lcom/atd/atdmobileapp/models/vehicle/Height;", "getMaxrim", "()Lcom/atd/atdmobileapp/models/vehicle/RimSize;", "getMinrim", "getOelugsize", "()Lcom/atd/atdmobileapp/models/vehicle/OELugSize;", "getOerimwidth", "()Lcom/atd/atdmobileapp/models/vehicle/OERimWidth;", "getOewheelsize", "()Lcom/atd/atdmobileapp/models/vehicle/OEWheelSize;", "getOffset", "()Lcom/atd/atdmobileapp/models/vehicle/Offset;", "getPsi", "()Lcom/atd/atdmobileapp/models/vehicle/TirePressure;", "getSpeed", "()Lcom/atd/atdmobileapp/models/vehicle/Speed;", "getTorque", "()Lcom/atd/atdmobileapp/models/vehicle/Torque;", "getVehiclehubsize", "()Lcom/atd/atdmobileapp/models/vehicle/VehicleHubSize;", "getWeight", "()Lcom/atd/atdmobileapp/models/vehicle/Weight;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class InstallationSpecResponse {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.TirePressure psi = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.RimSize minrim = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.RimSize maxrim = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Torque torque = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Diameter diameter = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Speed speed = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Weight weight = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Height height = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Offset offset = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.Bolts bolts = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.BoltCircle boltcircle = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.BoltOEtiressize boltoetiressize = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.VehicleHubSize vehiclehubsize = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.OERimWidth oerimwidth = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.OEWheelSize oewheelsize = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.vehicle.OELugSize oelugsize = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.InstallationSpecResponse copy(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.TirePressure psi, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.RimSize minrim, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.RimSize maxrim, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Torque torque, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Diameter diameter, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Speed speed, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Weight weight, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Height height, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Offset offset, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Bolts bolts, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.BoltCircle boltcircle, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.BoltOEtiressize boltoetiressize, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleHubSize vehiclehubsize, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.OERimWidth oerimwidth, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.OEWheelSize oewheelsize, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.OELugSize oelugsize) {
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
    
    public InstallationSpecResponse(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.TirePressure psi, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.RimSize minrim, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.RimSize maxrim, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Torque torque, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Diameter diameter, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Speed speed, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Weight weight, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Height height, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Offset offset, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.Bolts bolts, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.BoltCircle boltcircle, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.BoltOEtiressize boltoetiressize, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.VehicleHubSize vehiclehubsize, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.OERimWidth oerimwidth, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.OEWheelSize oewheelsize, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.vehicle.OELugSize oelugsize) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.TirePressure component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.TirePressure getPsi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.RimSize component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.RimSize getMinrim() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.RimSize component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.RimSize getMaxrim() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Torque component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Torque getTorque() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Diameter component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Diameter getDiameter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Speed component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Speed getSpeed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Weight component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Weight getWeight() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Height component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Height getHeight() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Offset component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Offset getOffset() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Bolts component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.Bolts getBolts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.BoltCircle component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.BoltCircle getBoltcircle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.BoltOEtiressize component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.BoltOEtiressize getBoltoetiressize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.VehicleHubSize component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.VehicleHubSize getVehiclehubsize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.OERimWidth component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.OERimWidth getOerimwidth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.OEWheelSize component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.OEWheelSize getOewheelsize() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.OELugSize component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.vehicle.OELugSize getOelugsize() {
        return null;
    }
}