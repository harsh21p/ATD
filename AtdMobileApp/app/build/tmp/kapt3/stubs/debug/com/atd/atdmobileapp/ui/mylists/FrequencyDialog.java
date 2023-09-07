package com.atd.atdmobileapp.ui.mylists;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010\u0002\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006."}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/FrequencyDialog;", "Landroidx/fragment/app/DialogFragment;", "selectedItem", "", "(Ljava/lang/String;)V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentFrequencyDialogBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentFrequencyDialogBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentFrequencyDialogBinding;)V", "binding", "getBinding", "color", "", "getColor", "()Ljava/lang/Integer;", "setColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mainViewModel", "Lcom/atd/atdmobileapp/MainViewModel;", "getMainViewModel", "()Lcom/atd/atdmobileapp/MainViewModel;", "setMainViewModel", "(Lcom/atd/atdmobileapp/MainViewModel;)V", "profileSelected", "getSelectedItem", "()Ljava/lang/String;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "item", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class FrequencyDialog extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String selectedItem = null;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentFrequencyDialogBinding _binding;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.MainViewModel mainViewModel;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer color;
    private java.lang.String profileSelected = "";
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    
    public FrequencyDialog(@org.jetbrains.annotations.NotNull
    java.lang.String selectedItem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedItem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentFrequencyDialogBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentFrequencyDialogBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.databinding.FragmentFrequencyDialogBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.MainViewModel getMainViewModel() {
        return null;
    }
    
    public final void setMainViewModel(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.MainViewModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getColor() {
        return null;
    }
    
    public final void setColor(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
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
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void selectedItem(@org.jetbrains.annotations.NotNull
    java.lang.String item) {
    }
}