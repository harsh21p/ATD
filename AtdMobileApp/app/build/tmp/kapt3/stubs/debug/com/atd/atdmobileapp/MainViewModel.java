package com.atd.atdmobileapp;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u001aJ\u0006\u00102\u001a\u00020\u001cJ\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000705J\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001e05J\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000705J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e05J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013J\u0006\u0010:\u001a\u000200J\u0006\u0010;\u001a\u000200J\u000e\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020\u001aJ\u000e\u0010>\u001a\u0002002\u0006\u0010=\u001a\u00020\u001cJ\u000e\u0010?\u001a\u0002002\u0006\u0010=\u001a\u00020\u001eJ\u000e\u0010$\u001a\u0002002\u0006\u0010=\u001a\u00020\u001eJ\u0014\u0010@\u001a\u0002002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013J\u000e\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020\rJ\u0014\u0010C\u001a\u0002002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000705J\u0014\u0010E\u001a\u0002002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e05J\u0014\u0010F\u001a\u0002002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000705J\u0014\u0010G\u001a\u0002002\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001e05J\u000e\u0010H\u001a\u0002002\u0006\u0010I\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010!R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0011R\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070+X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/atd/atdmobileapp/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_badgeCount", "Landroidx/lifecycle/MutableLiveData;", "", "_cartItemDetails", "Lcom/atd/atdmobileapp/models/CartItem;", "_preferenceChanged", "", "_selectedCalendarView", "Lcom/atd/atdmobileapp/utils/CalendarViewType;", "cartItemDetails", "Landroidx/lifecycle/LiveData;", "getCartItemDetails", "()Landroidx/lifecycle/LiveData;", "cartItems", "", "getCartItems", "()Landroidx/lifecycle/MutableLiveData;", "cartValuesToDisplay", "Lcom/atd/atdmobileapp/models/CartDisplayValue;", "getCartValuesToDisplay", "filterOptions", "Lcom/atd/atdmobileapp/models/productsearch/FilterOptions;", "filterOptionsQuotes", "Lcom/atd/atdmobileapp/models/myquotes/FilterOptionQuotes;", "frequency", "", "getFrequency", "setFrequency", "(Landroidx/lifecycle/MutableLiveData;)V", "licencePlateState", "getLicencePlateState", "setLicencePlateState", "preferenceChanged", "getPreferenceChanged", "preferredBrandList", "selectedCalendarView", "getSelectedCalendarView", "selectedItems", "", "selectedOtherItems", "selectedOtherPositions", "selectedPositions", "clearLiveDataForBrands", "", "getFilterOptions", "getFilterOptionsQuotes", "getFrequencyState", "getSelectedOtherPositions", "", "getSelectedOtherPositionsItem", "getSelectedPositions", "getSelectedPositionsItem", "getSelectedPreferredBrand", "notifyPreferenceChanged", "resetPreferenceChangedFlag", "setFilterOptions", "items", "setFilterOptionsQuotes", "setFrequencyState", "setPreferredBrand", "setSelectedCalendarView", "viewType", "setSelectedOtherPositions", "positions", "setSelectedOtherPositionsItems", "setSelectedPositions", "setSelectedPositionsItems", "updateCartItemDetails", "cartItem", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final java.util.Set<java.lang.Integer> selectedPositions = null;
    private final java.util.Set<java.lang.String> selectedItems = null;
    private final java.util.Set<java.lang.Integer> selectedOtherPositions = null;
    private final java.util.Set<java.lang.String> selectedOtherItems = null;
    private java.util.List<java.lang.String> preferredBrandList;
    private com.atd.atdmobileapp.models.productsearch.FilterOptions filterOptions;
    private com.atd.atdmobileapp.models.myquotes.FilterOptionQuotes filterOptionsQuotes;
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _badgeCount = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> licencePlateState;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.String> frequency;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.atd.atdmobileapp.models.CartItem>> cartItems = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.models.CartDisplayValue> cartValuesToDisplay = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _preferenceChanged = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.models.CartItem> _cartItemDetails = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.utils.CalendarViewType> _selectedCalendarView = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.CalendarViewType> selectedCalendarView = null;
    
    @javax.inject.Inject
    public MainViewModel(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getLicencePlateState() {
        return null;
    }
    
    public final void setLicencePlateState(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getFrequency() {
        return null;
    }
    
    public final void setFrequency(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.atd.atdmobileapp.models.CartItem>> getCartItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.models.CartDisplayValue> getCartValuesToDisplay() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getPreferenceChanged() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.models.CartItem> getCartItemDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.utils.CalendarViewType> getSelectedCalendarView() {
        return null;
    }
    
    public final void setSelectedCalendarView(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.CalendarViewType viewType) {
    }
    
    public final void updateCartItemDetails(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.CartItem cartItem) {
    }
    
    public final void notifyPreferenceChanged() {
    }
    
    public final void resetPreferenceChangedFlag() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.Integer> getSelectedPositions() {
        return null;
    }
    
    public final void setSelectedPositions(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.Integer> positions) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.String> getSelectedPositionsItem() {
        return null;
    }
    
    public final void setSelectedPositionsItems(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> items) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.Integer> getSelectedOtherPositions() {
        return null;
    }
    
    public final void setSelectedOtherPositions(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.Integer> positions) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.String> getSelectedOtherPositionsItem() {
        return null;
    }
    
    public final void setSelectedOtherPositionsItems(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> items) {
    }
    
    public final void clearLiveDataForBrands() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getSelectedPreferredBrand() {
        return null;
    }
    
    public final void setPreferredBrand(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> items) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.productsearch.FilterOptions getFilterOptions() {
        return null;
    }
    
    public final void setFilterOptions(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.productsearch.FilterOptions items) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.models.myquotes.FilterOptionQuotes getFilterOptionsQuotes() {
        return null;
    }
    
    public final void setFilterOptionsQuotes(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.myquotes.FilterOptionQuotes items) {
    }
    
    public final void setLicencePlateState(@org.jetbrains.annotations.NotNull
    java.lang.String items) {
    }
    
    public final void setFrequencyState(@org.jetbrains.annotations.NotNull
    java.lang.String items) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getFrequencyState() {
        return null;
    }
}