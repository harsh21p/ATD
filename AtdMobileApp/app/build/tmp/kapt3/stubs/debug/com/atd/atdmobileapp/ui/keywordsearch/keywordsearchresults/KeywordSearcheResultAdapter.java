package com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B\u0091\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\u0018J\u0014\u0010/\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e00J\b\u00101\u001a\u00020\u0014H\u0016J\u0018\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u0014H\u0016J\u0018\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR)\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010!R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010!R\u001a\u0010\"\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006:"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/keywordsearchresults/KeywordSearcheResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/keywordsearch/keywordsearchresults/KeywordSearcheResultAdapter$DataViewHolder;", "onAddToCartClicked", "Lkotlin/Function1;", "Lcom/atd/atdmobileapp/models/Cart;", "", "isCustomerPickupDelivery", "Lkotlin/Function0;", "isFutureDelivery", "activity", "Landroidx/fragment/app/FragmentActivity;", "productSearches", "Ljava/util/ArrayList;", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "Lkotlin/collections/ArrayList;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "eventLogger", "Lkotlin/reflect/KFunction3;", "", "", "callProductFrag", "Landroid/os/Bundle;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/fragment/app/FragmentActivity;Ljava/util/ArrayList;Lcom/atd/atdmobileapp/utils/SharedPrefManager;Lkotlin/reflect/KFunction;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "getCallProductFrag", "()Lkotlin/jvm/functions/Function1;", "getEventLogger", "()Lkotlin/reflect/KFunction;", "()Lkotlin/jvm/functions/Function0;", "lastSelectedPosition", "getLastSelectedPosition", "()I", "setLastSelectedPosition", "(I)V", "getOnAddToCartClicked", "selectedPosition", "getSelectedPosition", "setSelectedPosition", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "addProductSearches", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DataViewHolder", "app_debug"})
public final class KeywordSearcheResultAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearcheResultAdapter.DataViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.Cart, kotlin.Unit> onAddToCartClicked = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function0<kotlin.Unit> isCustomerPickupDelivery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function0<kotlin.Unit> isFutureDelivery = null;
    @org.jetbrains.annotations.NotNull
    private androidx.fragment.app.FragmentActivity activity;
    private final java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> productSearches = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.reflect.KFunction<kotlin.Unit> eventLogger = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<android.os.Bundle, kotlin.Unit> callProductFrag = null;
    private int selectedPosition = -1;
    private int lastSelectedPosition = -1;
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    
    public KeywordSearcheResultAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.Cart, kotlin.Unit> onAddToCartClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> isCustomerPickupDelivery, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> isFutureDelivery, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> productSearches, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager, @org.jetbrains.annotations.NotNull
    kotlin.reflect.KFunction<kotlin.Unit> eventLogger, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> callProductFrag) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.Cart, kotlin.Unit> getOnAddToCartClicked() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function0<kotlin.Unit> isCustomerPickupDelivery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function0<kotlin.Unit> isFutureDelivery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getActivity() {
        return null;
    }
    
    public final void setActivity(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.reflect.KFunction<kotlin.Unit> getEventLogger() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function1<android.os.Bundle, kotlin.Unit> getCallProductFrag() {
        return null;
    }
    
    public final int getSelectedPosition() {
        return 0;
    }
    
    public final void setSelectedPosition(int p0) {
    }
    
    public final int getLastSelectedPosition() {
        return 0;
    }
    
    public final void setLastSelectedPosition(int p0) {
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
    public com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearcheResultAdapter.DataViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearcheResultAdapter.DataViewHolder holder, int position) {
    }
    
    public final void addProductSearches(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> productSearches) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\u0014J6\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00100$j\b\u0012\u0004\u0012\u00020\u0010`%J\u000e\u0010&\u001a\u00020\u00112\u0006\u0010\'\u001a\u00020(R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R)\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018\u00a8\u0006)"}, d2 = {"Lcom/atd/atdmobileapp/ui/keywordsearch/keywordsearchresults/KeywordSearcheResultAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/atd/atdmobileapp/databinding/KeywordSearchResultItemBinding;", "onAddToCartClicked", "Lkotlin/Function1;", "Lcom/atd/atdmobileapp/models/Cart;", "", "isCustomerPickupDelivery", "Lkotlin/Function0;", "isFutureDelivery", "listOfItems", "Lcom/atd/atdmobileapp/models/preferences/ProductItems;", "eventLogger", "Lkotlin/reflect/KFunction3;", "", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "", "callProductFrag", "Landroid/os/Bundle;", "(Lcom/atd/atdmobileapp/databinding/KeywordSearchResultItemBinding;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/atd/atdmobileapp/models/preferences/ProductItems;Lkotlin/reflect/KFunction;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/atd/atdmobileapp/databinding/KeywordSearchResultItemBinding;", "getCallProductFrag", "()Lkotlin/jvm/functions/Function1;", "getEventLogger", "()Lkotlin/reflect/KFunction;", "()Lkotlin/jvm/functions/Function0;", "getOnAddToCartClicked", "bind", "product", "activity", "Landroidx/fragment/app/FragmentActivity;", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "productSearches", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roundOffDecimal", "number", "", "app_debug"})
    public static final class DataViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.atd.atdmobileapp.databinding.KeywordSearchResultItemBinding binding = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.Cart, kotlin.Unit> onAddToCartClicked = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function0<kotlin.Unit> isCustomerPickupDelivery = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function0<kotlin.Unit> isFutureDelivery = null;
        private final com.atd.atdmobileapp.models.preferences.ProductItems listOfItems = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.reflect.KFunction<kotlin.Unit> eventLogger = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function1<android.os.Bundle, kotlin.Unit> callProductFrag = null;
        
        public DataViewHolder(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.databinding.KeywordSearchResultItemBinding binding, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.Cart, kotlin.Unit> onAddToCartClicked, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> isCustomerPickupDelivery, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function0<kotlin.Unit> isFutureDelivery, @org.jetbrains.annotations.Nullable
        com.atd.atdmobileapp.models.preferences.ProductItems listOfItems, @org.jetbrains.annotations.NotNull
        kotlin.reflect.KFunction<kotlin.Unit> eventLogger, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super android.os.Bundle, kotlin.Unit> callProductFrag) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.atd.atdmobileapp.databinding.KeywordSearchResultItemBinding getBinding() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function1<com.atd.atdmobileapp.models.Cart, kotlin.Unit> getOnAddToCartClicked() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function0<kotlin.Unit> isCustomerPickupDelivery() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function0<kotlin.Unit> isFutureDelivery() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.reflect.KFunction<kotlin.Unit> getEventLogger() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlin.jvm.functions.Function1<android.os.Bundle, kotlin.Unit> getCallProductFrag() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.models.keywordsearch.Product product, @org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.NotNull
        com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager, @org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> productSearches) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String roundOffDecimal(double number) {
            return null;
        }
    }
}