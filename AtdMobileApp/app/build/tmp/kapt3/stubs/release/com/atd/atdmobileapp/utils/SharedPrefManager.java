package com.atd.atdmobileapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0018\u001a\u00020\tJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bJ\b\u0010 \u001a\u0004\u0018\u00010\u000bJ\b\u0010!\u001a\u0004\u0018\u00010\u000bJ\b\u0010\"\u001a\u0004\u0018\u00010\u000bJ\b\u0010#\u001a\u0004\u0018\u00010\u000bJ\b\u0010$\u001a\u0004\u0018\u00010\u000bJ\b\u0010%\u001a\u0004\u0018\u00010\u000bJ\b\u0010&\u001a\u0004\u0018\u00010\u000bJ\b\u0010\'\u001a\u0004\u0018\u00010\u000bJ\b\u0010(\u001a\u0004\u0018\u00010\u000bJ\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\b\u0010*\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010+\u001a\u00020\u000fJ\b\u0010,\u001a\u0004\u0018\u00010\u000bJ\b\u0010-\u001a\u0004\u0018\u00010\u000bJ\b\u0010.\u001a\u0004\u0018\u00010\u000bJ\b\u0010/\u001a\u0004\u0018\u00010\u000bJ\b\u00100\u001a\u0004\u0018\u00010\u000bJ\u0010\u00101\u001a\u0004\u0018\u00010\u000b2\u0006\u00102\u001a\u00020\u000bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u000204J\u0006\u00107\u001a\u000204J\u0006\u00108\u001a\u000204J\u0006\u00109\u001a\u000204J\u0006\u0010:\u001a\u000204J\u0006\u0010;\u001a\u000204J\u0006\u0010<\u001a\u000204J\u0006\u0010=\u001a\u000204J\u0006\u0010>\u001a\u000204J\u0006\u0010?\u001a\u000204J\u0006\u0010@\u001a\u000204J\u0006\u0010A\u001a\u000204J\u0006\u0010B\u001a\u000204J\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u000204J\u0006\u0010E\u001a\u000204J\u0006\u0010F\u001a\u000204J\u0006\u0010G\u001a\u000204J\u0006\u0010H\u001a\u000204J\u0006\u0010I\u001a\u000204J\u0006\u0010J\u001a\u000204J\u0006\u0010K\u001a\u000204J\u0006\u0010L\u001a\u000204J\u0006\u0010M\u001a\u000204J\u000e\u0010N\u001a\u0002042\u0006\u00102\u001a\u00020\u000bJ\u000e\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020\tJ\u0010\u0010Q\u001a\u0002042\b\u0010R\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010S\u001a\u0002042\b\u0010R\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010T\u001a\u0002042\u0006\u0010U\u001a\u00020\u000bJ\u000e\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020\u000fJ\u000e\u0010X\u001a\u0002042\u0006\u0010W\u001a\u00020\u000fJ\u000e\u0010Y\u001a\u0002042\u0006\u0010W\u001a\u00020\u000fJ\u0010\u0010Z\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010[\u001a\u0002042\u0006\u0010W\u001a\u00020\u000bJ\u000e\u0010\\\u001a\u0002042\u0006\u0010W\u001a\u00020\u000bJ\u000e\u0010]\u001a\u0002042\u0006\u0010W\u001a\u00020\u000bJ\u000e\u0010^\u001a\u0002042\u0006\u0010W\u001a\u00020\u000bJ\u000e\u0010_\u001a\u0002042\u0006\u0010`\u001a\u00020\tJ\u000e\u0010a\u001a\u0002042\u0006\u0010b\u001a\u00020\u000bJ\u000e\u0010c\u001a\u0002042\u0006\u0010d\u001a\u00020\u000fJ\u0010\u0010e\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010f\u001a\u0002042\u0006\u0010g\u001a\u00020\u000bJ\u0010\u0010h\u001a\u0002042\b\u0010i\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010j\u001a\u0002042\b\u0010k\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010l\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010m\u001a\u0002042\u0006\u0010n\u001a\u00020\u000bJ\u000e\u0010o\u001a\u0002042\u0006\u0010p\u001a\u00020\u000bJ\u0010\u0010q\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010r\u001a\u0002042\b\u0010s\u001a\u0004\u0018\u00010tJ\u000e\u0010u\u001a\u0002042\u0006\u0010v\u001a\u00020\u000bJ\u000e\u0010w\u001a\u0002042\u0006\u0010v\u001a\u00020\u000bJ\u000e\u0010x\u001a\u0002042\u0006\u0010v\u001a\u00020\u000bJ\u000e\u0010y\u001a\u0002042\u0006\u0010v\u001a\u00020\u000bJ\u000e\u0010z\u001a\u0002042\u0006\u0010v\u001a\u00020\u000bJ\u000e\u0010{\u001a\u0002042\u0006\u0010v\u001a\u00020\u000bJ\u000e\u0010|\u001a\u0002042\u0006\u0010}\u001a\u00020\u000bJ\u000e\u0010~\u001a\u0002042\u0006\u0010\u007f\u001a\u00020\u000fJ\u0010\u0010\u0080\u0001\u001a\u0002042\u0007\u0010\u0081\u0001\u001a\u00020\u000bJ\u000f\u0010\u0082\u0001\u001a\u0002042\u0006\u0010b\u001a\u00020\u000bJ\u0010\u0010\u0083\u0001\u001a\u0002042\u0007\u0010\u0084\u0001\u001a\u00020\u000bJ\u0010\u0010\u0085\u0001\u001a\u0002042\u0007\u0010\u0086\u0001\u001a\u00020\u000bJ\u000f\u0010\u0087\u0001\u001a\u0002042\u0006\u0010b\u001a\u00020\u000bJ\u0018\u0010\u0088\u0001\u001a\u0002042\u0007\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u008a\u0001"}, d2 = {"Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getApprovals", "", "getApproveOrdersAtdOnline", "", "getApproveOrdersTirePros", "getBarcode", "getBiometricEnabled", "", "getCV", "()Ljava/lang/Boolean;", "getCVIntro", "getDeliveryDefault", "getLocal", "getLocalPlus", "getLocalPlusTime", "getLocalTime", "getLocationCount", "getLocationNumber", "getMultipleProfileAccess", "getNeedByDate", "getOnBoardingStatus", "getOrderApproval", "getPORegex", "getPoRequired", "getProfileSelected", "getSavedVehicleObj", "getSelectedDelivery", "getSelectedLocation", "getSelectedMake", "getSelectedModel", "getSelectedOESize", "getSelectedOESizeObj", "getSelectedTrim", "getSelectedYear", "getServicingdcNumber", "getStaggeredFitment", "getToken", "getUserName", "getUserPreferences", "getUserRequest", "getUserRole", "getWorkingQuote", "locationNumber", "removeApprovals", "", "removeApproveOrdersAtdOnline", "removeApproveOrdersTirePros", "removeBiometric", "removeDeliveryDefault", "removeLocationCount", "removeLocationNumber", "removeMultipleProfileAccess", "removeNeedByDate", "removeOnBoardingStatus", "removePORegex", "removePoRequired", "removeSavedVehicleObj", "removeSelectedDelivery", "removeSelectedLocation", "removeSelectedMake", "removeSelectedModel", "removeSelectedOESize", "removeSelectedOESizeObj", "removeSelectedTrim", "removeSelectedYear", "removeStaggeredFitment", "removeToken", "removeUserName", "removeUserRequest", "removeUserRole", "removeWorkingQuote", "saveApprovalsSize", "approvalsNumber", "saveApproveOrdersAtdOnline", "approveOrders", "saveApproveOrdersTirePros", "saveBarcode", "barcodeText", "saveBiometricEnabled", "value", "saveCV", "saveCVIntro", "saveDeliveryDefault", "saveLocal", "saveLocalPlus", "saveLocalPlusTime", "saveLocalTime", "saveLocationCount", "count", "saveLocationNumber", "name", "saveMultipleProfileAccess", "multipleProfile", "saveNeedByDate", "saveOnBoardingStatus", "isOnBoardingStatus", "saveOrderApproval", "orderApproval", "savePORegex", "poRegex", "savePoRequired", "saveProfileSelected", "profileSelected", "saveSavedVehicleObj", "vehicle", "saveSelectedDelivery", "saveSelectedLocation", "dcDetails", "Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;", "saveSelectedMake", "year", "saveSelectedModel", "saveSelectedOESize", "saveSelectedOESizeObj", "saveSelectedTrim", "saveSelectedYear", "saveServicingdcNumber", "servicingdc", "saveStaggeredFitment", "fitment", "saveToken", "token", "saveUserName", "saveUserPreferences", "userPref", "saveUserRequest", "userRequest", "saveUserRole", "saveWorkingQuote", "quote", "app_release"})
public final class SharedPrefManager {
    private android.content.SharedPreferences prefs;
    
