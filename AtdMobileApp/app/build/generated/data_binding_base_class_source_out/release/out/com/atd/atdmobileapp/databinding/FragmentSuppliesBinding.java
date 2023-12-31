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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSuppliesBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProductSearchFooterBinding bottomButtons;

  @NonNull
  public final FrameLayout forFooter;

  @NonNull
  public final ImageView suppliesBrandDropMenu;

  @NonNull
  public final ImageView suppliesDropMenu;

  @NonNull
  public final TextView suppliesType;

  @NonNull
  public final TextView suppliesatdPartNumber;

  @NonNull
  public final EditText suppliesatdPartNumberHint;

  @NonNull
  public final TextView suppliesbrands;

  @NonNull
  public final TextView suppliesbrandsHint;

  @NonNull
  public final EditText suppliessupplierHint;

  @NonNull
  public final TextView suppliessupplierName;

  @NonNull
  public final TextView suppliestvInst;

  @NonNull
  public final View suppliesviewDivider2;

  @NonNull
  public final View suppliesviewDivider4;

  @NonNull
  public final View suppliesviewDivider7;

  @NonNull
  public final View suppliesviewDivider8;

  @NonNull
  public final TextView tvsuppliesType;

  private FragmentSuppliesBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProductSearchFooterBinding bottomButtons, @NonNull FrameLayout forFooter,
      @NonNull ImageView suppliesBrandDropMenu, @NonNull ImageView suppliesDropMenu,
      @NonNull TextView suppliesType, @NonNull TextView suppliesatdPartNumber,
      @NonNull EditText suppliesatdPartNumberHint, @NonNull TextView suppliesbrands,
      @NonNull TextView suppliesbrandsHint, @NonNull EditText suppliessupplierHint,
      @NonNull TextView suppliessupplierName, @NonNull TextView suppliestvInst,
      @NonNull View suppliesviewDivider2, @NonNull View suppliesviewDivider4,
      @NonNull View suppliesviewDivider7, @NonNull View suppliesviewDivider8,
      @NonNull TextView tvsuppliesType) {
    this.rootView = rootView;
    this.bottomButtons = bottomButtons;
    this.forFooter = forFooter;
    this.suppliesBrandDropMenu = suppliesBrandDropMenu;
    this.suppliesDropMenu = suppliesDropMenu;
    this.suppliesType = suppliesType;
    this.suppliesatdPartNumber = suppliesatdPartNumber;
    this.suppliesatdPartNumberHint = suppliesatdPartNumberHint;
    this.suppliesbrands = suppliesbrands;
    this.suppliesbrandsHint = suppliesbrandsHint;
    this.suppliessupplierHint = suppliessupplierHint;
    this.suppliessupplierName = suppliessupplierName;
    this.suppliestvInst = suppliestvInst;
    this.suppliesviewDivider2 = suppliesviewDivider2;
    this.suppliesviewDivider4 = suppliesviewDivider4;
    this.suppliesviewDivider7 = suppliesviewDivider7;
    this.suppliesviewDivider8 = suppliesviewDivider8;
    this.tvsuppliesType = tvsuppliesType;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSuppliesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSuppliesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_supplies, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSuppliesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomButtons;
      View bottomButtons = ViewBindings.findChildViewById(rootView, id);
      if (bottomButtons == null) {
        break missingId;
      }
      ProductSearchFooterBinding binding_bottomButtons = ProductSearchFooterBinding.bind(bottomButtons);

      id = R.id.forFooter;
      FrameLayout forFooter = ViewBindings.findChildViewById(rootView, id);
      if (forFooter == null) {
        break missingId;
      }

      id = R.id.suppliesBrandDropMenu;
      ImageView suppliesBrandDropMenu = ViewBindings.findChildViewById(rootView, id);
      if (suppliesBrandDropMenu == null) {
        break missingId;
      }

      id = R.id.suppliesDropMenu;
      ImageView suppliesDropMenu = ViewBindings.findChildViewById(rootView, id);
      if (suppliesDropMenu == null) {
        break missingId;
      }

      id = R.id.suppliesType;
      TextView suppliesType = ViewBindings.findChildViewById(rootView, id);
      if (suppliesType == null) {
        break missingId;
      }

      id = R.id.suppliesatdPartNumber;
      TextView suppliesatdPartNumber = ViewBindings.findChildViewById(rootView, id);
      if (suppliesatdPartNumber == null) {
        break missingId;
      }

      id = R.id.suppliesatdPartNumberHint;
      EditText suppliesatdPartNumberHint = ViewBindings.findChildViewById(rootView, id);
      if (suppliesatdPartNumberHint == null) {
        break missingId;
      }

      id = R.id.suppliesbrands;
      TextView suppliesbrands = ViewBindings.findChildViewById(rootView, id);
      if (suppliesbrands == null) {
        break missingId;
      }

      id = R.id.suppliesbrandsHint;
      TextView suppliesbrandsHint = ViewBindings.findChildViewById(rootView, id);
      if (suppliesbrandsHint == null) {
        break missingId;
      }

      id = R.id.suppliessupplierHint;
      EditText suppliessupplierHint = ViewBindings.findChildViewById(rootView, id);
      if (suppliessupplierHint == null) {
        break missingId;
      }

      id = R.id.suppliessupplierName;
      TextView suppliessupplierName = ViewBindings.findChildViewById(rootView, id);
      if (suppliessupplierName == null) {
        break missingId;
      }

      id = R.id.suppliestvInst;
      TextView suppliestvInst = ViewBindings.findChildViewById(rootView, id);
      if (suppliestvInst == null) {
        break missingId;
      }

      id = R.id.suppliesviewDivider2;
      View suppliesviewDivider2 = ViewBindings.findChildViewById(rootView, id);
      if (suppliesviewDivider2 == null) {
        break missingId;
      }

      id = R.id.suppliesviewDivider4;
      View suppliesviewDivider4 = ViewBindings.findChildViewById(rootView, id);
      if (suppliesviewDivider4 == null) {
        break missingId;
      }

      id = R.id.suppliesviewDivider7;
      View suppliesviewDivider7 = ViewBindings.findChildViewById(rootView, id);
      if (suppliesviewDivider7 == null) {
        break missingId;
      }

      id = R.id.suppliesviewDivider8;
      View suppliesviewDivider8 = ViewBindings.findChildViewById(rootView, id);
      if (suppliesviewDivider8 == null) {
        break missingId;
      }

      id = R.id.tvsuppliesType;
      TextView tvsuppliesType = ViewBindings.findChildViewById(rootView, id);
      if (tvsuppliesType == null) {
        break missingId;
      }

      return new FragmentSuppliesBinding((ConstraintLayout) rootView, binding_bottomButtons,
          forFooter, suppliesBrandDropMenu, suppliesDropMenu, suppliesType, suppliesatdPartNumber,
          suppliesatdPartNumberHint, suppliesbrands, suppliesbrandsHint, suppliessupplierHint,
          suppliessupplierName, suppliestvInst, suppliesviewDivider2, suppliesviewDivider4,
          suppliesviewDivider7, suppliesviewDivider8, tvsuppliesType);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
