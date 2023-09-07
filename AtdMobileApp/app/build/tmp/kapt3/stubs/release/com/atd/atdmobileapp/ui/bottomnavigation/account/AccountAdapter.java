package com.atd.atdmobileapp.ui.bottomnavigation.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\'B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007H\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006("}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountAdapter$viewHolder;", "title", "", "", "icons", "", "listner", "Lcom/atd/atdmobileapp/ui/bottomnavigation/account/RecyclerViewClickListener;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "([Ljava/lang/String;[Ljava/lang/Integer;Lcom/atd/atdmobileapp/ui/bottomnavigation/account/RecyclerViewClickListener;Landroidx/fragment/app/FragmentActivity;)V", "getIcons", "()[Ljava/lang/Integer;", "setIcons", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "mlistner", "getMlistner", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/account/RecyclerViewClickListener;", "setMlistner", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/account/RecyclerViewClickListener;)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "getTitle", "()[Ljava/lang/String;", "setTitle", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "viewHolder", "app_release"})
public final class AccountAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.bottomnavigation.account.AccountAdapter.viewHolder> {
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String[] title;
    @org.jetbrains.annotations.NotNull
    private java.lang.Integer[] icons;
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.ui.bottomnavigation.account.RecyclerViewClickListener mlistner;
    
    public AccountAdapter(@org.jetbrains.annotations.NotNull
    java.lang.String[] title, @org.jetbrains.annotations.NotNull
    java.lang.Integer[] icons, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.account.RecyclerViewClickListener listner, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Integer[] getIcons() {
        return null;
    }
    
    public final void setIcons(@org.jetbrains.annotations.NotNull
    java.lang.Integer[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.bottomnavigation.account.RecyclerViewClickListener getMlistner() {
        return null;
    }
    
    public final void setMlistner(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.account.RecyclerViewClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.account.AccountAdapter.viewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.account.AccountAdapter.viewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/account/AccountAdapter$viewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView13_garage", "Landroid/widget/ImageView;", "getImageView13_garage", "()Landroid/widget/ImageView;", "setImageView13_garage", "(Landroid/widget/ImageView;)V", "iv_icon_account", "getIv_icon_account", "setIv_icon_account", "iv_right_arrow_account", "getIv_right_arrow_account", "setIv_right_arrow_account", "tv_menu_item_name_account", "Landroid/widget/TextView;", "getTv_menu_item_name_account", "()Landroid/widget/TextView;", "setTv_menu_item_name_account", "(Landroid/widget/TextView;)V", "app_release"})
    public static final class viewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView iv_icon_account;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView tv_menu_item_name_account;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView iv_right_arrow_account;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView imageView13_garage;
        
        public viewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIv_icon_account() {
            return null;
        }
        
        public final void setIv_icon_account(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTv_menu_item_name_account() {
            return null;
        }
        
        public final void setTv_menu_item_name_account(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getIv_right_arrow_account() {
            return null;
        }
        
        public final void setIv_right_arrow_account(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImageView13_garage() {
            return null;
        }
        
        public final void setImageView13_garage(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
    }
}