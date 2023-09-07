// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWheelsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView brandLabel;

  @NonNull
  public final TextView brandType;

  @NonNull
  public final TextView diameter;

  @NonNull
  public final TextView diameterLabel;

  @NonNull
  public final EditText etAtdPartNumber;

  @NonNull
  public final EditText etSupplierNumber;

  @NonNull
  public final TextView headerContent;

  @NonNull
  public final ImageView ivBrandType;

  @NonNull
  public final ImageView ivDiameter;

  @NonNull
  public final ImageView ivFinishIndicator;

  @NonNull
  public final ImageView ivLugsBolts;

  @NonNull
  public final ImageView ivOffSetDescription;

  @NonNull
  public final ImageView ivSeasonalDesignation;

  @NonNull
  public final ImageView ivWheelType;

  @NonNull
  public final ImageView ivWidthIndecator;

  @NonNull
  public final TextView tvAtdPartLabel;

  @NonNull
  public final TextView tvFinish;

  @NonNull
  public final TextView tvFinishLabel;

  @NonNull
  public final TextView tvLugsBolts;

  @NonNull
  public final TextView tvLugsBoltsLabel;

  @NonNull
  public final TextView tvOffSetDescription;

  @NonNull
  public final TextView tvOffSetDescriptionLabel;

  @NonNull
  public final TextView tvSeasonalDesignation;

  @NonNull
  public final TextView tvSeasonalDesignationLabel;

  @NonNull
  public final TextView tvSupplierNumberLabel;

  @NonNull
  public final TextView tvWidth;

  @NonNull
  public final TextView tvWidthLabel;

  @NonNull
  public final TextView wheelType;

  @NonNull
  public final TextView wheelTypeLabel;

  @NonNull
  public final ProductSearchButtonsBinding wheelsFooter;

  private FragmentWheelsBinding(@NonNull ConstraintLayout rootView, @NonNull TextView brandLabel,
      @NonNull TextView brandType, @NonNull TextView diameter, @NonNull TextView diameterLabel,
      @NonNull EditText etAtdPartNumber, @NonNull EditText etSupplierNumber,
      @NonNull TextView headerContent, @NonNull ImageView ivBrandType,
      @NonNull ImageView ivDiameter, @NonNull ImageView ivFinishIndicator,
      @NonNull ImageView ivLugsBolts, @NonNull ImageView ivOffSetDescription,
      @NonNull ImageView ivSeasonalDesignation, @NonNull ImageView ivWheelType,
      @NonNull ImageView ivWidthIndecator, @NonNull TextView tvAtdPartLabel,
      @NonNull TextView tvFinish, @NonNull TextView tvFinishLabel, @NonNull TextView tvLugsBolts,
      @NonNull TextView tvLugsBoltsLabel, @NonNull TextView tvOffSetDescription,
      @NonNull TextView tvOffSetDescriptionLabel, @NonNull TextView tvSeasonalDesignation,
      @NonNull TextView tvSeasonalDesignationLabel, @NonNull TextView tvSupplierNumberLabel,
      @NonNull TextView tvWidth, @NonNull TextView tvWidthLabel, @NonNull TextView wheelType,
      @NonNull TextView wheelTypeLabel, @NonNull ProductSearchButtonsBinding wheelsFooter) {
    this.rootView = rootView;
    this.brandLabel = brandLabel;
    this.brandType = brandType;
    this.diameter = diameter;
    this.diameterLabel = diameterLabel;
    this.etAtdPartNumber = etAtdPartNumber;
    this.etSupplierNumber = etSupplierNumber;
    this.headerContent = headerContent;
    this.ivBrandType = ivBrandType;
    this.ivDiameter = ivDiameter;
    this.ivFinishIndicator = ivFinishIndicator;
    this.ivLugsBolts = ivLugsBolts;
    this.ivOffSetDescription = ivOffSetDescription;
    this.ivSeasonalDesignation = ivSeasonalDesignation;
    this.ivWheelType = ivWheelType;
    this.ivWidthIndecator = ivWidthIndecator;
    this.tvAtdPartLabel = tvAtdPartLabel;
    this.tvFinish = tvFinish;
    this.tvFinishLabel = tvFinishLabel;
    this.tvLugsBolts = tvLugsBolts;
    this.tvLugsBoltsLabel = tvLugsBoltsLabel;
    this.tvOffSetDescription = tvOffSetDescription;
    this.tvOffSetDescriptionLabel = tvOffSetDescriptionLabel;
    this.tvSeasonalDesignation = tvSeasonalDesignation;
    this.tvSeasonalDesignationLabel = tvSeasonalDesignationLabel;
    this.tvSupplierNumberLabel = tvSupplierNumberLabel;
    this.tvWidth = tvWidth;
    this.tvWidthLabel = tvWidthLabel;
    this.wheelType = wheelType;
    this.wheelTypeLabel = wheelTypeLabel;
    this.wheelsFooter = wheelsFooter;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWheelsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWheelsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_wheels, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWheelsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.brandLabel;
      TextView brandLabel = ViewBindings.findChildViewById(rootView, id);
      if (brandLabel == null) {
        break missingId;
      }

      id = R.id.brandType;
      TextView brandType = ViewBindings.findChildViewById(rootView, id);
      if (brandType == null) {
        break missingId;
      }

      id = R.id.diameter;
      TextView diameter = ViewBindings.findChildViewById(rootView, id);
      if (diameter == null) {
        break missingId;
      }

      id = R.id.diameterLabel;
      TextView diameterLabel = ViewBindings.findChildViewById(rootView, id);
      if (diameterLabel == null) {
        break missingId;
      }

      id = R.id.etAtdPartNumber;
      EditText etAtdPartNumber = ViewBindings.findChildViewById(rootView, id);
      if (etAtdPartNumber == null) {
        break missingId;
      }

      id = R.id.etSupplierNumber;
      EditText etSupplierNumber = ViewBindings.findChildViewById(rootView, id);
      if (etSupplierNumber == null) {
        break missingId;
      }

      id = R.id.headerContent;
      TextView headerContent = ViewBindings.findChildViewById(rootView, id);
      if (headerContent == null) {
        break missingId;
      }

      id = R.id.ivBrandType;
      ImageView ivBrandType = ViewBindings.findChildViewById(rootView, id);
      if (ivBrandType == null) {
        break missingId;
      }

      id = R.id.ivDiameter;
      ImageView ivDiameter = ViewBindings.findChildViewById(rootView, id);
      if (ivDiameter == null) {
        break missingId;
      }

      id = R.id.ivFinishIndicator;
      ImageView ivFinishIndicator = ViewBindings.findChildViewById(rootView, id);
      if (ivFinishIndicator == null) {
        break missingId;
      }

      id = R.id.ivLugsBolts;
      ImageView ivLugsBolts = ViewBindings.findChildViewById(rootView, id);
      if (ivLugsBolts == null) {
        break missingId;
      }

      id = R.id.ivOffSetDescription;
      ImageView ivOffSetDescription = ViewBindings.findChildViewById(rootView, id);
      if (ivOffSetDescription == null) {
        break missingId;
      }

      id = R.id.ivSeasonalDesignation;
      ImageView ivSeasonalDesignation = ViewBindings.findChildViewById(rootView, id);
      if (ivSeasonalDesignation == null) {
        break missingId;
      }

      id = R.id.ivWheelType;
      ImageView ivWheelType = ViewBindings.findChildViewById(rootView, id);
      if (ivWheelType == null) {
        break missingId;
      }

      id = R.id.ivWidthIndecator;
      ImageView ivWidthIndecator = ViewBindings.findChildViewById(rootView, id);
      if (ivWidthIndecator == null) {
        break missingId;
      }

      id = R.id.tvAtdPartLabel;
      TextView tvAtdPartLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvAtdPartLabel == null) {
        break missingId;
      }

      id = R.id.tvFinish;
      TextView tvFinish = ViewBindings.findChildViewById(rootView, id);
      if (tvFinish == null) {
        break missingId;
      }

      id = R.id.tvFinishLabel;
      TextView tvFinishLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvFinishLabel == null) {
        break missingId;
      }

      id = R.id.tvLugsBolts;
      TextView tvLugsBolts = ViewBindings.findChildViewById(rootView, id);
      if (tvLugsBolts == null) {
        break missingId;
      }

      id = R.id.tvLugsBoltsLabel;
      TextView tvLugsBoltsLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvLugsBoltsLabel == null) {
        break missingId;
      }

      id = R.id.tvOffSetDescription;
      TextView tvOffSetDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvOffSetDescription == null) {
        break missingId;
      }

      id = R.id.tvOffSetDescriptionLabel;
      TextView tvOffSetDescriptionLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvOffSetDescriptionLabel == null) {
        break missingId;
      }

      id = R.id.tvSeasonalDesignation;
      TextView tvSeasonalDesignation = ViewBindings.findChildViewById(rootView, id);
      if (tvSeasonalDesignation == null) {
        break missingId;
      }

      id = R.id.tvSeasonalDesignationLabel;
      TextView tvSeasonalDesignationLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvSeasonalDesignationLabel == null) {
        break missingId;
      }

      id = R.id.tvSupplierNumberLabel;
      TextView tvSupplierNumberLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvSupplierNumberLabel == null) {
        break missingId;
      }

      id = R.id.tvWidth;
      TextView tvWidth = ViewBindings.findChildViewById(rootView, id);
      if (tvWidth == null) {
        break missingId;
      }

      id = R.id.tvWidthLabel;
      TextView tvWidthLabel = ViewBindings.findChildViewById(rootView, id);
      if (tvWidthLabel == null) {
        break missingId;
      }

      id = R.id.wheelType;
      TextView wheelType = ViewBindings.findChildViewById(rootView, id);
      if (wheelType == null) {
        break missingId;
      }

      id = R.id.wheelTypeLabel;
      TextView wheelTypeLabel = ViewBindings.findChildViewById(rootView, id);
      if (wheelTypeLabel == null) {
        break missingId;
      }

      id = R.id.wheelsFooter;
      View wheelsFooter = ViewBindings.findChildViewById(rootView, id);
      if (wheelsFooter == null) {
        break missingId;
      }
      ProductSearchButtonsBinding binding_wheelsFooter = ProductSearchButtonsBinding.bind(wheelsFooter);

      return new FragmentWheelsBinding((ConstraintLayout) rootView, brandLabel, brandType, diameter,
          diameterLabel, etAtdPartNumber, etSupplierNumber, headerContent, ivBrandType, ivDiameter,
          ivFinishIndicator, ivLugsBolts, ivOffSetDescription, ivSeasonalDesignation, ivWheelType,
          ivWidthIndecator, tvAtdPartLabel, tvFinish, tvFinishLabel, tvLugsBolts, tvLugsBoltsLabel,
          tvOffSetDescription, tvOffSetDescriptionLabel, tvSeasonalDesignation,
          tvSeasonalDesignationLabel, tvSupplierNumberLabel, tvWidth, tvWidthLabel, wheelType,
          wheelTypeLabel, binding_wheelsFooter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
