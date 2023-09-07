package com.atd.atdmobileapp.models.preferences;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00bf\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010H\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u00c8\u0001\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\u00032\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010P\u001a\u00020QH\u00d6\u0001J\t\u0010R\u001a\u00020\u0007H\u00d6\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!\u00a8\u0006S"}, d2 = {"Lcom/atd/atdmobileapp/models/preferences/PreferencesConfiguration;", "", "showProductCost", "", "orderCutOff", "startOfBusiness", "startTime", "", "endOfBusiness", "endTime", "businessDays", "", "availabilityFilter", "myBrands", "fitmentResults", "productItems", "Lcom/atd/atdmobileapp/models/preferences/ProductItems;", "visualizerOn", "suspensionOn", "sortOrder", "sortOrderApiCode", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/preferences/ProductItems;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAvailabilityFilter", "()Ljava/lang/String;", "setAvailabilityFilter", "(Ljava/lang/String;)V", "getBusinessDays", "()Ljava/util/List;", "setBusinessDays", "(Ljava/util/List;)V", "getEndOfBusiness", "()Ljava/lang/Boolean;", "setEndOfBusiness", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndTime", "setEndTime", "getFitmentResults", "setFitmentResults", "getMyBrands", "setMyBrands", "getOrderCutOff", "setOrderCutOff", "getProductItems", "()Lcom/atd/atdmobileapp/models/preferences/ProductItems;", "setProductItems", "(Lcom/atd/atdmobileapp/models/preferences/ProductItems;)V", "getShowProductCost", "setShowProductCost", "getSortOrder", "setSortOrder", "getSortOrderApiCode", "setSortOrderApiCode", "getStartOfBusiness", "setStartOfBusiness", "getStartTime", "setStartTime", "getSuspensionOn", "setSuspensionOn", "getVisualizerOn", "setVisualizerOn", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/preferences/ProductItems;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/atd/atdmobileapp/models/preferences/PreferencesConfiguration;", "equals", "other", "hashCode", "", "toString", "app_release"})
public final class PreferencesConfiguration {
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean showProductCost;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean orderCutOff;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean startOfBusiness;
    @org.jetbrains.annotations.Nullable
    private java.lang.String startTime;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean endOfBusiness;
    @org.jetbrains.annotations.Nullable
    private java.lang.String endTime;
    @org.jetbrains.annotations.Nullable
    private java.util.List<java.lang.String> businessDays;
    @org.jetbrains.annotations.Nullable
    private java.lang.String availabilityFilter;
    @org.jetbrains.annotations.Nullable
    private java.lang.String myBrands;
    @org.jetbrains.annotations.Nullable
    private java.lang.String fitmentResults;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.models.preferences.ProductItems productItems;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean visualizerOn;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean suspensionOn;
    @org.jetbrains.annotations.Nullable
    private java.lang.String sortOrder;
    @org.jetbrains.annotations.Nullable
    private java.lang.String sortOrderApiCode;
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.preferences.PreferencesConfiguration copy(@org.jetbrains.annotations.Nullable
    java.lang.Boolean showProductCost, @org.jetbrains.annotations.Nullable
    java.lang.Boolean orderCutOff, @org.jetbrains.annotations.Nullable
    java.lang.Boolean startOfBusiness, @org.jetbrains.annotations.Nullable
    java.lang.String startTime, @org.jetbrains.annotations.Nullable
    java.lang.Boolean endOfBusiness, @org.jetbrains.annotations.Nullable
    java.lang.String endTime, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> businessDays, @org.jetbrains.annotations.Nullable
    java.lang.String availabilityFilter, @org.jetbrains.annotations.Nullable
    java.lang.String myBrands, @org.jetbrains.annotations.Nullable
    java.lang.String fitmentResults, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.preferences.ProductItems productItems, @org.jetbrains.annotations.Nullable
    java.lang.Boolean visualizerOn, @org.jetbrains.annotations.Nullable
    java.lang.Boolean suspensionOn, @org.jetbrains.annotations.Nullable
    java.lang.String sortOrder, @org.jetbrains.annotations.Nullable
    java.lang.String sortOrderApiCode) {
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
    
    public PreferencesConfiguration() {
        super();
    }
    
    public PreferencesConfiguration(@org.jetbrains.annotations.Nullable
    java.lang.Boolean showProductCost, @org.jetbrains.annotations.Nullable
    java.lang.Boolean orderCutOff, @org.jetbrains.annotations.Nullable
    java.lang.Boolean startOfBusiness, @org.jetbrains.annotations.Nullable
    java.lang.String startTime, @org.jetbrains.annotations.Nullable
    java.lang.Boolean endOfBusiness, @org.jetbrains.annotations.Nullable
    java.lang.String endTime, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> businessDays, @org.jetbrains.annotations.Nullable
    java.lang.String availabilityFilter, @org.jetbrains.annotations.Nullable
    java.lang.String myBrands, @org.jetbrains.annotations.Nullable
    java.lang.String fitmentResults, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.preferences.ProductItems productItems, @org.jetbrains.annotations.Nullable
    java.lang.Boolean visualizerOn, @org.jetbrains.annotations.Nullable
    java.lang.Boolean suspensionOn, @org.jetbrains.annotations.Nullable
    java.lang.String sortOrder, @org.jetbrains.annotations.Nullable
    java.lang.String sortOrderApiCode) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getShowProductCost() {
        return null;
    }
    
    public final void setShowProductCost(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getOrderCutOff() {
        return null;
    }
    
    public final void setOrderCutOff(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getStartOfBusiness() {
        return null;
    }
    
    public final void setStartOfBusiness(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getStartTime() {
        return null;
    }
    
    public final void setStartTime(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getEndOfBusiness() {
        return null;
    }
    
    public final void setEndOfBusiness(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getEndTime() {
        return null;
    }
    
    public final void setEndTime(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<java.lang.String> getBusinessDays() {
        return null;
    }
    
    public final void setBusinessDays(@org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAvailabilityFilter() {
        return null;
    }
    
    public final void setAvailabilityFilter(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMyBrands() {
        return null;
    }
    
    public final void setMyBrands(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFitmentResults() {
        return null;
    }
    
    public final void setFitmentResults(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.preferences.ProductItems component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.models.preferences.ProductItems getProductItems() {
        return null;
    }
    
    public final void setProductItems(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.preferences.ProductItems p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getVisualizerOn() {
        return null;
    }
    
    public final void setVisualizerOn(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getSuspensionOn() {
        return null;
    }
    
    public final void setSuspensionOn(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSortOrder() {
        return null;
    }
    
    public final void setSortOrder(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSortOrderApiCode() {
        return null;
    }
    
    public final void setSortOrderApiCode(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
}