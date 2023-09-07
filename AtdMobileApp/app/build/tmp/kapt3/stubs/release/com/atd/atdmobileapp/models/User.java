package com.atd.atdmobileapp.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\tH\u00c6\u0003J\t\u0010/\u001a\u00020\tH\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\tH\u00c6\u0003J\t\u00102\u001a\u00020\u0016H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0007H\u00c6\u0003J\t\u00105\u001a\u00020\tH\u00c6\u0003J\t\u00106\u001a\u00020\tH\u00c6\u0003J\t\u00107\u001a\u00020\fH\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\tH\u00c6\u0003J\t\u0010:\u001a\u00020\u0010H\u00c6\u0003J\u0095\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u00c6\u0001J\u0013\u0010<\u001a\u00020\u00032\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020?H\u00d6\u0001J\t\u0010@\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u0006A"}, d2 = {"Lcom/atd/atdmobileapp/models/User;", "", "active", "", "configurations", "Lcom/atd/atdmobileapp/models/Configurations;", "customers", "Lcom/atd/atdmobileapp/models/Customers;", "email", "", "fax", "locations", "Lcom/atd/atdmobileapp/models/Locations;", "logindisabled", "name", "permissions", "Lcom/atd/atdmobileapp/models/Permissions;", "phone", "role", "switchstores", "username", "websites", "Lcom/atd/atdmobileapp/models/Websites;", "(ZLcom/atd/atdmobileapp/models/Configurations;Lcom/atd/atdmobileapp/models/Customers;Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/Locations;ZLjava/lang/String;Lcom/atd/atdmobileapp/models/Permissions;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/atd/atdmobileapp/models/Websites;)V", "getActive", "()Z", "getConfigurations", "()Lcom/atd/atdmobileapp/models/Configurations;", "getCustomers", "()Lcom/atd/atdmobileapp/models/Customers;", "getEmail", "()Ljava/lang/String;", "getFax", "getLocations", "()Lcom/atd/atdmobileapp/models/Locations;", "getLogindisabled", "getName", "getPermissions", "()Lcom/atd/atdmobileapp/models/Permissions;", "getPhone", "getRole", "getSwitchstores", "getUsername", "getWebsites", "()Lcom/atd/atdmobileapp/models/Websites;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class User {
    private final boolean active = false;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Configurations configurations = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Customers customers = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String fax = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Locations locations = null;
    private final boolean logindisabled = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Permissions permissions = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String phone = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String role = null;
    private final boolean switchstores = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String username = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.Websites websites = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.User copy(boolean active, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Configurations configurations, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Customers customers, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String fax, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Locations locations, boolean logindisabled, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Permissions permissions, @org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    java.lang.String role, boolean switchstores, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Websites websites) {
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
    
    public User(boolean active, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Configurations configurations, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Customers customers, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String fax, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Locations locations, boolean logindisabled, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Permissions permissions, @org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    java.lang.String role, boolean switchstores, @org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.Websites websites) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Configurations component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Configurations getConfigurations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customers component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Customers getCustomers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getFax() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Locations component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Locations getLocations() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean getLogindisabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Permissions component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Permissions getPermissions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRole() {
        return null;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean getSwitchstores() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Websites component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.Websites getWebsites() {
        return null;
    }
}