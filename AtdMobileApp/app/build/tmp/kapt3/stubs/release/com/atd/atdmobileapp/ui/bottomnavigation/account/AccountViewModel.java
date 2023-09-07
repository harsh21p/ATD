package com.atd.atdmobileapp.ui.bottomnavigation.account;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountViewModel;", "Landroidx/lifecycle/ViewModel;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "_dcDetails", "Landroidx/lifecycle/MutableLiveData;", "Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;", "_locationDetails", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountViewModel$LocationDetails;", "_username", "", "dcDetails", "Landroidx/lifecycle/LiveData;", "getDcDetails", "()Landroidx/lifecycle/LiveData;", "locationDetails", "getLocationDetails", "username", "getUsername", "getDcDeatils", "LocationDetails", "app_release"})
public final class AccountViewModel extends androidx.lifecycle.ViewModel {
    private final com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _username = null;
    private final androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.ui.bottomnavigation.account.AccountViewModel.LocationDetails> _locationDetails = null;
    private androidx.lifecycle.MutableLiveData<com.atd.atdmobileapp.models.homescreenlocations.DCDetails> _dcDetails;
    
    @javax.inject.Inject
    public AccountViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.ui.bottomnavigation.account.AccountViewModel.LocationDetails> getLocationDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.atd.atdmobileapp.models.homescreenlocations.DCDetails> getDcDetails() {
        return null;
    }
    
    private final java.lang.String getUsername() {
        return null;
    }
    
    private final com.atd.atdmobileapp.models.homescreenlocations.DCDetails getDcDeatils() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.bottomnavigation.account.AccountViewModel.LocationDetails getLocationDetails() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountViewModel$LocationDetails;", "", "location", "", "dc", "dcDetails", "Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;", "(Ljava/lang/String;Ljava/lang/String;Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;)V", "getDc", "()Ljava/lang/String;", "getDcDetails", "()Lcom/atd/atdmobileapp/models/homescreenlocations/DCDetails;", "getLocation", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
    public static final class LocationDetails {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String location = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String dc = null;
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.models.homescreenlocations.DCDetails dcDetails = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.ui.bottomnavigation.account.AccountViewModel.LocationDetails copy(@org.jetbrains.annotations.NotNull
        java.lang.String location, @org.jetbrains.annotations.NotNull
        java.lang.String dc, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.homescreenlocations.DCDetails dcDetails) {
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
        
        public LocationDetails(@org.jetbrains.annotations.NotNull
        java.lang.String location, @org.jetbrains.annotations.NotNull
        java.lang.String dc, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.homescreenlocations.DCDetails dcDetails) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getLocation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDc() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.models.homescreenlocations.DCDetails component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.models.homescreenlocations.DCDetails getDcDetails() {
            return null;
        }
    }
}