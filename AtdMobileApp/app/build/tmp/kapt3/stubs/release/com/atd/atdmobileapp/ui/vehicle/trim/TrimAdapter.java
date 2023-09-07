package com.atd.atdmobileapp.ui.vehicle.trim;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/trim/TrimAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/atd/atdmobileapp/ui/vehicle/trim/TrimAdapter$TrimViewHolder;", "sendTrim", "Lkotlin/Function1;", "", "selectedTrim", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TrimDiffCallback", "TrimViewHolder", "app_release"})
public final class TrimAdapter extends androidx.recyclerview.widget.ListAdapter<java.lang.String, com.atd.atdmobileapp.ui.vehicle.trim.TrimAdapter.TrimViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> sendTrim = null;
    private final java.lang.String selectedTrim = null;
    
    public TrimAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> sendTrim, @org.jetbrains.annotations.Nullable
    java.lang.String selectedTrim) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.vehicle.trim.TrimAdapter.TrimViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.vehicle.trim.TrimAdapter.TrimViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/trim/TrimAdapter$TrimViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;", "(Lcom/atd/atdmobileapp/ui/vehicle/trim/TrimAdapter;Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;)V", "bind", "", "trim", "", "app_release"})
    public final class TrimViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding = null;
        
        public TrimViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String trim) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/trim/TrimAdapter$TrimDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    static final class TrimDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.String> {
        
        public TrimDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        java.lang.String oldItem, @org.jetbrains.annotations.NotNull
        java.lang.String newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        java.lang.String oldItem, @org.jetbrains.annotations.NotNull
        java.lang.String newItem) {
            return false;
        }
    }
}