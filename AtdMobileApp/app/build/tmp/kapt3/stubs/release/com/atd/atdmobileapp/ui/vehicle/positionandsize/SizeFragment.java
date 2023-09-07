package com.atd.atdmobileapp.ui.vehicle.positionandsize;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u001dH\u0016J\u001a\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010#\u001a\u00020\u001dH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/positionandsize/SizeFragment;", "Landroidx/fragment/app/DialogFragment;", "oeDia", "", "selectedPos", "selectedSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentSizeBinding;", "adapter", "Lcom/atd/atdmobileapp/ui/vehicle/positionandsize/SizeAdapter;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentSizeBinding;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSizeClicked", "", "toDisplaysize", "toWrite", "onStart", "onViewCreated", "view", "setupRecyclerView", "Companion", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class SizeFragment extends androidx.fragment.app.DialogFragment {
    private final java.lang.String oeDia = null;
    private final java.lang.String selectedPos = null;
    private final java.lang.String selectedSize = null;
    private com.atd.atdmobileapp.databinding.FragmentSizeBinding _binding;
    private com.atd.atdmobileapp.ui.vehicle.positionandsize.SizeAdapter adapter;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    @org.jetbrains.annotations.NotNull
    public static final com.atd.atdmobileapp.ui.vehicle.positionandsize.SizeFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "sizeFrag";
    
    public SizeFragment(@org.jetbrains.annotations.NotNull
    java.lang.String oeDia, @org.jetbrains.annotations.NotNull
    java.lang.String selectedPos, @org.jetbrains.annotations.NotNull
    java.lang.String selectedSize) {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentSizeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void onSizeClicked(java.lang.String toDisplaysize, java.lang.String toWrite) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/positionandsize/SizeFragment$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}