// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSeasonalDesignationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CheckBox cb1;

  @NonNull
  public final CheckBox cb2;

  @NonNull
  public final CheckBox cb3;

  @NonNull
  public final ImageView ivClose;

  @NonNull
  public final LinearLayoutCompat llBrandsHeader;

  @NonNull
  public final TextView seasonalDesgapply;

  @NonNull
  public final TextView tvBrands;

  @NonNull
  public final TextView tvClearAll;

  @NonNull
  public final View viewDivider2;

  @NonNull
  public final View viewSelectLocation;

  private FragmentSeasonalDesignationBinding(@NonNull ConstraintLayout rootView,
      @NonNull CheckBox cb1, @NonNull CheckBox cb2, @NonNull CheckBox cb3,
      @NonNull ImageView ivClose, @NonNull LinearLayoutCompat llBrandsHeader,
      @NonNull TextView seasonalDesgapply, @NonNull TextView tvBrands, @NonNull TextView tvClearAll,
      @NonNull View viewDivider2, @NonNull View viewSelectLocation) {
    this.rootView = rootView;
    this.cb1 = cb1;
    this.cb2 = cb2;
    this.cb3 = cb3;
    this.ivClose = ivClose;
    this.llBrandsHeader = llBrandsHeader;
    this.seasonalDesgapply = seasonalDesgapply;
    this.tvBrands = tvBrands;
    this.tvClearAll = tvClearAll;
    this.viewDivider2 = viewDivider2;
    this.viewSelectLocation = viewSelectLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSeasonalDesignationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSeasonalDesignationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_seasonal_designation, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSeasonalDesignationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cb1;
      CheckBox cb1 = ViewBindings.findChildViewById(rootView, id);
      if (cb1 == null) {
        break missingId;
      }

      id = R.id.cb2;
      CheckBox cb2 = ViewBindings.findChildViewById(rootView, id);
      if (cb2 == null) {
        break missingId;
      }

      id = R.id.cb3;
      CheckBox cb3 = ViewBindings.findChildViewById(rootView, id);
      if (cb3 == null) {
        break missingId;
      }

      id = R.id.ivClose;
      ImageView ivClose = ViewBindings.findChildViewById(rootView, id);
      if (ivClose == null) {
        break missingId;
      }

      id = R.id.llBrandsHeader;
      LinearLayoutCompat llBrandsHeader = ViewBindings.findChildViewById(rootView, id);
      if (llBrandsHeader == null) {
        break missingId;
      }

      id = R.id.seasonalDesgapply;
      TextView seasonalDesgapply = ViewBindings.findChildViewById(rootView, id);
      if (seasonalDesgapply == null) {
        break missingId;
      }

      id = R.id.tvBrands;
      TextView tvBrands = ViewBindings.findChildViewById(rootView, id);
      if (tvBrands == null) {
        break missingId;
      }

      id = R.id.tvClearAll;
      TextView tvClearAll = ViewBindings.findChildViewById(rootView, id);
      if (tvClearAll == null) {
        break missingId;
      }

      id = R.id.viewDivider2;
      View viewDivider2 = ViewBindings.findChildViewById(rootView, id);
      if (viewDivider2 == null) {
        break missingId;
      }

      id = R.id.viewSelectLocation;
      View viewSelectLocation = ViewBindings.findChildViewById(rootView, id);
      if (viewSelectLocation == null) {
        break missingId;
      }

      return new FragmentSeasonalDesignationBinding((ConstraintLayout) rootView, cb1, cb2, cb3,
          ivClose, llBrandsHeader, seasonalDesgapply, tvBrands, tvClearAll, viewDivider2,
          viewSelectLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
