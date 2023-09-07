package com.atd.atdmobileapp.ui.bottomnavigation.mygarage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011BG\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010(\u001a\u00020\bH\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\bH\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\bH\u0016R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b&\u0010\u0011\"\u0004\b\'\u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageAdapter$ViewHolder;", "title", "", "", "descriptions", "icons", "", "noOfApprovals", "listner", "Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/RecyclerViewClickListner;", "requireActivity", "Landroidx/fragment/app/FragmentActivity;", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Integer;ILcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/RecyclerViewClickListner;Landroidx/fragment/app/FragmentActivity;)V", "descriptions_list", "getDescriptions_list", "()[Ljava/lang/String;", "setDescriptions_list", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "icon_list", "getIcon_list", "()[Ljava/lang/Integer;", "setIcon_list", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "getListner", "()Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/RecyclerViewClickListner;", "setListner", "(Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/RecyclerViewClickListner;)V", "getNoOfApprovals", "()I", "setNoOfApprovals", "(I)V", "getRequireActivity", "()Landroidx/fragment/app/FragmentActivity;", "title_list", "getTitle_list", "setTitle_list", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"})
public final class MyGarageAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.FragmentActivity requireActivity = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String[] title_list;
    @org.jetbrains.annotations.NotNull
    private java.lang.String[] descriptions_list;
    @org.jetbrains.annotations.NotNull
    private java.lang.Integer[] icon_list;
    private int noOfApprovals;
    @org.jetbrains.annotations.NotNull
    private com.atd.atdmobileapp.ui.bottomnavigation.mygarage.RecyclerViewClickListner listner;
    
    public MyGarageAdapter(@org.jetbrains.annotations.NotNull
    java.lang.String[] title, @org.jetbrains.annotations.NotNull
    java.lang.String[] descriptions, @org.jetbrains.annotations.NotNull
    java.lang.Integer[] icons, int noOfApprovals, @org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.mygarage.RecyclerViewClickListner listner, @org.jetbrains.annotations.NotNull
    androidx.fragment.app.FragmentActivity requireActivity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.fragment.app.FragmentActivity getRequireActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getTitle_list() {
        return null;
    }
    
    public final void setTitle_list(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getDescriptions_list() {
        return null;
    }
    
    public final void setDescriptions_list(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.Integer[] getIcon_list() {
        return null;
    }
    
    public final void setIcon_list(@org.jetbrains.annotations.NotNull
    java.lang.Integer[] p0) {
    }
    
    public final int getNoOfApprovals() {
        return 0;
    }
    
    public final void setNoOfApprovals(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.atd.atdmobileapp.ui.bottomnavigation.mygarage.RecyclerViewClickListner getListner() {
        return null;
    }
    
    public final void setListner(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.mygarage.RecyclerViewClickListner p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/atd/atdmobileapp/ui/bottomnavigation/mygarage/MyGarageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ellipse_red_garage", "Landroid/widget/TextView;", "getEllipse_red_garage", "()Landroid/widget/TextView;", "setEllipse_red_garage", "(Landroid/widget/TextView;)V", "imageView12_garage", "Landroid/widget/ImageView;", "getImageView12_garage", "()Landroid/widget/ImageView;", "setImageView12_garage", "(Landroid/widget/ImageView;)V", "imageView13_garage", "getImageView13_garage", "setImageView13_garage", "textView5_garage", "getTextView5_garage", "setTextView5_garage", "tv_menu_item_name_garage", "getTv_menu_item_name_garage", "setTv_menu_item_name_garage", "app_release"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView imageView12_garage;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView ellipse_red_garage;
        @org.jetbrains.annotations.NotNull
        private android.widget.ImageView imageView13_garage;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView tv_menu_item_name_garage;
        @org.jetbrains.annotations.NotNull
        private android.widget.TextView textView5_garage;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImageView12_garage() {
            return null;
        }
        
        public final void setImageView12_garage(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getEllipse_red_garage() {
            return null;
        }
        
        public final void setEllipse_red_garage(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.ImageView getImageView13_garage() {
            return null;
        }
        
        public final void setImageView13_garage(@org.jetbrains.annotations.NotNull
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTv_menu_item_name_garage() {
            return null;
        }
        
        public final void setTv_menu_item_name_garage(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getTextView5_garage() {
            return null;
        }
        
        public final void setTextView5_garage(@org.jetbrains.annotations.NotNull
        android.widget.TextView p0) {
        }
    }
}