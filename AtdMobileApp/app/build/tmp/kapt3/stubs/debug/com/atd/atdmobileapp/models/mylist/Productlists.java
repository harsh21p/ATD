package com.atd.atdmobileapp.models.mylist;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001d\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u00c6\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u0010\u00102\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u008c\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010;H\u00d6\u0003J\t\u0010<\u001a\u00020\fH\u00d6\u0001J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b\'\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015\u00a8\u0006>"}, d2 = {"Lcom/atd/atdmobileapp/models/mylist/Productlists;", "Ljava/io/Serializable;", "name", "", "nextoccurencedate", "products", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/mylist/Product;", "Lkotlin/collections/ArrayList;", "recurring", "", "recurringfrequency", "", "recurringfrequencytype", "recurringstartdate", "sharelist", "uid", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getNextoccurencedate", "setNextoccurencedate", "getProducts", "()Ljava/util/ArrayList;", "setProducts", "(Ljava/util/ArrayList;)V", "getRecurring", "()Ljava/lang/Boolean;", "setRecurring", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRecurringfrequency", "()Ljava/lang/Integer;", "setRecurringfrequency", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRecurringfrequencytype", "setRecurringfrequencytype", "getRecurringstartdate", "setRecurringstartdate", "getSharelist", "setSharelist", "getUid", "setUid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/atd/atdmobileapp/models/mylist/Productlists;", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class Productlists implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable
    private java.lang.String nextoccurencedate;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.atd.atdmobileapp.models.mylist.Product> products;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean recurring;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer recurringfrequency;
    @org.jetbrains.annotations.Nullable
    private java.lang.String recurringfrequencytype;
    @org.jetbrains.annotations.Nullable
    private java.lang.String recurringstartdate;
    @org.jetbrains.annotations.Nullable
    private java.lang.String sharelist;
    @org.jetbrains.annotations.Nullable
    private java.lang.String uid;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.mylist.Productlists copy(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String nextoccurencedate, @org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.atd.atdmobileapp.models.mylist.Product> products, @org.jetbrains.annotations.Nullable
    java.lang.Boolean recurring, @org.jetbrains.annotations.Nullable
    java.lang.Integer recurringfrequency, @org.jetbrains.annotations.Nullable
    java.lang.String recurringfrequencytype, @org.jetbrains.annotations.Nullable
    java.lang.String recurringstartdate, @org.jetbrains.annotations.Nullable
    java.lang.String sharelist, @org.jetbrains.annotations.Nullable
    java.lang.String uid) {
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
    
    public Productlists() {
        super();
    }
    
    public Productlists(@org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String nextoccurencedate, @org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.atd.atdmobileapp.models.mylist.Product> products, @org.jetbrains.annotations.Nullable
    java.lang.Boolean recurring, @org.jetbrains.annotations.Nullable
    java.lang.Integer recurringfrequency, @org.jetbrains.annotations.Nullable
    java.lang.String recurringfrequencytype, @org.jetbrains.annotations.Nullable
    java.lang.String recurringstartdate, @org.jetbrains.annotations.Nullable
    java.lang.String sharelist, @org.jetbrains.annotations.Nullable
    java.lang.String uid) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component1() {
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
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNextoccurencedate() {
        return null;
    }
    
    public final void setNextoccurencedate(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.atd.atdmobileapp.models.mylist.Product> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.atd.atdmobileapp.models.mylist.Product> getProducts() {
        return null;
    }
    
    public final void setProducts(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.atd.atdmobileapp.models.mylist.Product> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getRecurring() {
        return null;
    }
    
    public final void setRecurring(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getRecurringfrequency() {
        return null;
    }
    
    public final void setRecurringfrequency(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRecurringfrequencytype() {
        return null;
    }
    
    public final void setRecurringfrequencytype(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getRecurringstartdate() {
        return null;
    }
    
    public final void setRecurringstartdate(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSharelist() {
        return null;
    }
    
    public final void setSharelist(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUid() {
        return null;
    }
    
    public final void setUid(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}