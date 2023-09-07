// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class EachItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RelativeLayout expandableLayout;

  @NonNull
  public final ImageView ivPlus;

  @NonNull
  public final LinearLayoutCompat linearLayout;

  @NonNull
  public final RecyclerView rvChild;

  @NonNull
  public final TextView tvParent;

  @NonNull
  public final View viewSaveLocation;

  private EachItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull RelativeLayout expandableLayout, @NonNull ImageView ivPlus,
      @NonNull LinearLayoutCompat linearLayout, @NonNull RecyclerView rvChild,
      @NonNull TextView tvParent, @NonNull View viewSaveLocation) {
    this.rootView = rootView;
    this.expandableLayout = expandableLayout;
    this.ivPlus = ivPlus;
    this.linearLayout = linearLayout;
    this.rvChild = rvChild;
    this.tvParent = tvParent;
    this.viewSaveLocation = viewSaveLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static EachItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static EachItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.each_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static EachItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.expandable_layout;
      RelativeLayout expandableLayout = ViewBindings.findChildViewById(rootView, id);
      if (expandableLayout == null) {
        break missingId;
      }

      id = R.id.ivPlus;
      ImageView ivPlus = ViewBindings.findChildViewById(rootView, id);
      if (ivPlus == null) {
        break missingId;
      }

      id = R.id.linear_layout;
      LinearLayoutCompat linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.rvChild;
      RecyclerView rvChild = ViewBindings.findChildViewById(rootView, id);
      if (rvChild == null) {
        break missingId;
      }

      id = R.id.tvParent;
      TextView tvParent = ViewBindings.findChildViewById(rootView, id);
      if (tvParent == null) {
        break missingId;
      }

      id = R.id.viewSaveLocation;
      View viewSaveLocation = ViewBindings.findChildViewById(rootView, id);
      if (viewSaveLocation == null) {
        break missingId;
      }

      return new EachItemBinding((ConstraintLayout) rootView, expandableLayout, ivPlus,
          linearLayout, rvChild, tvParent, viewSaveLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}