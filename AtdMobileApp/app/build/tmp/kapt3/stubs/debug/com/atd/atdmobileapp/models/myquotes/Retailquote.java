package com.atd.atdmobileapp.models.myquotes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0015J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u00c6\u0003J\t\u00102\u001a\u00020\u000eH\u00c6\u0003J\t\u00103\u001a\u00020\u0010H\u00c6\u0003J\t\u00104\u001a\u00020\u0012H\u00c6\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007H\u00c6\u0003J}\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007H\u00c6\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020;H\u00d6\u0001J\t\u0010<\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001d\"\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006="}, d2 = {"Lcom/atd/atdmobileapp/models/myquotes/Retailquote;", "", "companyinfo", "Lcom/atd/atdmobileapp/models/myquotes/Companyinfo;", "consumerinfo", "Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;", "items", "", "Lcom/atd/atdmobileapp/models/myquotes/Item;", "quoteaddons", "Lcom/atd/atdmobileapp/models/myquotes/Quoteaddon;", "quotecomments", "Lcom/atd/atdmobileapp/models/myquotes/QuoteComment;", "quoteinfo", "Lcom/atd/atdmobileapp/models/myquotes/Quoteinfo;", "quotesummary", "Lcom/atd/atdmobileapp/models/myquotes/Quotesummary;", "retailquoteid", "", "products", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "(Lcom/atd/atdmobileapp/models/myquotes/Companyinfo;Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/atd/atdmobileapp/models/myquotes/Quoteinfo;Lcom/atd/atdmobileapp/models/myquotes/Quotesummary;Ljava/lang/String;Ljava/util/List;)V", "getCompanyinfo", "()Lcom/atd/atdmobileapp/models/myquotes/Companyinfo;", "getConsumerinfo", "()Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;", "setConsumerinfo", "(Lcom/atd/atdmobileapp/models/myquotes/Consumerinfo;)V", "getItems", "()Ljava/util/List;", "getProducts", "setProducts", "(Ljava/util/List;)V", "getQuoteaddons", "getQuotecomments", "getQuoteinfo", "()Lcom/atd/atdmobileapp/models/myquotes/Quoteinfo;", "setQuoteinfo", "(Lcom/atd/atdmobileapp/models/myquotes/Quoteinfo;)V", "getQuotesummary", "()Lcom/atd/atdmobileapp/models/myquotes/Quotesummary;", "getRetailquoteid", "()Ljava/lang/String;", "setRetailquoteid", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Retailquote {
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.myquotes.Companyinfo companyinfo = null;
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.models.myquotes.Consumerinfo consumerinfo;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.myquotes.Item> items = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.myquotes.Quoteaddon> quoteaddons = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.atd.atdmobileapp.models.myquotes.QuoteComment> quotecomments = null;
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.models.myquotes.Quoteinfo quoteinfo;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.models.myquotes.Quotesummary quotesummary = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String retailquoteid;
    @org.jetbrains.annotations.Nullable
    private java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> products;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Retailquote copy(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Companyinfo companyinfo, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Consumerinfo consumerinfo, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.Item> items, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.Quoteaddon> quoteaddons, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.QuoteComment> quotecomments, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Quoteinfo quoteinfo, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Quotesummary quotesummary, @org.jetbrains.annotations.NotNull
    java.lang.String retailquoteid, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> products) {
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
    
    public Retailquote(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Companyinfo companyinfo, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Consumerinfo consumerinfo, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.Item> items, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.Quoteaddon> quoteaddons, @org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.myquotes.QuoteComment> quotecomments, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Quoteinfo quoteinfo, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Quotesummary quotesummary, @org.jetbrains.annotations.NotNull
    java.lang.String retailquoteid, @org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> products) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Companyinfo component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Companyinfo getCompanyinfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Consumerinfo component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Consumerinfo getConsumerinfo() {
        return null;
    }
    
    public final void setConsumerinfo(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Consumerinfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.Item> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.Item> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.Quoteaddon> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.Quoteaddon> getQuoteaddons() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.QuoteComment> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.atd.atdmobileapp.models.myquotes.QuoteComment> getQuotecomments() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Quoteinfo component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Quoteinfo getQuoteinfo() {
        return null;
    }
    
    public final void setQuoteinfo(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.Quoteinfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Quotesummary component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.Quotesummary getQuotesummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRetailquoteid() {
        return null;
    }
    
    public final void setRetailquoteid(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> getProducts() {
        return null;
    }
    
    public final void setProducts(@org.jetbrains.annotations.Nullable
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> p0) {
    }
}