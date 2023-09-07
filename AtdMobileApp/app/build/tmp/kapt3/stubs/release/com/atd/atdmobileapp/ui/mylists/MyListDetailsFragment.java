package com.atd.atdmobileapp.ui.mylists;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fH\u0002J\u0010\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020\u000fH\u0002J\u0010\u0010D\u001a\u00020@2\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fJ\u0006\u0010H\u001a\u00020@J\u0006\u0010I\u001a\u00020@J\u0016\u0010J\u001a\u00020@2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001dH\u0002J\b\u0010L\u001a\u00020@H\u0002J\b\u0010M\u001a\u00020@H\u0002J&\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010FH\u0016J\b\u0010U\u001a\u00020@H\u0016J\u001a\u0010V\u001a\u00020@2\u0006\u0010W\u001a\u00020O2\b\u0010T\u001a\u0004\u0018\u00010FH\u0016J\u0016\u0010X\u001a\u00020@2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0006\u0010Z\u001a\u00020@J\u0006\u0010[\u001a\u00020@J\b\u0010\\\u001a\u00020@H\u0002J\b\u0010]\u001a\u00020@H\u0002J*\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\u001e2\u0006\u0010A\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b!\u0010\"R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u001b\u001a\u0004\b(\u0010)R\"\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010,j\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006b"}, d2 = {"Lcom/atd/atdmobileapp/ui/mylists/MyListDetailsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "CAMERA_PERMISSION_REQUEST", "", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentMyListDetailsBinding;", "get_binding", "()Lcom/atd/atdmobileapp/databinding/FragmentMyListDetailsBinding;", "set_binding", "(Lcom/atd/atdmobileapp/databinding/FragmentMyListDetailsBinding;)V", "adapter", "Lcom/atd/atdmobileapp/ui/mylists/MyListDetailsAdapter;", "atdproductnumberList", "", "", "getAtdproductnumberList", "()Ljava/util/List;", "setAtdproductnumberList", "(Ljava/util/List;)V", "binding", "getBinding", "myListViewModel", "Lcom/atd/atdmobileapp/ui/mylists/MyListViewModel;", "getMyListViewModel", "()Lcom/atd/atdmobileapp/ui/mylists/MyListViewModel;", "myListViewModel$delegate", "Lkotlin/Lazy;", "originalList", "", "Lcom/atd/atdmobileapp/models/keywordsearch/Product;", "productByCriteriaViewModel", "Lcom/atd/atdmobileapp/ui/product/ProductViewModel;", "getProductByCriteriaViewModel", "()Lcom/atd/atdmobileapp/ui/product/ProductViewModel;", "productByCriteriaViewModel$delegate", "productData", "Lcom/atd/atdmobileapp/models/mylist/Productlists;", "recentKeywordSearchViewModel", "Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/RecentKeywordSearchViewModel;", "getRecentKeywordSearchViewModel", "()Lcom/atd/atdmobileapp/ui/keywordsearch/keywordrecentsearches/RecentKeywordSearchViewModel;", "recentKeywordSearchViewModel$delegate", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectedProfile", "getSelectedProfile", "()Ljava/lang/String;", "setSelectedProfile", "(Ljava/lang/String;)V", "sequencenumber", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "themeColor", "getThemeColor", "()I", "setThemeColor", "(I)V", "DeleteItem", "", "type", "addItem", "listName", "callProductDetails", "bundle", "Landroid/os/Bundle;", "deleteDialog", "disable", "enable", "getProductDetails", "atdproductnumber", "isCustomerPickupDelivery", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onResume", "onViewCreated", "view", "productResult", "result", "renameDialog", "setUpTheme", "setupUI", "startBarcodeScanner", "updateItems", "totalSize", "itemSize", "product", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MyListDetailsFragment extends androidx.fragment.app.Fragment {
    private int sequencenumber = 0;
    private com.atd.atdmobileapp.models.mylist.Productlists productData;
    private com.atd.atdmobileapp.ui.mylists.MyListDetailsAdapter adapter;
    @org.jetbrains.annotations.Nullable
    private com.atd.atdmobileapp.databinding.FragmentMyListDetailsBinding _binding;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    public java.lang.String selectedProfile;
    private int themeColor = com.atd.atdmobileapp.R.color.black;
    public java.util.List<java.lang.String> atdproductnumberList;
    private final kotlin.Lazy productByCriteriaViewModel$delegate = null;
    private final kotlin.Lazy recentKeywordSearchViewModel$delegate = null;
    private final kotlin.Lazy myListViewModel$delegate = null;
    private java.util.ArrayList<com.atd.atdmobileapp.models.keywordsearch.Product> selectedList;
    private java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> originalList;
    private final int CAMERA_PERMISSION_REQUEST = 123;
    
    public MyListDetailsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.atd.atdmobileapp.databinding.FragmentMyListDetailsBinding get_binding() {
        return null;
    }
    
    public final void set_binding(@org.jetbrains.annotations.Nullable
    com.atd.atdmobileapp.databinding.FragmentMyListDetailsBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.databinding.FragmentMyListDetailsBinding getBinding() {
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
    public final java.lang.String getSelectedProfile() {
        return null;
    }
    
    public final void setSelectedProfile(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getThemeColor() {
        return 0;
    }
    
    public final void setThemeColor(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getAtdproductnumberList() {
        return null;
    }
    
    public final void setAtdproductnumberList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    private final com.atd.atdmobileapp.ui.product.ProductViewModel getProductByCriteriaViewModel() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.RecentKeywordSearchViewModel getRecentKeywordSearchViewModel() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.mylists.MyListViewModel getMyListViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startBarcodeScanner() {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    private final void callProductDetails(android.os.Bundle bundle) {
    }
    
    private final void isCustomerPickupDelivery() {
    }
    
    private final void addItem(java.lang.String listName) {
    }
    
    public final void deleteDialog(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    public final void renameDialog() {
    }
    
    private final void DeleteItem(java.lang.String type) {
    }
    
    private final void getProductDetails(java.util.List<java.lang.String> atdproductnumber) {
    }
    
    private final void setupUI() {
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void productResult(java.util.List<com.atd.atdmobileapp.models.keywordsearch.Product> result) {
    }
    
    private final void updateItems(int totalSize, int itemSize, com.atd.atdmobileapp.models.keywordsearch.Product product, java.lang.String type) {
    }
    
    public final void enable() {
    }
    
    public final void disable() {
    }
    
    private final void onBackPressed() {
    }
    
    public final void setUpTheme() {
    }
}