// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public final class FragmentPositionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayoutCompat diameterSelectionHeader;

  @NonNull
  public final ImageView ivCloseDiameter;

  @NonNull
  public final RadioButton radioButton;

  @NonNull
  public final RadioButton radioButton2;

  @NonNull
  public final RadioGroup tireTypeRadioGroup;

  @NonNull
  public final TextView tvBrands;

  @NonNull
  public final View viewSelectLocation;

  private FragmentPositionBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayoutCompat diameterSelectionHeader, @NonNull ImageView ivCloseDiameter,
      @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2,
      @NonNull RadioGroup tireTypeRadioGroup, @NonNull TextView tvBrands,
      @NonNull View viewSelectLocation) {
    this.rootView = rootView;
    this.diameterSelectionHeader = diameterSelectionHeader;
    this.ivCloseDiameter = ivCloseDiameter;
    this.radioButton = radioButton;
    this.radioButton2 = radioButton2;
    this.tireTypeRadioGroup = tireTypeRadioGroup;
    this.tvBrands = tvBrands;
    this.viewSelectLocation = viewSelectLocation;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPositionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPositionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_position, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPositionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.diameterSelectionHeader;
      LinearLayoutCompat diameterSelectionHeader = ViewBindings.findChildViewById(rootView, id);
      if (diameterSelectionHeader == null) {
        break missingId;
      }

      id = R.id.ivCloseDiameter;
      ImageView ivCloseDiameter = ViewBindings.findChildViewById(rootView, id);
      if (ivCloseDiameter == null) {
        break missingId;
      }

      id = R.id.radioButton;
      RadioButton radioButton = ViewBindings.findChildViewById(rootView, id);
      if (radioButton == null) {
        break missingId;
      }

      id = R.id.radioButton2;
      RadioButton radioButton2 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton2 == null) {
        break missingId;
      }

      id = R.id.tireTypeRadioGroup;
      RadioGroup tireTypeRadioGroup = ViewBindings.findChildViewById(rootView, id);
      if (tireTypeRadioGroup == null) {
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

      return new FragmentPositionBinding((ConstraintLayout) rootView, diameterSelectionHeader,
          ivCloseDiameter, radioButton, radioButton2, tireTypeRadioGroup, tvBrands,
          viewSelectLocation);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
