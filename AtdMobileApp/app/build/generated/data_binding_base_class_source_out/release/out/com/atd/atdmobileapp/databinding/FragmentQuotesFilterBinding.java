// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
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

public final class FragmentQuotesFilterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ellipseRedGarage;

  @NonNull
  public final ImageView ellipseRedGarageLastModified;

  @NonNull
  public final DateSelectLayoutBinding endDate;

  @NonNull
  public final RelativeLayout expandableLayoutLastModified;

  @NonNull
  public final RelativeLayout expandableLayoutStatus;

  @NonNull
  public final ImageButton filterApply;

  @NonNull
  public final FrameLayout forBottom;

  @NonNull
  public final ImageView ivClose;

  @NonNull
  public final ImageView ivLast24Hours;

  @NonNull
  public final ImageView ivLast30days;

  @NonNull
  public final ImageView ivLast7days;

  @NonNull
  public final ImageView ivLastModified;

  @NonNull
  public final ImageView ivNone;

  @NonNull
  public final ImageView ivSpecifyDateRange;

  @NonNull
  public final ImageView ivStatus;

  @NonNull
  public final LinearLayoutCompat llBrandsHeader;

  @NonNull
  public final LinearLayoutCompat llLastMOdified;

  @NonNull
  public final LinearLayoutCompat llStatus;

  @NonNull
  public final RecyclerView rvStatus;

  @NonNull
  public final DateSelectLayoutBinding startDate;

  @NonNull
  public final ConstraintLayout touchFor24Hours;

  @NonNull
  public final ConstraintLayout touchForLast30Days;

  @NonNull
  public final ConstraintLayout touchForLastModified;

  @NonNull
  public final ConstraintLayout touchForNone;

  @NonNull
  public final ConstraintLayout touchForSpecifyDate;

  @NonNull
  public final ConstraintLayout touchLast7Days;

  @NonNull
  public final TextView tvApprovalNumbers;

  @NonNull
  public final TextView tvApprovalNumbersLastModified;

  @NonNull
  public final TextView tvBrands;

  @NonNull
  public final TextView tvClearAll;

  @NonNull
  public final TextView tvLastModified;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final View view;

  @NonNull
  public final View view1;

  @NonNull
  public final View viewDivider2;

  @NonNull
  public final View viewSelectLocation;

  private FragmentQuotesFilterBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView ellipseRedGarage, @NonNull ImageView ellipseRedGarageLastModified,
      @NonNull DateSelectLayoutBinding endDate,
      @NonNull RelativeLayout expandableLayoutLastModified,
      @NonNull RelativeLayout expandableLayoutStatus, @NonNull ImageButton filterApply,
      @NonNull FrameLayout forBottom, @NonNull ImageView ivClose, @NonNull ImageView ivLast24Hours,
      @NonNull ImageView ivLast30days, @NonNull ImageView ivLast7days,
      @NonNull ImageView ivLastModified, @NonNull ImageView ivNone,
      @NonNull ImageView ivSpecifyDateRange, @NonNull ImageView ivStatus,
      @NonNull LinearLayoutCompat llBrandsHeader, @NonNull LinearLayoutCompat llLastMOdified,
      @NonNull LinearLayoutCompat llStatus, @NonNull RecyclerView rvStatus,
      @NonNull DateSelectLayoutBinding startDate, @NonNull ConstraintLayout touchFor24Hours,
      @NonNull ConstraintLayout touchForLast30Days, @NonNull ConstraintLayout touchForLastModified,
      @NonNull ConstraintLayout touchForNone, @NonNull ConstraintLayout touchForSpecifyDate,
      @NonNull ConstraintLayout touchLast7Days, @NonNull TextView tvApprovalNumbers,
      @NonNull TextView tvApprovalNumbersLastModified, @NonNull TextView tvBrands,
      @NonNull TextView tvClearAll, @NonNull TextView tvLastModified, @NonNull TextView tvStatus,
      @NonNull View view, @NonNull View view1, @NonNull View viewDivider2,
      @NonNull View viewSelectLocation) {
    this.rootView = rootView;
    this.ellipseRedGarage = ellipseRedGarage;
    this.ellipseRedGarageLastModified = ellipseRedGarageLastModified;
    this.endDate = endDate;
    this.expandableLayoutLastModified = expandableLayoutLastModified;
    this.expandableLayoutStatus = expandableLayoutStatus;
    this.filterApply = filterApply;
    this.forBottom = forBottom;
    this.ivClose = ivClose;
    this.ivLast24Hours = ivLast24Hours;
    this.ivLast30days = ivLast30days;
    this.ivLast7days = ivLast7days;
    this.ivLastModified = ivLastModified;
    this.ivNone = ivNone;
    this.ivSpecifyDateRange = ivSpecifyDateRange;
    this.ivStatus = ivStatus;
    this.llBrandsHeader = llBrandsHeader;
    this.llLastMOdified = llLastMOdified;
    this.llStatus = llStatus;
    this.rvStatus = rvStatus;
    this.startDate = startDate;
    this.touchFor24Hours = touchFor24Hours;
    this.touchForLast30Days = touchForLast30Days;
    this.touchForLastModified = touchForLastModified;
    this.touchForNone = touchForNone;
    this.touchForSpecifyDate = touchForSpecifyDate;
    this.touchLast7Days = touchLast7Days;
    this.tvApprovalNumbers = tvApprovalNumbers;
    this.tvApprovalNumbersLastModified = tvApprovalNumbersLastModified;
    this.tvBrands = tvBrands;
    this.tvClearAll = tvClearAll;
    this.tvLastModified = tvLastModified;
    this.tvStatus = tvStatus;
    this.view = view;
    this.view1 = view1;
    this.viewDivider2 = viewDivider2;
    this.viewSelectLocation = viewSelectLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentQuotesFilterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentQuotesFilterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_quotes_filter, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentQuotesFilterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ellipse_red_garage;
      ImageView ellipseRedGarage = ViewBindings.findChildViewById(rootView, id);
      if (ellipseRedGarage == null) {
        break missingId;
      }

      id = R.id.ellipse_red_garage_last_modified;
      ImageView ellipseRedGarageLastModified = ViewBindings.findChildViewById(rootView, id);
      if (ellipseRedGarageLastModified == null) {
        break missingId;
      }

      id = R.id.endDate;
      View endDate = ViewBindings.findChildViewById(rootView, id);
      if (endDate == null) {
        break missingId;
      }
      DateSelectLayoutBinding binding_endDate = DateSelectLayoutBinding.bind(endDate);

      id = R.id.expandableLayoutLastModified;
      RelativeLayout expandableLayoutLastModified = ViewBindings.findChildViewById(rootView, id);
      if (expandableLayoutLastModified == null) {
        break missingId;
      }

      id = R.id.expandableLayoutStatus;
      RelativeLayout expandableLayoutStatus = ViewBindings.findChildViewById(rootView, id);
      if (expandableLayoutStatus == null) {
        break missingId;
      }

      id = R.id.filterApply;
      ImageButton filterApply = ViewBindings.findChildViewById(rootView, id);
      if (filterApply == null) {
        break missingId;
      }

      id = R.id.forBottom;
      FrameLayout forBottom = ViewBindings.findChildViewById(rootView, id);
      if (forBottom == null) {
        break missingId;
      }

      id = R.id.ivClose;
      ImageView ivClose = ViewBindings.findChildViewById(rootView, id);
      if (ivClose == null) {
        break missingId;
      }

      id = R.id.ivLast24Hours;
      ImageView ivLast24Hours = ViewBindings.findChildViewById(rootView, id);
      if (ivLast24Hours == null) {
        break missingId;
      }

      id = R.id.ivLast30days;
      ImageView ivLast30days = ViewBindings.findChildViewById(rootView, id);
      if (ivLast30days == null) {
        break missingId;
      }

      id = R.id.ivLast7days;
      ImageView ivLast7days = ViewBindings.findChildViewById(rootView, id);
      if (ivLast7days == null) {
        break missingId;
      }

      id = R.id.ivLastModified;
      ImageView ivLastModified = ViewBindings.findChildViewById(rootView, id);
      if (ivLastModified == null) {
        break missingId;
      }

      id = R.id.ivNone;
      ImageView ivNone = ViewBindings.findChildViewById(rootView, id);
      if (ivNone == null) {
        break missingId;
      }

      id = R.id.ivSpecifyDateRange;
      ImageView ivSpecifyDateRange = ViewBindings.findChildViewById(rootView, id);
      if (ivSpecifyDateRange == null) {
        break missingId;
      }

      id = R.id.ivStatus;
      ImageView ivStatus = ViewBindings.findChildViewById(rootView, id);
      if (ivStatus == null) {
        break missingId;
      }

      id = R.id.llBrandsHeader;
      LinearLayoutCompat llBrandsHeader = ViewBindings.findChildViewById(rootView, id);
      if (llBrandsHeader == null) {
        break missingId;
      }

      id = R.id.llLastMOdified;
      LinearLayoutCompat llLastMOdified = ViewBindings.findChildViewById(rootView, id);
      if (llLastMOdified == null) {
        break missingId;
      }

      id = R.id.llStatus;
      LinearLayoutCompat llStatus = ViewBindings.findChildViewById(rootView, id);
      if (llStatus == null) {
        break missingId;
      }

      id = R.id.rvStatus;
      RecyclerView rvStatus = ViewBindings.findChildViewById(rootView, id);
      if (rvStatus == null) {
        break missingId;
      }

      id = R.id.startDate;
      View startDate = ViewBindings.findChildViewById(rootView, id);
      if (startDate == null) {
        break missingId;
      }
      DateSelectLayoutBinding binding_startDate = DateSelectLayoutBinding.bind(startDate);

      id = R.id.touchFor24Hours;
      ConstraintLayout touchFor24Hours = ViewBindings.findChildViewById(rootView, id);
      if (touchFor24Hours == null) {
        break missingId;
      }

      id = R.id.touchForLast30Days;
      ConstraintLayout touchForLast30Days = ViewBindings.findChildViewById(rootView, id);
      if (touchForLast30Days == null) {
        break missingId;
      }

      id = R.id.touchForLastModified;
      ConstraintLayout touchForLastModified = ViewBindings.findChildViewById(rootView, id);
      if (touchForLastModified == null) {
        break missingId;
      }

      id = R.id.touchForNone;
      ConstraintLayout touchForNone = ViewBindings.findChildViewById(rootView, id);
      if (touchForNone == null) {
        break missingId;
      }

      id = R.id.touchForSpecifyDate;
      ConstraintLayout touchForSpecifyDate = ViewBindings.findChildViewById(rootView, id);
      if (touchForSpecifyDate == null) {
        break missingId;
      }

      id = R.id.touchLast7Days;
      ConstraintLayout touchLast7Days = ViewBindings.findChildViewById(rootView, id);
      if (touchLast7Days == null) {
        break missingId;
      }

      id = R.id.tv_approval_numbers;
      TextView tvApprovalNumbers = ViewBindings.findChildViewById(rootView, id);
      if (tvApprovalNumbers == null) {
        break missingId;
      }

      id = R.id.tv_approval_numbers_last_modified;
      TextView tvApprovalNumbersLastModified = ViewBindings.findChildViewById(rootView, id);
      if (tvApprovalNumbersLastModified == null) {
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

      id = R.id.tvLastModified;
      TextView tvLastModified = ViewBindings.findChildViewById(rootView, id);
      if (tvLastModified == null) {
        break missingId;
      }

      id = R.id.tvStatus;
      TextView tvStatus = ViewBindings.findChildViewById(rootView, id);
      if (tvStatus == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      id = R.id.view1;
      View view1 = ViewBindings.findChildViewById(rootView, id);
      if (view1 == null) {
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

      return new FragmentQuotesFilterBinding((ConstraintLayout) rootView, ellipseRedGarage,
          ellipseRedGarageLastModified, binding_endDate, expandableLayoutLastModified,
          expandableLayoutStatus, filterApply, forBottom, ivClose, ivLast24Hours, ivLast30days,
          ivLast7days, ivLastModified, ivNone, ivSpecifyDateRange, ivStatus, llBrandsHeader,
          llLastMOdified, llStatus, rvStatus, binding_startDate, touchFor24Hours,
          touchForLast30Days, touchForLastModified, touchForNone, touchForSpecifyDate,
          touchLast7Days, tvApprovalNumbers, tvApprovalNumbersLastModified, tvBrands, tvClearAll,
          tvLastModified, tvStatus, view, view1, viewDivider2, viewSelectLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}