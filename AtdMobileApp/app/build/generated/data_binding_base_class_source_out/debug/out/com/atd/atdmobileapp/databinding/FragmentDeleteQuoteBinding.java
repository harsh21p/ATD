// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
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

public final class FragmentDeleteQuoteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView detailQuote;

  @NonNull
  public final EditText etReason;

  @NonNull
  public final FrameLayout forFooter;

  @NonNull
  public final ImageView ivCancel;

  @NonNull
  public final ImageView ivCloseTireType;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final TextView reason;

  @NonNull
  public final RecyclerView rvYears;

  @NonNull
  public final LinearLayoutCompat tireTypesHeader;

  @NonNull
  public final TextView tvBrands;

  @NonNull
  public final View viewDivider9;

  @NonNull
  public final View viewSelectLocation;

  private FragmentDeleteQuoteBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView detailQuote, @NonNull EditText etReason, @NonNull FrameLayout forFooter,
      @NonNull ImageView ivCancel, @NonNull ImageView ivCloseTireType, @NonNull ImageView ivDelete,
      @NonNull TextView reason, @NonNull RecyclerView rvYears,
      @NonNull LinearLayoutCompat tireTypesHeader, @NonNull TextView tvBrands,
      @NonNull View viewDivider9, @NonNull View viewSelectLocation) {
    this.rootView = rootView;
    this.detailQuote = detailQuote;
    this.etReason = etReason;
    this.forFooter = forFooter;
    this.ivCancel = ivCancel;
    this.ivCloseTireType = ivCloseTireType;
    this.ivDelete = ivDelete;
    this.reason = reason;
    this.rvYears = rvYears;
    this.tireTypesHeader = tireTypesHeader;
    this.tvBrands = tvBrands;
    this.viewDivider9 = viewDivider9;
    this.viewSelectLocation = viewSelectLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDeleteQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDeleteQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_delete_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDeleteQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.detailQuote;
      TextView detailQuote = ViewBindings.findChildViewById(rootView, id);
      if (detailQuote == null) {
        break missingId;
      }

      id = R.id.etReason;
      EditText etReason = ViewBindings.findChildViewById(rootView, id);
      if (etReason == null) {
        break missingId;
      }

      id = R.id.forFooter;
      FrameLayout forFooter = ViewBindings.findChildViewById(rootView, id);
      if (forFooter == null) {
        break missingId;
      }

      id = R.id.ivCancel;
      ImageView ivCancel = ViewBindings.findChildViewById(rootView, id);
      if (ivCancel == null) {
        break missingId;
      }

      id = R.id.ivCloseTireType;
      ImageView ivCloseTireType = ViewBindings.findChildViewById(rootView, id);
      if (ivCloseTireType == null) {
        break missingId;
      }

      id = R.id.ivDelete;
      ImageView ivDelete = ViewBindings.findChildViewById(rootView, id);
      if (ivDelete == null) {
        break missingId;
      }

      id = R.id.reason;
      TextView reason = ViewBindings.findChildViewById(rootView, id);
      if (reason == null) {
        break missingId;
      }

      id = R.id.rvYears;
      RecyclerView rvYears = ViewBindings.findChildViewById(rootView, id);
      if (rvYears == null) {
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

      id = R.id.viewDivider9;
      View viewDivider9 = ViewBindings.findChildViewById(rootView, id);
      if (viewDivider9 == null) {
        break missingId;
      }

      id = R.id.viewSelectLocation;
      View viewSelectLocation = ViewBindings.findChildViewById(rootView, id);
      if (viewSelectLocation == null) {
        break missingId;
      }

      return new FragmentDeleteQuoteBinding((ConstraintLayout) rootView, detailQuote, etReason,
          forFooter, ivCancel, ivCloseTireType, ivDelete, reason, rvYears, tireTypesHeader,
          tvBrands, viewDivider9, viewSelectLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
