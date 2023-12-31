// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentKeywordSearchResuktsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView bothDiameter;

  @NonNull
  public final CoordinatorLayout clView;

  @NonNull
  public final AppBarLayout collapsScreen;

  @NonNull
  public final ImageView ellipseRedGarage;

  @NonNull
  public final ImageView ellipseRedGarageFilter;

  @NonNull
  public final TextView ivCVActive;

  @NonNull
  public final TextView ivCVInactive;

  @NonNull
  public final ImageView ivFilter;

  @NonNull
  public final ImageView ivSorting;

  @NonNull
  public final TextView noResultTv1;

  @NonNull
  public final TextView noResultTv2;

  @NonNull
  public final TextView oeSize;

  @NonNull
  public final VehicleResultListLayoutBinding placeHolderList;

  @NonNull
  public final TextView position;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvKeyWordResult;

  @NonNull
  public final ImageButton startNewSearch;

  @NonNull
  public final TextView suspensionValue;

  @NonNull
  public final TextView tvApprovalNumbers;

  @NonNull
  public final TextView tvApprovalNumbersFilter;

  @NonNull
  public final TextView tvLocal;

  @NonNull
  public final TextView tvLocalPlus;

  @NonNull
  public final TextView tvModel;

  @NonNull
  public final TextView tvNumofResults;

  @NonNull
  public final FrameLayout vehicleTopList;

  private FragmentKeywordSearchResuktsBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView bothDiameter, @NonNull CoordinatorLayout clView,
      @NonNull AppBarLayout collapsScreen, @NonNull ImageView ellipseRedGarage,
      @NonNull ImageView ellipseRedGarageFilter, @NonNull TextView ivCVActive,
      @NonNull TextView ivCVInactive, @NonNull ImageView ivFilter, @NonNull ImageView ivSorting,
      @NonNull TextView noResultTv1, @NonNull TextView noResultTv2, @NonNull TextView oeSize,
      @NonNull VehicleResultListLayoutBinding placeHolderList, @NonNull TextView position,
      @NonNull ProgressBar progressbar, @NonNull RecyclerView rvKeyWordResult,
      @NonNull ImageButton startNewSearch, @NonNull TextView suspensionValue,
      @NonNull TextView tvApprovalNumbers, @NonNull TextView tvApprovalNumbersFilter,
      @NonNull TextView tvLocal, @NonNull TextView tvLocalPlus, @NonNull TextView tvModel,
      @NonNull TextView tvNumofResults, @NonNull FrameLayout vehicleTopList) {
    this.rootView = rootView;
    this.bothDiameter = bothDiameter;
    this.clView = clView;
    this.collapsScreen = collapsScreen;
    this.ellipseRedGarage = ellipseRedGarage;
    this.ellipseRedGarageFilter = ellipseRedGarageFilter;
    this.ivCVActive = ivCVActive;
    this.ivCVInactive = ivCVInactive;
    this.ivFilter = ivFilter;
    this.ivSorting = ivSorting;
    this.noResultTv1 = noResultTv1;
    this.noResultTv2 = noResultTv2;
    this.oeSize = oeSize;
    this.placeHolderList = placeHolderList;
    this.position = position;
    this.progressbar = progressbar;
    this.rvKeyWordResult = rvKeyWordResult;
    this.startNewSearch = startNewSearch;
    this.suspensionValue = suspensionValue;
    this.tvApprovalNumbers = tvApprovalNumbers;
    this.tvApprovalNumbersFilter = tvApprovalNumbersFilter;
    this.tvLocal = tvLocal;
    this.tvLocalPlus = tvLocalPlus;
    this.tvModel = tvModel;
    this.tvNumofResults = tvNumofResults;
    this.vehicleTopList = vehicleTopList;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentKeywordSearchResuktsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentKeywordSearchResuktsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_keyword_search_resukts, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentKeywordSearchResuktsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bothDiameter;
      TextView bothDiameter = ViewBindings.findChildViewById(rootView, id);
      if (bothDiameter == null) {
        break missingId;
      }

      id = R.id.clView;
      CoordinatorLayout clView = ViewBindings.findChildViewById(rootView, id);
      if (clView == null) {
        break missingId;
      }

      id = R.id.collapsScreen;
      AppBarLayout collapsScreen = ViewBindings.findChildViewById(rootView, id);
      if (collapsScreen == null) {
        break missingId;
      }

      id = R.id.ellipse_red_garage;
      ImageView ellipseRedGarage = ViewBindings.findChildViewById(rootView, id);
      if (ellipseRedGarage == null) {
        break missingId;
      }

      id = R.id.ellipse_red_garage_filter;
      ImageView ellipseRedGarageFilter = ViewBindings.findChildViewById(rootView, id);
      if (ellipseRedGarageFilter == null) {
        break missingId;
      }

      id = R.id.ivCVActive;
      TextView ivCVActive = ViewBindings.findChildViewById(rootView, id);
      if (ivCVActive == null) {
        break missingId;
      }

      id = R.id.ivCVInactive;
      TextView ivCVInactive = ViewBindings.findChildViewById(rootView, id);
      if (ivCVInactive == null) {
        break missingId;
      }

      id = R.id.ivFilter;
      ImageView ivFilter = ViewBindings.findChildViewById(rootView, id);
      if (ivFilter == null) {
        break missingId;
      }

      id = R.id.ivSorting;
      ImageView ivSorting = ViewBindings.findChildViewById(rootView, id);
      if (ivSorting == null) {
        break missingId;
      }

      id = R.id.noResultTv1;
      TextView noResultTv1 = ViewBindings.findChildViewById(rootView, id);
      if (noResultTv1 == null) {
        break missingId;
      }

      id = R.id.noResultTv2;
      TextView noResultTv2 = ViewBindings.findChildViewById(rootView, id);
      if (noResultTv2 == null) {
        break missingId;
      }

      id = R.id.oeSize;
      TextView oeSize = ViewBindings.findChildViewById(rootView, id);
      if (oeSize == null) {
        break missingId;
      }

      id = R.id.placeHolderList;
      View placeHolderList = ViewBindings.findChildViewById(rootView, id);
      if (placeHolderList == null) {
        break missingId;
      }
      VehicleResultListLayoutBinding binding_placeHolderList = VehicleResultListLayoutBinding.bind(placeHolderList);

      id = R.id.position;
      TextView position = ViewBindings.findChildViewById(rootView, id);
      if (position == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvKeyWordResult;
      RecyclerView rvKeyWordResult = ViewBindings.findChildViewById(rootView, id);
      if (rvKeyWordResult == null) {
        break missingId;
      }

      id = R.id.startNewSearch;
      ImageButton startNewSearch = ViewBindings.findChildViewById(rootView, id);
      if (startNewSearch == null) {
        break missingId;
      }

      id = R.id.suspensionValue;
      TextView suspensionValue = ViewBindings.findChildViewById(rootView, id);
      if (suspensionValue == null) {
        break missingId;
      }

      id = R.id.tv_approval_numbers;
      TextView tvApprovalNumbers = ViewBindings.findChildViewById(rootView, id);
      if (tvApprovalNumbers == null) {
        break missingId;
      }

      id = R.id.tv_approval_numbers_filter;
      TextView tvApprovalNumbersFilter = ViewBindings.findChildViewById(rootView, id);
      if (tvApprovalNumbersFilter == null) {
        break missingId;
      }

      id = R.id.tvLocal;
      TextView tvLocal = ViewBindings.findChildViewById(rootView, id);
      if (tvLocal == null) {
        break missingId;
      }

      id = R.id.tvLocalPlus;
      TextView tvLocalPlus = ViewBindings.findChildViewById(rootView, id);
      if (tvLocalPlus == null) {
        break missingId;
      }

      id = R.id.tvModel;
      TextView tvModel = ViewBindings.findChildViewById(rootView, id);
      if (tvModel == null) {
        break missingId;
      }

      id = R.id.tvNumofResults;
      TextView tvNumofResults = ViewBindings.findChildViewById(rootView, id);
      if (tvNumofResults == null) {
        break missingId;
      }

      id = R.id.vehicleTopList;
      FrameLayout vehicleTopList = ViewBindings.findChildViewById(rootView, id);
      if (vehicleTopList == null) {
        break missingId;
      }

      return new FragmentKeywordSearchResuktsBinding((ConstraintLayout) rootView, bothDiameter,
          clView, collapsScreen, ellipseRedGarage, ellipseRedGarageFilter, ivCVActive, ivCVInactive,
          ivFilter, ivSorting, noResultTv1, noResultTv2, oeSize, binding_placeHolderList, position,
          progressbar, rvKeyWordResult, startNewSearch, suspensionValue, tvApprovalNumbers,
          tvApprovalNumbersFilter, tvLocal, tvLocalPlus, tvModel, tvNumofResults, vehicleTopList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
