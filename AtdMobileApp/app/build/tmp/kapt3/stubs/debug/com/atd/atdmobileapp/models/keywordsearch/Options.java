package com.atd.atdmobileapp.models.keywordsearch;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rH\u00c6\u0003JY\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u00c6\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u00020\u0007H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00065"}, d2 = {"Lcom/atd/atdmobileapp/models/keywordsearch/Options;", "", "availability", "Lcom/atd/atdmobileapp/models/keywordsearch/Availability;", "images", "Lcom/atd/atdmobileapp/models/keywordsearch/Images;", "includemarketingprograms", "", "msrp", "includerebates", "price", "Lcom/atd/atdmobileapp/models/keywordsearch/Price;", "productspec", "Lcom/atd/atdmobileapp/models/keywordsearch/Productspec;", "(Lcom/atd/atdmobileapp/models/keywordsearch/Availability;Lcom/atd/atdmobileapp/models/keywordsearch/Images;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/keywordsearch/Price;Lcom/atd/atdmobileapp/models/keywordsearch/Productspec;)V", "getAvailability", "()Lcom/atd/atdmobileapp/models/keywordsearch/Availability;", "setAvailability", "(Lcom/atd/atdmobileapp/models/keywordsearch/Availability;)V", "getImages", "()Lcom/atd/atdmobileapp/models/keywordsearch/Images;", "setImages", "(Lcom/atd/atdmobileapp/models/keywordsearch/Images;)V", "getIncludemarketingprograms", "()Ljava/lang/String;", "setIncludemarketingprograms", "(Ljava/lang/String;)V", "getIncluderebates", "setIncluderebates", "getMsrp", "setMsrp", "getPrice", "()Lcom/atd/atdmobileapp/models/keywordsearch/Price;", "setPrice", "(Lcom/atd/atdmobileapp/models/keywordsearch/Price;)V", "getProductspec", "()Lcom/atd/atdmobileapp/models/keywordsearch/Productspec;", "setProductspec", "(Lcom/atd/atdmobileapp/models/keywordsearch/Productspec;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Options {
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.keywordsearch.Availability availability;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.keywordsearch.Images images;
    @org.jetbrains.annotations.NotNull
    private java.lang.String includemarketingprograms;
    @org.jetbrains.annotations.Nullable
    private java.lang.String msrp;
    @org.jetbrains.annotations.NotNull
    private java.lang.String includerebates;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.keywordsearch.Price price;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.keywordsearch.Productspec productspec;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.keywordsearch.Options copy(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Availability availability, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Images images, @org.jetbrains.annotations.NotNull
    java.lang.String includemarketingprograms, @org.jetbrains.annotations.Nullable
    java.lang.String msrp, @org.jetbrains.annotations.NotNull
    java.lang.String includerebates, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Price price, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Productspec productspec) {
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
    
    public Options() {
        super();
    }
    
    public Options(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Availability availability, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Images images, @org.jetbrains.annotations.NotNull
    java.lang.String includemarketingprograms, @org.jetbrains.annotations.Nullable
    java.lang.String msrp, @org.jetbrains.annotations.NotNull
    java.lang.String includerebates, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Price price, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Productspec productspec) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Availability component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Availability getAvailability() {
        return null;
    }
    
    public final void setAvailability(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Availability p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Images component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Images getImages() {
        return null;
    }
    
    public final void setImages(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Images p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIncludemarketingprograms() {
        return null;
    }
    
    public final void setIncludemarketingprograms(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMsrp() {
        return null;
    }
    
    public final void setMsrp(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIncluderebates() {
        return null;
    }
    
    public final void setIncluderebates(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Price component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Price getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Price p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Productspec component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.keywordsearch.Productspec getProductspec() {
        return null;
    }
    
    public final void setProductspec(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.keywordsearch.Productspec p0) {
    }
}