package com.atd.atdmobileapp.ui.vehicle.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0011\u0012B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/model/ModelAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "", "Lcom/atd/atdmobileapp/ui/vehicle/model/ModelAdapter$ModelViewHolder;", "sendModel", "Lkotlin/Function1;", "", "selectedModel", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ModelDiffCallback", "ModelViewHolder", "app_debug"})
public final class ModelAdapter extends androidx.recyclerview.widget.ListAdapter<java.lang.String, com.atd.atdmobileapp.ui.vehicle.model.ModelAdapter.ModelViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> sendModel = null;
    private final java.lang.String selectedModel = null;
    
    public ModelAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> sendModel, @org.jetbrains.annotations.Nullable
    java.lang.String selectedModel) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.vehicle.model.ModelAdapter.ModelViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.vehicle.model.ModelAdapter.ModelViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/model/ModelAdapter$ModelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;", "(Lcom/atd/atdmobileapp/ui/vehicle/model/ModelAdapter;Lcom/atd/atdmobileapp/databinding/CustomLayoutYearsBinding;)V", "bind", "", "model", "", "app_debug"})
    public final class ModelViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding = null;
        
        public ModelViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.CustomLayoutYearsBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        java.lang.String model) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/vehicle/model/ModelAdapter$ModelDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    static final class ModelDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<java.lang.String> {
        
        public ModelDiffCallback() {
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