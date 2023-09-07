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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MylistSortingBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView closeDialog;

  @NonNull
  public final View headerBorder;

  @NonNull
  public final RadioButton rbAtoZ;

  @NonNull
  public final RadioButton rbHighToLow;

  @NonNull
  public final RadioButton rbLowToHigh;

  @NonNull
  public final RadioButton rbZtoA;

  @NonNull
  public final RadioGroup rgListName;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView tvClearAll;

  @NonNull
  public final TextView tvListName;

  @NonNull
  public final TextView tvTotalItems;

  private MylistSortingBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView closeDialog,
      @NonNull View headerBorder, @NonNull RadioButton rbAtoZ, @NonNull RadioButton rbHighToLow,
      @NonNull RadioButton rbLowToHigh, @NonNull RadioButton rbZtoA, @NonNull RadioGroup rgListName,
      @NonNull TextView title, @NonNull TextView tvClearAll, @NonNull TextView tvListName,
      @NonNull TextView tvTotalItems) {
    this.rootView = rootView;
    this.closeDialog = closeDialog;
    this.headerBorder = headerBorder;
    this.rbAtoZ = rbAtoZ;
    this.rbHighToLow = rbHighToLow;
    this.rbLowToHigh = rbLowToHigh;
    this.rbZtoA = rbZtoA;
    this.rgListName = rgListName;
    this.title = title;
    this.tvClearAll = tvClearAll;
    this.tvListName = tvListName;
    this.tvTotalItems = tvTotalItems;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MylistSortingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MylistSortingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.mylist_sorting, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MylistSortingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.closeDialog;
      ImageView closeDialog = ViewBindings.findChildViewById(rootView, id);
      if (closeDialog == null) {
        break missingId;
      }

      id = R.id.headerBorder;
      View headerBorder = ViewBindings.findChildViewById(rootView, id);
      if (headerBorder == null) {
        break missingId;
      }

      id = R.id.rbAtoZ;
      RadioButton rbAtoZ = ViewBindings.findChildViewById(rootView, id);
      if (rbAtoZ == null) {
        break missingId;
      }

      id = R.id.rbHighToLow;
      RadioButton rbHighToLow = ViewBindings.findChildViewById(rootView, id);
      if (rbHighToLow == null) {
        break missingId;
      }

      id = R.id.rbLowToHigh;
      RadioButton rbLowToHigh = ViewBindings.findChildViewById(rootView, id);
      if (rbLowToHigh == null) {
        break missingId;
      }

      id = R.id.rbZtoA;
      RadioButton rbZtoA = ViewBindings.findChildViewById(rootView, id);
      if (rbZtoA == null) {
        break missingId;
      }

      id = R.id.rgListName;
      RadioGroup rgListName = ViewBindings.findChildViewById(rootView, id);
      if (rgListName == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.tvClearAll;
      TextView tvClearAll = ViewBindings.findChildViewById(rootView, id);
      if (tvClearAll == null) {
        break missingId;
      }

      id = R.id.tvListName;
      TextView tvListName = ViewBindings.findChildViewById(rootView, id);
      if (tvListName == null) {
        break missingId;
      }

      id = R.id.tvTotalItems;
      TextView tvTotalItems = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalItems == null) {
        break missingId;
      }

      return new MylistSortingBinding((ConstraintLayout) rootView, closeDialog, headerBorder,
          rbAtoZ, rbHighToLow, rbLowToHigh, rbZtoA, rgListName, title, tvClearAll, tvListName,
          tvTotalItems);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
