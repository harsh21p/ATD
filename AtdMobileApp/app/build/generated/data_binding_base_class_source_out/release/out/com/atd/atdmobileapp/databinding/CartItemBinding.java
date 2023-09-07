// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CartItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ConstraintLayout clEditQuantity;

  @NonNull
  public final ImageView ivDelete;

  @NonNull
  public final ImageView ivProduct;

  @NonNull
  public final ImageView ivRightArrow;

  @NonNull
  public final View separator;

  @NonNull
  public final TextView tvBrand;

  @NonNull
  public final TextView tvCost;

  @NonNull
  public final TextView tvCostValue;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvDiscontinued;

  @NonNull
  public final TextView tvEditQuantityAndDelivery;

  @NonNull
  public final TextView tvFret;

  @NonNull
  public final TextView tvItemSubTotal;

  @NonNull
  public final TextView tvItemSubTotalValue;

  @NonNull
  public final TextView tvQuantity;

  @NonNull
  public final TextView tvQuantityValue;

  @NonNull
  public final TextView tvStyle;

  private CartItemBinding(@NonNull CardView rootView, @NonNull ConstraintLayout clEditQuantity,
      @NonNull ImageView ivDelete, @NonNull ImageView ivProduct, @NonNull ImageView ivRightArrow,
      @NonNull View separator, @NonNull TextView tvBrand, @NonNull TextView tvCost,
      @NonNull TextView tvCostValue, @NonNull TextView tvDescription,
      @NonNull TextView tvDiscontinued, @NonNull TextView tvEditQuantityAndDelivery,
      @NonNull TextView tvFret, @NonNull TextView tvItemSubTotal,
      @NonNull TextView tvItemSubTotalValue, @NonNull TextView tvQuantity,
      @NonNull TextView tvQuantityValue, @NonNull TextView tvStyle) {
    this.rootView = rootView;
    this.clEditQuantity = clEditQuantity;
    this.ivDelete = ivDelete;
    this.ivProduct = ivProduct;
    this.ivRightArrow = ivRightArrow;
    this.separator = separator;
    this.tvBrand = tvBrand;
    this.tvCost = tvCost;
    this.tvCostValue = tvCostValue;
    this.tvDescription = tvDescription;
    this.tvDiscontinued = tvDiscontinued;
    this.tvEditQuantityAndDelivery = tvEditQuantityAndDelivery;
    this.tvFret = tvFret;
    this.tvItemSubTotal = tvItemSubTotal;
    this.tvItemSubTotalValue = tvItemSubTotalValue;
    this.tvQuantity = tvQuantity;
    this.tvQuantityValue = tvQuantityValue;
    this.tvStyle = tvStyle;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CartItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CartItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.cart_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CartItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clEditQuantity;
      ConstraintLayout clEditQuantity = ViewBindings.findChildViewById(rootView, id);
      if (clEditQuantity == null) {
        break missingId;
      }

      id = R.id.ivDelete;
      ImageView ivDelete = ViewBindings.findChildViewById(rootView, id);
      if (ivDelete == null) {
        break missingId;
      }

      id = R.id.ivProduct;
      ImageView ivProduct = ViewBindings.findChildViewById(rootView, id);
      if (ivProduct == null) {
        break missingId;
      }

      id = R.id.ivRightArrow;
      ImageView ivRightArrow = ViewBindings.findChildViewById(rootView, id);
      if (ivRightArrow == null) {
        break missingId;
      }

      id = R.id.separator;
      View separator = ViewBindings.findChildViewById(rootView, id);
      if (separator == null) {
        break missingId;
      }

      id = R.id.tvBrand;
      TextView tvBrand = ViewBindings.findChildViewById(rootView, id);
      if (tvBrand == null) {
        break missingId;
      }

      id = R.id.tvCost;
      TextView tvCost = ViewBindings.findChildViewById(rootView, id);
      if (tvCost == null) {
        break missingId;
      }

      id = R.id.tvCostValue;
      TextView tvCostValue = ViewBindings.findChildViewById(rootView, id);
      if (tvCostValue == null) {
        break missingId;
      }

      id = R.id.tvDescription;
      TextView tvDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDescription == null) {
        break missingId;
      }

      id = R.id.tvDiscontinued;
      TextView tvDiscontinued = ViewBindings.findChildViewById(rootView, id);
      if (tvDiscontinued == null) {
        break missingId;
      }

      id = R.id.tvEditQuantityAndDelivery;
      TextView tvEditQuantityAndDelivery = ViewBindings.findChildViewById(rootView, id);
      if (tvEditQuantityAndDelivery == null) {
        break missingId;
      }

      id = R.id.tvFret;
      TextView tvFret = ViewBindings.findChildViewById(rootView, id);
      if (tvFret == null) {
        break missingId;
      }

      id = R.id.tvItemSubTotal;
      TextView tvItemSubTotal = ViewBindings.findChildViewById(rootView, id);
      if (tvItemSubTotal == null) {
        break missingId;
      }

      id = R.id.tvItemSubTotalValue;
      TextView tvItemSubTotalValue = ViewBindings.findChildViewById(rootView, id);
      if (tvItemSubTotalValue == null) {
        break missingId;
      }

      id = R.id.tvQuantity;
      TextView tvQuantity = ViewBindings.findChildViewById(rootView, id);
      if (tvQuantity == null) {
        break missingId;
      }

      id = R.id.tvQuantityValue;
      TextView tvQuantityValue = ViewBindings.findChildViewById(rootView, id);
      if (tvQuantityValue == null) {
        break missingId;
      }

      id = R.id.tvStyle;
      TextView tvStyle = ViewBindings.findChildViewById(rootView, id);
      if (tvStyle == null) {
        break missingId;
      }

      return new CartItemBinding((CardView) rootView, clEditQuantity, ivDelete, ivProduct,
          ivRightArrow, separator, tvBrand, tvCost, tvCostValue, tvDescription, tvDiscontinued,
          tvEditQuantityAndDelivery, tvFret, tvItemSubTotal, tvItemSubTotalValue, tvQuantity,
          tvQuantityValue, tvStyle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}