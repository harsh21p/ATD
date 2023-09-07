package com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [HomeTabFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\u0012\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u000101H\u0016J$\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00108\u001a\u00020-2\u0006\u00109\u001a\u0002032\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010:\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020-H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006<"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/hometabscreen/HomeTabFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentSubHomeBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentSubHomeBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentSubHomeBinding;)V", "binding", "getBinding", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "homeViewModel", "Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/HomeViewModel;", "getHomeViewModel", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/homescreen/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "mainViewModel", "Lcom/atd/atdmobileapp/MainViewModel;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "getTabLayout", "()Lcom/google/android/material/tabs/TabLayout;", "setTabLayout", "(Lcom/google/android/material/tabs/TabLayout;)V", "tiresBrandsViewModel", "Lcom/atd/atdmobileapp/ui/product/tires/brands/TiresBrandsViewModel;", "getTiresBrandsViewModel", "()Lcom/atd/atdmobileapp/ui/product/tires/brands/TiresBrandsViewModel;", "tiresBrandsViewModel$delegate", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "BackPressed", "", "landsOnHomeScreenEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "visitKeySearchEvent", "visitVihSearchEvent", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class HomeTabFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentSubHomeBinding _binding;
    private final kotlin.Lazy homeViewModel$delegate = null;
    private final kotlin.Lazy tiresBrandsViewModel$delegate = null;
    private com.atd.atdmobileapp.MainViewModel mainViewModel;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.tabs.TabLayout tabLayout;
    @org.jetbrains.annotations.Nullable
    private androidx.viewpager.widget.ViewPager viewPager;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    
    public HomeTabFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentSubHomeBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentSubHomeBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.databinding.FragmentSubHomeBinding getBinding() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.bottomnavigation.homescreen.HomeViewModel getHomeViewModel() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel getTiresBrandsViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.tabs.TabLayout getTabLayout() {
        return null;
    }
    
    public final void setTabLayout(@org.jetbrains.annotations.Nullable
    com.google.android.material.tabs.TabLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.viewpager.widget.ViewPager getViewPager() {
        return null;
    }
    
    public final void setViewPager(@org.jetbrains.annotations.Nullable
    androidx.viewpager.widget.ViewPager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void visitVihSearchEvent() {
    }
    
    private final void landsOnHomeScreenEvent() {
    }
    
    private final void BackPressed() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void visitKeySearchEvent() {
    }
}