package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\rH\u00c6\u0003J\t\u00101\u001a\u00020\rH\u00c6\u0003J\u008b\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u000206H\u00d6\u0001J\t\u00107\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015\u00a8\u00068"}, d2 = {"Lcom/atd/atdmobileapp/models/Customer;", "", "accessshiptohome", "", "customerclass", "Lcom/atd/atdmobileapp/models/Customerclass;", "customergroup", "Lcom/atd/atdmobileapp/models/Customergroup;", "deliverynotification", "enableautoreplenishment", "enablecustomerinventory", "isactive", "isdeliveryby", "", "isdeliveryon", "name", "number", "shipmentnotification", "type", "(Ljava/lang/String;Lcom/atd/atdmobileapp/models/Customerclass;Lcom/atd/atdmobileapp/models/Customergroup;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessshiptohome", "()Ljava/lang/String;", "getCustomerclass", "()Lcom/atd/atdmobileapp/models/Customerclass;", "getCustomergroup", "()Lcom/atd/atdmobileapp/models/Customergroup;", "getDeliverynotification", "getEnableautoreplenishment", "getEnablecustomerinventory", "getIsactive", "getIsdeliveryby", "()Z", "getIsdeliveryon", "getName", "getNumber", "getShipmentnotification", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class Customer {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String accessshiptohome = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Customerclass customerclass = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Customergroup customergroup = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String deliverynotification = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String enableautoreplenishment = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String enablecustomerinventory = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String isactive = null;
    private final boolean isdeliveryby = false;
    private final boolean isdeliveryon = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String number = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String shipmentnotification = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String type = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customer copy(@org.jetbrains.annotations.NotNull
    java.lang.String accessshiptohome, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Customerclass customerclass, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Customergroup customergroup, @org.jetbrains.annotations.NotNull
    java.lang.String deliverynotification, @org.jetbrains.annotations.NotNull
    java.lang.String enableautoreplenishment, @org.jetbrains.annotations.NotNull
    java.lang.String enablecustomerinventory, @org.jetbrains.annotations.NotNull
    java.lang.String isactive, boolean isdeliveryby, boolean isdeliveryon, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String number, @org.jetbrains.annotations.NotNull
    java.lang.String shipmentnotification, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
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
    
    public Customer(@org.jetbrains.annotations.NotNull
    java.lang.String accessshiptohome, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Customerclass customerclass, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Customergroup customergroup, @org.jetbrains.annotations.NotNull
    java.lang.String deliverynotification, @org.jetbrains.annotations.NotNull
    java.lang.String enableautoreplenishment, @org.jetbrains.annotations.NotNull
    java.lang.String enablecustomerinventory, @org.jetbrains.annotations.NotNull
    java.lang.String isactive, boolean isdeliveryby, boolean isdeliveryon, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String number, @org.jetbrains.annotations.NotNull
    java.lang.String shipmentnotification, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAccessshiptohome() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customerclass component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customerclass getCustomerclass() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customergroup component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customergroup getCustomergroup() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDeliverynotification() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEnableautoreplenishment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEnablecustomerinventory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIsactive() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getIsdeliveryby() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getIsdeliveryon() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShipmentnotification() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getType() {
        return null;
    }
}