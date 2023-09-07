// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

public final class FragmentSelectLocationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout clHeaderViewLocation;

  @NonNull
  public final ConstraintLayout clSaveLocation;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final LinearLayoutCompat llSearchLocation;

  @NonNull
  public final ConstraintLayout llSearchLocationList;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvLocation;

  @NonNull
  public final SearchHeaderBinding searchHeader;

  @NonNull
  public final TextView tvLocation;

  @NonNull
  public final TextView tvNoResult;

  @NonNull
  public final TextView tvRetrySearchMessage;

  @NonNull
  public final TextView tvSaveLocation;

  @NonNull
  public final TextView tvSearchTitle;

  @NonNull
  public final View viewSaveLocation;

  @NonNull
  public final View viewSelectLocation;

  private FragmentSelectLocationBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout clHeaderViewLocation, @NonNull ConstraintLayout clSaveLocation,
      @NonNull ImageView ivBack, @NonNull LinearLayoutCompat llSearchLocation,
      @NonNull ConstraintLayout llSearchLocationList, @NonNull ProgressBar progressbar,
      @NonNull RecyclerView rvLocation, @NonNull SearchHeaderBinding searchHeader,
      @NonNull TextView tvLocation, @NonNull TextView tvNoResult,
      @NonNull TextView tvRetrySearchMessage, @NonNull TextView tvSaveLocation,
      @NonNull TextView tvSearchTitle, @NonNull View viewSaveLocation,
      @NonNull View viewSelectLocation) {
    this.rootView = rootView;
    this.clHeaderViewLocation = clHeaderViewLocation;
    this.clSaveLocation = clSaveLocation;
    this.ivBack = ivBack;
    this.llSearchLocation = llSearchLocation;
    this.llSearchLocationList = llSearchLocationList;
    this.progressbar = progressbar;
    this.rvLocation = rvLocation;
    this.searchHeader = searchHeader;
    this.tvLocation = tvLocation;
    this.tvNoResult = tvNoResult;
    this.tvRetrySearchMessage = tvRetrySearchMessage;
    this.tvSaveLocation = tvSaveLocation;
    this.tvSearchTitle = tvSearchTitle;
    this.viewSaveLocation = viewSaveLocation;
    this.viewSelectLocation = viewSelectLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSelectLocationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSelectLocationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_select_location, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSelectLocationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clHeaderViewLocation;
      ConstraintLayout clHeaderViewLocation = ViewBindings.findChildViewById(rootView, id);
      if (clHeaderViewLocation == null) {
        break missingId;
      }

      id = R.id.clSaveLocation;
      ConstraintLayout clSaveLocation = ViewBindings.findChildViewById(rootView, id);
      if (clSaveLocation == null) {
        break missingId;
      }

      id = R.id.ivBack;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.llSearchLocation;
      LinearLayoutCompat llSearchLocation = ViewBindings.findChildViewById(rootView, id);
      if (llSearchLocation == null) {
        break missingId;
      }

      id = R.id.llSearchLocationList;
      ConstraintLayout llSearchLocationList = ViewBindings.findChildViewById(rootView, id);
      if (llSearchLocationList == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvLocation;
      RecyclerView rvLocation = ViewBindings.findChildViewById(rootView, id);
      if (rvLocation == null) {
        break missingId;
      }

      id = R.id.searchHeader;
      View searchHeader = ViewBindings.findChildViewById(rootView, id);
      if (searchHeader == null) {
        break missingId;
      }
      SearchHeaderBinding binding_searchHeader = SearchHeaderBinding.bind(searchHeader);

      id = R.id.tv_location;
      TextView tvLocation = ViewBindings.findChildViewById(rootView, id);
      if (tvLocation == null) {
        break missingId;
      }

      id = R.id.tvNoResult;
      TextView tvNoResult = ViewBindings.findChildViewById(rootView, id);
      if (tvNoResult == null) {
        break missingId;
      }

      id = R.id.tvRetrySearchMessage;
      TextView tvRetrySearchMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvRetrySearchMessage == null) {
        break missingId;
      }

      id = R.id.tvSaveLocation;
      TextView tvSaveLocation = ViewBindings.findChildViewById(rootView, id);
      if (tvSaveLocation == null) {
        break missingId;
      }

      id = R.id.tvSearchTitle;
      TextView tvSearchTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvSearchTitle == null) {
        break missingId;
      }

      id = R.id.viewSaveLocation;
      View viewSaveLocation = ViewBindings.findChildViewById(rootView, id);
      if (viewSaveLocation == null) {
        break missingId;
      }

      id = R.id.viewSelectLocation;
      View viewSelectLocation = ViewBindings.findChildViewById(rootView, id);
      if (viewSelectLocation == null) {
        break missingId;
      }

      return new FragmentSelectLocationBinding((ConstraintLayout) rootView, clHeaderViewLocation,
          clSaveLocation, ivBack, llSearchLocation, llSearchLocationList, progressbar, rvLocation,
          binding_searchHeader, tvLocation, tvNoResult, tvRetrySearchMessage, tvSaveLocation,
          tvSearchTitle, viewSaveLocation, viewSelectLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