    @javax.inject.Inject
    public SharedPrefManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    public final void saveOnBoardingStatus(@org.jetbrains.annotations.NotNull
    java.lang.String isOnBoardingStatus) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOnBoardingStatus() {
        return null;
    }
    
    public final void removeOnBoardingStatus() {
    }
    
    public final void saveLocal(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocal() {
        return null;
    }
    
    public final void saveLocalTime(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocalTime() {
        return null;
    }
    
    public final void saveLocalPlus(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocalPlus() {
        return null;
    }
    
    public final void saveLocalPlusTime(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocalPlusTime() {
        return null;
    }
    
    public final void saveToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void removeToken() {
    }
    
    public final void saveUserRequest(@org.jetbrains.annotations.NotNull
    java.lang.String userRequest) {
    }
    
    public final void removeUserRequest() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUserRequest() {
        return null;
    }
    
    public final void saveUserName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void removeUserName() {
    }
    
    public final void saveProfileSelected(@org.jetbrains.annotations.NotNull
    java.lang.String profileSelected) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getProfileSelected() {
        return null;
    }
    
    public final void saveMultipleProfileAccess(boolean multipleProfile) {
    }
    
    public final boolean getMultipleProfileAccess() {
        return false;
    }
    
    public final void removeMultipleProfileAccess() {
    }
    
    public final void saveSelectedLocation(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.homescreenlocations.DCDetails dcDetails) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedLocation() {
        return null;
    }
    
    public final void removeSelectedLocation() {
    }
    
    public final void saveApprovalsSize(int approvalsNumber) {
    }
    
    public final int getApprovals() {
        return 0;
    }
    
    public final void removeApprovals() {
    }
    
    public final void saveLocationCount(int count) {
    }
    
    public final int getLocationCount() {
        return 0;
    }
    
    public final void removeLocationCount() {
    }
    
    public final void saveLocationNumber(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocationNumber() {
        return null;
    }
    
    public final void removeLocationNumber() {
    }
    
    public final void saveBiometricEnabled(boolean value) {
    }
    
    public final boolean getBiometricEnabled() {
        return false;
    }
    
    public final void removeBiometric() {
    }
    
    public final void saveCV(boolean value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getCV() {
        return null;
    }
    
    public final void saveCVIntro(boolean value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean getCVIntro() {
        return null;
    }
    
    public final void saveServicingdcNumber(@org.jetbrains.annotations.NotNull
    java.lang.String servicingdc) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getServicingdcNumber() {
        return null;
    }
    
    public final void saveSelectedYear(@org.jetbrains.annotations.NotNull
    java.lang.String year) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedYear() {
        return null;
    }
    
    public final void removeSelectedYear() {
    }
    
    public final void saveSelectedMake(@org.jetbrains.annotations.NotNull
    java.lang.String year) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedMake() {
        return null;
    }
    
    public final void removeSelectedMake() {
    }
    
    public final void saveSelectedModel(@org.jetbrains.annotations.NotNull
    java.lang.String year) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedModel() {
        return null;
    }
    
    public final void removeSelectedModel() {
    }
    
    public final void saveSelectedTrim(@org.jetbrains.annotations.NotNull
    java.lang.String year) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedTrim() {
        return null;
    }
    
    public final void removeSelectedTrim() {
    }
    
    public final void saveSelectedOESize(@org.jetbrains.annotations.NotNull
    java.lang.String year) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedOESize() {
        return null;
    }
    
    public final void removeSelectedOESize() {
    }
    
    public final void saveSelectedOESizeObj(@org.jetbrains.annotations.NotNull
    java.lang.String year) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedOESizeObj() {
        return null;
    }
    
    public final void removeSelectedOESizeObj() {
    }
    
    public final void saveStaggeredFitment(boolean fitment) {
    }
    
    public final boolean getStaggeredFitment() {
        return false;
    }
    
    public final void removeStaggeredFitment() {
    }
    
    public final void saveSavedVehicleObj(@org.jetbrains.annotations.NotNull
    java.lang.String vehicle) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSavedVehicleObj() {
        return null;
    }
    
    public final void removeSavedVehicleObj() {
    }
    
    public final void saveUserPreferences(@org.jetbrains.annotations.NotNull
    java.lang.String userPref) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUserPreferences() {
        return null;
    }
    
    public final void saveOrderApproval(@org.jetbrains.annotations.Nullable
    java.lang.String orderApproval) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOrderApproval() {
        return null;
    }
    
    public final void saveApproveOrdersAtdOnline(@org.jetbrains.annotations.Nullable
    java.lang.String approveOrders) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getApproveOrdersAtdOnline() {
        return null;
    }
    
    public final void removeApproveOrdersAtdOnline() {
    }
    
    public final void saveApproveOrdersTirePros(@org.jetbrains.annotations.Nullable
    java.lang.String approveOrders) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getApproveOrdersTirePros() {
        return null;
    }
    
    public final void removeApproveOrdersTirePros() {
    }
    
    public final void savePORegex(@org.jetbrains.annotations.Nullable
    java.lang.String poRegex) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPORegex() {
        return null;
    }
    
    public final void removePORegex() {
    }
    
    public final void savePoRequired(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPoRequired() {
        return null;
    }
    
    public final void removePoRequired() {
    }
    
    public final void saveDeliveryDefault(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDeliveryDefault() {
        return null;
    }
    
    public final void removeDeliveryDefault() {
    }
    
    public final void saveSelectedDelivery(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedDelivery() {
        return null;
    }
    
    public final void removeSelectedDelivery() {
    }
    
    public final void saveNeedByDate(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getNeedByDate() {
        return null;
    }
    
    public final void removeNeedByDate() {
    }
    
    public final void saveBarcode(@org.jetbrains.annotations.NotNull
    java.lang.String barcodeText) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getBarcode() {
        return null;
    }
    
    public final void saveUserRole(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUserRole() {
        return null;
    }
    
    public final void removeUserRole() {
    }
    
    public final void saveWorkingQuote(@org.jetbrains.annotations.NotNull
    java.lang.String quote, @org.jetbrains.annotations.NotNull
    java.lang.String locationNumber) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getWorkingQuote(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber) {
        return null;
    }
    
    public final void removeWorkingQuote(@org.jetbrains.annotations.NotNull
    java.lang.String locationNumber) {
    }
}