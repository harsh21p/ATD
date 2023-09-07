package com.atd.atdmobileapp.ui.product.wheels.offsetdescription;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"BM\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/wheels/offsetdescription/OffsetDescriptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/product/wheels/offsetdescription/OffsetDescriptionAdapter$ViewHolder;", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateViewModel", "Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;", "dialog", "Landroid/app/Dialog;", "selectedList", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "(Ljava/util/ArrayList;Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;Landroid/app/Dialog;Ljava/util/ArrayList;Landroidx/fragment/app/FragmentActivity;)V", "getDialog", "()Landroid/app/Dialog;", "lastCheckedPosition", "", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "getSelectedList", "()Ljava/util/ArrayList;", "getUpdateViewModel", "()Lcom/atd/atdmobileapp/ui/product/wheels/UpdateViewModel;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"})
public final class OffsetDescriptionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.product.wheels.offsetdescription.OffsetDescriptionAdapter.ViewHolder> {
    private final java.util.ArrayList<java.lang.String> list = null;
    @org.jetbrains.annotations.NotNull
    private final com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel updateViewModel = null;
    @org.jetbrains.annotations.NotNull
    private final android.app.Dialog dialog = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.String> selectedList = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    private int lastCheckedPosition = -1;
    
    public OffsetDescriptionAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> list, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel updateViewModel, @org.jetbrains.annotations.NotNull
    android.app.Dialog dialog, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> selectedList, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.product.wheels.UpdateViewModel getUpdateViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.Dialog getDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getSelectedList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.product.wheels.offsetdescription.OffsetDescriptionAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.product.wheels.offsetdescription.OffsetDescriptionAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/atd/atdmobileapp/ui/product/wheels/offsetdescription/OffsetDescriptionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/SelectOptionItemBinding;", "(Lcom/atd/atdmobileapp/databinding/SelectOptionItemBinding;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/SelectOptionItemBinding;", "app_release"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.SelectOptionItemBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.SelectOptionItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.SelectOptionItemBinding getBinding() {
            return null;
        }
    }
}