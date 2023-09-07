// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class FragmentTrimBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivCloseTireType;

  @NonNull
  public final RecyclerView rvTrim;

  @NonNull
  public final LinearLayoutCompat tireTypesHeader;

  @NonNull
  public final TextView tvBrands;

  @NonNull
  public final View viewSelectLocation;

  private FragmentTrimBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView ivCloseTireType, @NonNull RecyclerView rvTrim,
      @NonNull LinearLayoutCompat tireTypesHeader, @NonNull TextView tvBrands,
      @NonNull View viewSelectLocation) {
    this.rootView = rootView;
    this.ivCloseTireType = ivCloseTireType;
    this.rvTrim = rvTrim;
    this.tireTypesHeader = tireTypesHeader;
    this.tvBrands = tvBrands;
    this.viewSelectLocation = viewSelectLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTrimBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTrimBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_trim, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTrimBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivCloseTireType;
      ImageView ivCloseTireType = ViewBindings.findChildViewById(rootView, id);
      if (ivCloseTireType == null) {
        break missingId;
      }

      id = R.id.rvTrim;
      RecyclerView rvTrim = ViewBindings.findChildViewById(rootView, id);
      if (rvTrim == null) {
        break missingId;
      }

      id = R.id.tireTypesHeader;
      LinearLayoutCompat tireTypesHeader = ViewBindings.findChildViewById(rootView, id);
      if (tireTypesHeader == null) {
        break missingId;
      }

      id = R.id.tvBrands;
      TextView tvBrands = ViewBindings.findChildViewById(rootView, id);
      if (tvBrands == null) {
        break missingId;
      }

      id = R.id.viewSelectLocation;
      View viewSelectLocation = ViewBindings.findChildViewById(rootView, id);
      if (viewSelectLocation == null) {
        break missingId;
      }

      return new FragmentTrimBinding((ConstraintLayout) rootView, ivCloseTireType, rvTrim,
          tireTypesHeader, tvBrands, viewSelectLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}