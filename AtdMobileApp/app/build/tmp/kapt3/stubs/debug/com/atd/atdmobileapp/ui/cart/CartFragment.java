package com.atd.atdmobileapp.ui.cart;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u0002:\u0001aB*\b\u0016\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u00a2\u0006\u0002\u0010\nB\u0005\u00a2\u0006\u0002\u0010\u000bJ\b\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\tH\u0002J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000204J\u0012\u00106\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u00108\u001a\u00020\tH\u0016J\u0010\u00109\u001a\u0002042\u0006\u0010:\u001a\u00020\u001dH\u0002J\u0014\u0010;\u001a\u00020<2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150=J\b\u0010>\u001a\u00020\tH\u0002J&\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u000204H\u0002J\b\u0010J\u001a\u00020\tH\u0016J\u0010\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\u0015H\u0002J\b\u0010M\u001a\u00020\tH\u0002J\b\u0010N\u001a\u00020\tH\u0016J\u001a\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020@2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0=2\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0=H\u0002J\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150=H\u0002J\b\u0010U\u001a\u00020\tH\u0002J\u0010\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020<H\u0002J\u001e\u0010X\u001a\u00020\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00150=2\u0006\u0010Z\u001a\u00020\u001dH\u0002J\u0018\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u0002042\u0006\u0010I\u001a\u000204H\u0002J\b\u0010]\u001a\u00020\tH\u0002J\u0018\u0010^\u001a\u00020\t2\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0=H\u0002J\u0016\u0010_\u001a\u00020\t2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b&\u0010\'R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006b"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/CartFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/atd/atdmobileapp/ui/cart/checkout/CheckoutFragment$CheckoutListener;", "triggerBadgeCount", "Lkotlin/Function1;", "Lcom/atd/atdmobileapp/models/PlaceOrder;", "Lkotlin/ParameterName;", "name", "data", "", "(Lkotlin/jvm/functions/Function1;)V", "()V", "_binding", "Lcom/atd/atdmobileapp/databinding/FragmentCartBinding;", "binding", "getBinding", "()Lcom/atd/atdmobileapp/databinding/FragmentCartBinding;", "cartAdapter", "Lcom/atd/atdmobileapp/ui/cart/CartAdapter;", "cartItemList", "", "Lcom/atd/atdmobileapp/models/CartItem;", "cartViewModel", "Lcom/atd/atdmobileapp/ui/cart/CartViewModel;", "getCartViewModel", "()Lcom/atd/atdmobileapp/ui/cart/CartViewModel;", "cartViewModel$delegate", "Lkotlin/Lazy;", "fetTotal", "", "filterList", "Lcom/atd/atdmobileapp/models/Cart;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "mainViewModel", "Lcom/atd/atdmobileapp/MainViewModel;", "permissionViewModel", "Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "getPermissionViewModel", "()Lcom/atd/atdmobileapp/ui/login/LoginViewModel;", "permissionViewModel$delegate", "sharedPrefManager", "Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "getSharedPrefManager", "()Lcom/atd/atdmobileapp/utils/SharedPrefManager;", "setSharedPrefManager", "(Lcom/atd/atdmobileapp/utils/SharedPrefManager;)V", "transferredData", "backPressed", "bindObservers", "checkOutClick", "convertAmount", "", "amount", "delProdFromCartEvent", "productBeingDeleted", "dismiss", "formatNumber", "number", "getTotalQuantity", "", "", "onClickSearchIcon", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDataTransferred", "onDeleteCart", "supplier", "onDestroyView", "onQuantityAndEditClick", "cartItem", "onSaveClick", "onStart", "onViewCreated", "view", "prepareListOfLineItems", "Lcom/atd/atdmobileapp/models/Lineitem;", "value", "removeDuplicateCart", "replaceWithHomeTabFrag", "setBadgeCount", "count", "setCartItems", "items", "orderTotal", "showDialog", "documentId", "updateTheme", "updateView", "visitCartScreenEvent", "cartItems", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class CartFragment extends androidx.fragment.app.DialogFragment implements com.atd.atdmobileapp.ui.cart.checkout.CheckoutFragment.CheckoutListener {
    private com.atd.atdmobileapp.databinding.FragmentCartBinding _binding;
    private final kotlin.Lazy cartViewModel$delegate = null;
    private java.util.List<com.atd.atdmobileapp.models.Cart> filterList;
    private java.util.List<com.atd.atdmobileapp.models.CartItem> cartItemList;
    private com.atd.atdmobileapp.ui.cart.CartAdapter cartAdapter;
    private com.atd.atdmobileapp.models.PlaceOrder transferredData;
    private com.atd.atdmobileapp.MainViewModel mainViewModel;
    private double fetTotal = 0.0;
    @javax.inject.Inject
    public com.atd.atdmobileapp.utils.SharedPrefManager sharedPrefManager;
    private final kotlin.Lazy permissionViewModel$delegate = null;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.PlaceOrder, kotlin.Unit> triggerBadgeCount;
    @org.jetbrains.annotations.NotNull
    public static final com.atd.atdmobileapp.ui.cart.CartFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TAG = "CartFragment";
    
    public CartFragment() {
        super();
    }
    
    private final com.atd.atdmobileapp.databinding.FragmentCartBinding getBinding() {
        return null;
    }
    
    private final com.atd.atdmobileapp.ui.cart.CartViewModel getCartViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.utils.SharedPrefManager getSharedPrefManager() {
        return null;
    }
    
    public final void setSharedPrefManager(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.utils.SharedPrefManager p0) {
    }
    
    private final com.atd.atdmobileapp.ui.login.LoginViewModel getPermissionViewModel() {
        return null;
    }
    
    public CartFragment(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.atd.atdmobileapp.models.PlaceOrder, kotlin.Unit> triggerBadgeCount) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
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
    
    private final void onClickSearchIcon() {
    }
    
    private final void replaceWithHomeTabFrag() {
    }
    
    private final void bindObservers() {
    }
    
    private final void visitCartScreenEvent(java.util.List<com.atd.atdmobileapp.models.CartItem> cartItems) {
    }
    
    private final void setCartItems(java.util.List<com.atd.atdmobileapp.models.CartItem> items, double orderTotal) {
    }
    
    private final java.lang.String formatNumber(double number) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String convertAmount(@org.jetbrains.annotations.NotNull
    java.lang.String amount) {
        return null;
    }
    
    private final java.util.List<com.atd.atdmobileapp.models.CartItem> removeDuplicateCart(java.util.List<com.atd.atdmobileapp.models.CartItem> cartItemList) {
        return null;
    }
    
    public final int getTotalQuantity(@org.jetbrains.annotations.NotNull
    java.util.List<com.atd.atdmobileapp.models.CartItem> cartItemList) {
        return 0;
    }
    
    private final void updateView(java.util.List<com.atd.atdmobileapp.models.Cart> value) {
    }
    
    private final java.util.List<com.atd.atdmobileapp.models.Lineitem> prepareListOfLineItems(java.util.List<com.atd.atdmobileapp.models.Cart> value) {
        return null;
    }
    
    private final void onDeleteCart(java.lang.String supplier) {
    }
    
    private final void onQuantityAndEditClick(com.atd.atdmobileapp.models.CartItem cartItem) {
    }
    
    private final void onSaveClick() {
    }
    
    private final void checkOutClick() {
    }
    
    @java.lang.Override
    public void onDataTransferred(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.models.PlaceOrder data) {
    }
    
    private final void showDialog(java.lang.String documentId, java.lang.String supplier) {
    }
    
    private final void delProdFromCartEvent(com.atd.atdmobileapp.models.CartItem productBeingDeleted) {
    }
    
    private final void setBadgeCount(int count) {
    }
    
    private final void updateTheme() {
    }
    
    @java.lang.Override
    public void onStart() {
    }
    
    private final void backPressed() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @java.lang.Override
    public void dismiss() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/atd/atdmobileapp/ui/cart/CartFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}