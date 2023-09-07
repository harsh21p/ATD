package com.atd.atdmobileapp.ui.product.wheels.wheeltype;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [DiameterDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u00100\u001a\u00020 H\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u00061"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/wheels/wheeltype/SelectWeelTypeDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/OnClickItem;", "updateViewModel", "Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;", "typeOfAdapter", "", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;Ljava/lang/String;Ljava/util/ArrayList;)V", "_binding", "Lcom/atd/atdmobileapp/databinding/SelectOptionListBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/SelectOptionListBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/SelectOptionListBinding;)V", "adapter", "Lcom/atd/atdmobileapp/ui/product/wheels/wheeltype/WheelsWidthAdapter;", "binding", "getBinding", "diameterAdapter", "Lcom/atd/atdmobileapp/ui/product/wheels/wheeltype/DiameterAdapter;", "getSelectedList", "()Ljava/util/ArrayList;", "getTypeOfAdapter", "()Ljava/lang/String;", "getUpdateViewModel", "()Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;", "setUpdateViewModel", "(Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;)V", "BackPressed", "", "ClickItem", "diameterValue", "b", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupTheme", "app_debug"})
public final class SelectWeelTypeDialogFragment extends androidx.fragment.app.DialogFragment implements com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.OnClickItem {
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel updateViewModel;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String typeOfAdapter = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.String> selectedList = null;
    private com.atd.atdmobileapp.ui.product.wheels.wheeltype.WheelsWidthAdapter adapter;
    private com.atd.atdmobileapp.ui.product.wheels.wheeltype.DiameterAdapter diameterAdapter;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.SelectOptionListBinding _binding;
    
    public SelectWeelTypeDialogFragment(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel updateViewModel, @org.jetbrains.annotations.NotNull
    java.lang.String typeOfAdapter, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> selectedList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel getUpdateViewModel() {
        return null;
    }
    
    public final void setUpdateViewModel(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTypeOfAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getSelectedList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.SelectOptionListBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.SelectOptionListBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.databinding.SelectOptionListBinding getBinding() {
        return null;
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
    
    private final void setupTheme() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void ClickItem(@org.jetbrains.annotations.NotNull
    java.lang.String diameterValue, boolean b) {
    }
    
    @java.lang.Override
    public void BackPressed() {
    }
}