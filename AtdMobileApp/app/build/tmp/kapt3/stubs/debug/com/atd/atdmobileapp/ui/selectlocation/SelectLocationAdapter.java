package com.atd.atdmobileapp.ui.selectlocation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B+\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/atd/atdmobileapp/ui/selectlocation/SelectLocationAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/atd/atdmobileapp/models/Location;", "Lcom/atd/atdmobileapp/ui/selectlocation/SelectLocationAdapter$SelectLocationHolder;", "onSelectLocationClicked", "Lkotlin/Function1;", "", "prefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "selectedLocation", "(Lkotlin/jvm/functions/Function1;Lcom/atd/atdmobileapp/utils/SharedPrefManager;Lcom/atd/atdmobileapp/models/Location;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ComparatorDiffUtil", "SelectLocationHolder", "app_debug"})
public final class SelectLocationAdapter extends androidx.recyclerview.widget.ListAdapter<com.atd.atdmobileapp.models.Location, com.atd.atdmobileapp.ui.selectlocation.SelectLocationAdapter.SelectLocationHolder> {
    private final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.Location, kotlin.Unit> onSelectLocationClicked = null;
    private final com.atd.atdmobileapp.utils.SharedPrefManager prefManager = null;
    private com.atd.atdmobileapp.models.Location selectedLocation;
    
    public SelectLocationAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.Location, kotlin.Unit> onSelectLocationClicked, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager prefManager, @org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.models.Location selectedLocation) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.selectlocation.SelectLocationAdapter.SelectLocationHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.selectlocation.SelectLocationAdapter.SelectLocationHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/atd/atdmobileapp/ui/selectlocation/SelectLocationAdapter$SelectLocationHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/SelectLocationItemBinding;", "(Lcom/atd/atdmobileapp/ui/selectlocation/SelectLocationAdapter;Lcom/atd/atdmobileapp/databinding/SelectLocationItemBinding;)V", "bind", "", "location", "Lcom/atd/atdmobileapp/models/Location;", "position", "", "app_debug"})
    public final class SelectLocationHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.atd.atdmobileapp.databinding.SelectLocationItemBinding binding = null;
        
        public SelectLocationHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.SelectLocationItemBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.Location location, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/atd/atdmobileapp/ui/selectlocation/SelectLocationAdapter$ComparatorDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/atd/atdmobileapp/models/Location;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class ComparatorDiffUtil extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.atd.atdmobileapp.models.Location> {
        
        public ComparatorDiffUtil() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.Location oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.Location newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.Location oldItem, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.Location newItem) {
            return false;
        }
    }
}