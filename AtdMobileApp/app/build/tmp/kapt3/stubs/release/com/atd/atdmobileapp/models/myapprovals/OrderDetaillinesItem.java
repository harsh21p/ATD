package com.atd.atdmobileapp.models.myapprovals;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006&"}, d2 = {"Lcom/atd/atdmobileapp/models/myapprovals/OrderDetaillinesItem;", "", "billto", "", "cartlinenumber", "", "product", "Lcom/atd/atdmobileapp/models/myapprovals/Product;", "sourcelines", "", "Lcom/atd/atdmobileapp/models/myapprovals/Sourceline;", "(Ljava/lang/String;ILcom/atd/atdmobileapp/models/myapprovals/Product;Ljava/util/List;)V", "getBillto", "()Ljava/lang/String;", "setBillto", "(Ljava/lang/String;)V", "getCartlinenumber", "()I", "setCartlinenumber", "(I)V", "getProduct", "()Lcom/atd/atdmobileapp/models/myapprovals/Product;", "setProduct", "(Lcom/atd/atdmobileapp/models/myapprovals/Product;)V", "getSourcelines", "()Ljava/util/List;", "setSourcelines", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"})
public final class OrderDetaillinesItem {
    @org.jetbrains.annotations.NotNull
    private java.lang.String billto;
    private int cartlinenumber;
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.models.myapprovals.Product product;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.atd.atdmobileapp.models.myapprovals.Sourceline> sourcelines;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myapprovals.OrderDetaillinesItem copy(@org.jetbrains.annotations.NotNull
    java.lang.String billto, int cartlinenumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myapprovals.Product product, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.Sourceline> sourcelines) {
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
    
    public OrderDetaillinesItem(@org.jetbrains.annotations.NotNull
    java.lang.String billto, int cartlinenumber, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myapprovals.Product product, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.Sourceline> sourcelines) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBillto() {
        return null;
    }
    
    public final void setBillto(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCartlinenumber() {
        return 0;
    }
    
    public final void setCartlinenumber(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myapprovals.Product component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myapprovals.Product getProduct() {
        return null;
    }
    
    public final void setProduct(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myapprovals.Product p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myapprovals.Sourceline> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myapprovals.Sourceline> getSourcelines() {
        return null;
    }
    
    public final void setSourcelines(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myapprovals.Sourceline> p0) {
    }
}