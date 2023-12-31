// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProductDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText QtyValu;

  @NonNull
  public final ImageView decreaseQty;

  @NonNull
  public final ImageView increaseQty;

  @NonNull
  public final ImageView iv3Peak;

  @NonNull
  public final ImageView ivBrand;

  @NonNull
  public final TextView ivCVActive;

  @NonNull
  public final TextView ivCVInactive;

  @NonNull
  public final ImageView ivHubcentric;

  @NonNull
  public final ImageView ivMrktprgm;

  @NonNull
  public final ImageView ivNewProduct;

  @NonNull
  public final ImageView ivOE;

  @NonNull
  public final ImageView ivProduct;

  @NonNull
  public final ImageView ivQuickship;

  @NonNull
  public final ImageView ivValueBuys;

  @NonNull
  public final ImageView ivWinter;

  @NonNull
  public final ImageView ivtotalAccess;

  @NonNull
  public final LinearLayout llProductCard;

  @NonNull
  public final GridLayout llProductModel;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvDimensions;

  @NonNull
  public final RecyclerView rvFinish;

  @NonNull
  public final RecyclerView rvFitment;

  @NonNull
  public final RecyclerView rvLugs;

  @NonNull
  public final RecyclerView rvPerformance;

  @NonNull
  public final RecyclerView rvPrecision;

  @NonNull
  public final RecyclerView rvProductInformation;

  @NonNull
  public final RecyclerView rvSafety;

  @NonNull
  public final RecyclerView rvSize;

  @NonNull
  public final RecyclerView rvWeather;

  @NonNull
  public final RecyclerView rvWheelHub;

  @NonNull
  public final View separator;

  @NonNull
  public final TableLayout tlProductSpecification;

  @NonNull
  public final TextView tvAddCart;

  @NonNull
  public final TextView tvAddToList;

  @NonNull
  public final TextView tvAddToQuote;

  @NonNull
  public final TextView tvCost;

  @NonNull
  public final TextView tvDimensions;

  @NonNull
  public final TextView tvFet;

  @NonNull
  public final TextView tvFinish;

  @NonNull
  public final TextView tvFitment;

  @NonNull
  public final TextView tvLocal;

  @NonNull
  public final TextView tvLocalPlus;

  @NonNull
  public final TextView tvLocalPlusValue;

  @NonNull
  public final TextView tvLocalValue;

  @NonNull
  public final TextView tvLugs;

  @NonNull
  public final TextView tvMap;

  @NonNull
  public final TextView tvNational;

  @NonNull
  public final TextView tvNationalValue;

  @NonNull
  public final TextView tvOutofTheDoor;

  @NonNull
  public final TextView tvPerformance;

  @NonNull
  public final TextView tvPrecision;

  @NonNull
  public final TextView tvProductGroup;

  @NonNull
  public final TextView tvProductInformation;

  @NonNull
  public final TextView tvProductName;

  @NonNull
  public final TextView tvRebate;

  @NonNull
  public final TextView tvRetailPrice;

  @NonNull
  public final TextView tvSafety;

  @NonNull
  public final TextView tvSidewall;

  @NonNull
  public final TextView tvSidewallValue;

  @NonNull
  public final TextView tvSize;

  @NonNull
  public final TextView tvSupplier;

  @NonNull
  public final TextView tvSupplierValue;

  @NonNull
  public final TextView tvViewMarketingPrograms;

  @NonNull
  public final TextView tvViewRebates;

  @NonNull
  public final TextView tvWarranty;

  @NonNull
  public final TextView tvWarrantyValue;

  @NonNull
  public final TextView tvWeather;

  @NonNull
  public final TextView tvWheelHub;

  @NonNull
  public final View vBackGround;

  private FragmentProductDetailsBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText QtyValu, @NonNull ImageView decreaseQty, @NonNull ImageView increaseQty,
      @NonNull ImageView iv3Peak, @NonNull ImageView ivBrand, @NonNull TextView ivCVActive,
      @NonNull TextView ivCVInactive, @NonNull ImageView ivHubcentric,
      @NonNull ImageView ivMrktprgm, @NonNull ImageView ivNewProduct, @NonNull ImageView ivOE,
      @NonNull ImageView ivProduct, @NonNull ImageView ivQuickship, @NonNull ImageView ivValueBuys,
      @NonNull ImageView ivWinter, @NonNull ImageView ivtotalAccess,
      @NonNull LinearLayout llProductCard, @NonNull GridLayout llProductModel,
      @NonNull ProgressBar progressbar, @NonNull RecyclerView rvDimensions,
      @NonNull RecyclerView rvFinish, @NonNull RecyclerView rvFitment, @NonNull RecyclerView rvLugs,
      @NonNull RecyclerView rvPerformance, @NonNull RecyclerView rvPrecision,
      @NonNull RecyclerView rvProductInformation, @NonNull RecyclerView rvSafety,
      @NonNull RecyclerView rvSize, @NonNull RecyclerView rvWeather,
      @NonNull RecyclerView rvWheelHub, @NonNull View separator,
      @NonNull TableLayout tlProductSpecification, @NonNull TextView tvAddCart,
      @NonNull TextView tvAddToList, @NonNull TextView tvAddToQuote, @NonNull TextView tvCost,
      @NonNull TextView tvDimensions, @NonNull TextView tvFet, @NonNull TextView tvFinish,
      @NonNull TextView tvFitment, @NonNull TextView tvLocal, @NonNull TextView tvLocalPlus,
      @NonNull TextView tvLocalPlusValue, @NonNull TextView tvLocalValue, @NonNull TextView tvLugs,
      @NonNull TextView tvMap, @NonNull TextView tvNational, @NonNull TextView tvNationalValue,
      @NonNull TextView tvOutofTheDoor, @NonNull TextView tvPerformance,
      @NonNull TextView tvPrecision, @NonNull TextView tvProductGroup,
      @NonNull TextView tvProductInformation, @NonNull TextView tvProductName,
      @NonNull TextView tvRebate, @NonNull TextView tvRetailPrice, @NonNull TextView tvSafety,
      @NonNull TextView tvSidewall, @NonNull TextView tvSidewallValue, @NonNull TextView tvSize,
      @NonNull TextView tvSupplier, @NonNull TextView tvSupplierValue,
      @NonNull TextView tvViewMarketingPrograms, @NonNull TextView tvViewRebates,
      @NonNull TextView tvWarranty, @NonNull TextView tvWarrantyValue, @NonNull TextView tvWeather,
      @NonNull TextView tvWheelHub, @NonNull View vBackGround) {
    this.rootView = rootView;
    this.QtyValu = QtyValu;
    this.decreaseQty = decreaseQty;
    this.increaseQty = increaseQty;
    this.iv3Peak = iv3Peak;
    this.ivBrand = ivBrand;
    this.ivCVActive = ivCVActive;
    this.ivCVInactive = ivCVInactive;
    this.ivHubcentric = ivHubcentric;
    this.ivMrktprgm = ivMrktprgm;
    this.ivNewProduct = ivNewProduct;
    this.ivOE = ivOE;
    this.ivProduct = ivProduct;
    this.ivQuickship = ivQuickship;
    this.ivValueBuys = ivValueBuys;
    this.ivWinter = ivWinter;
    this.ivtotalAccess = ivtotalAccess;
    this.llProductCard = llProductCard;
    this.llProductModel = llProductModel;
    this.progressbar = progressbar;
    this.rvDimensions = rvDimensions;
    this.rvFinish = rvFinish;
    this.rvFitment = rvFitment;
    this.rvLugs = rvLugs;
    this.rvPerformance = rvPerformance;
    this.rvPrecision = rvPrecision;
    this.rvProductInformation = rvProductInformation;
    this.rvSafety = rvSafety;
    this.rvSize = rvSize;
    this.rvWeather = rvWeather;
    this.rvWheelHub = rvWheelHub;
    this.separator = separator;
    this.tlProductSpecification = tlProductSpecification;
    this.tvAddCart = tvAddCart;
    this.tvAddToList = tvAddToList;
    this.tvAddToQuote = tvAddToQuote;
    this.tvCost = tvCost;
    this.tvDimensions = tvDimensions;
    this.tvFet = tvFet;
    this.tvFinish = tvFinish;
    this.tvFitment = tvFitment;
    this.tvLocal = tvLocal;
    this.tvLocalPlus = tvLocalPlus;
    this.tvLocalPlusValue = tvLocalPlusValue;
    this.tvLocalValue = tvLocalValue;
    this.tvLugs = tvLugs;
    this.tvMap = tvMap;
    this.tvNational = tvNational;
    this.tvNationalValue = tvNationalValue;
    this.tvOutofTheDoor = tvOutofTheDoor;
    this.tvPerformance = tvPerformance;
    this.tvPrecision = tvPrecision;
    this.tvProductGroup = tvProductGroup;
    this.tvProductInformation = tvProductInformation;
    this.tvProductName = tvProductName;
    this.tvRebate = tvRebate;
    this.tvRetailPrice = tvRetailPrice;
    this.tvSafety = tvSafety;
    this.tvSidewall = tvSidewall;
    this.tvSidewallValue = tvSidewallValue;
    this.tvSize = tvSize;
    this.tvSupplier = tvSupplier;
    this.tvSupplierValue = tvSupplierValue;
    this.tvViewMarketingPrograms = tvViewMarketingPrograms;
    this.tvViewRebates = tvViewRebates;
    this.tvWarranty = tvWarranty;
    this.tvWarrantyValue = tvWarrantyValue;
    this.tvWeather = tvWeather;
    this.tvWheelHub = tvWheelHub;
    this.vBackGround = vBackGround;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProductDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProductDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_product_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProductDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.QtyValu;
      EditText QtyValu = ViewBindings.findChildViewById(rootView, id);
      if (QtyValu == null) {
        break missingId;
      }

      id = R.id.decreaseQty;
      ImageView decreaseQty = ViewBindings.findChildViewById(rootView, id);
      if (decreaseQty == null) {
        break missingId;
      }

      id = R.id.increaseQty;
      ImageView increaseQty = ViewBindings.findChildViewById(rootView, id);
      if (increaseQty == null) {
        break missingId;
      }

      id = R.id.iv3Peak;
      ImageView iv3Peak = ViewBindings.findChildViewById(rootView, id);
      if (iv3Peak == null) {
        break missingId;
      }

      id = R.id.ivBrand;
      ImageView ivBrand = ViewBindings.findChildViewById(rootView, id);
      if (ivBrand == null) {
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

      id = R.id.ivHubcentric;
      ImageView ivHubcentric = ViewBindings.findChildViewById(rootView, id);
      if (ivHubcentric == null) {
        break missingId;
      }

      id = R.id.ivMrktprgm;
      ImageView ivMrktprgm = ViewBindings.findChildViewById(rootView, id);
      if (ivMrktprgm == null) {
        break missingId;
      }

      id = R.id.ivNewProduct;
      ImageView ivNewProduct = ViewBindings.findChildViewById(rootView, id);
      if (ivNewProduct == null) {
        break missingId;
      }

      id = R.id.ivOE;
      ImageView ivOE = ViewBindings.findChildViewById(rootView, id);
      if (ivOE == null) {
        break missingId;
      }

      id = R.id.ivProduct;
      ImageView ivProduct = ViewBindings.findChildViewById(rootView, id);
      if (ivProduct == null) {
        break missingId;
      }

      id = R.id.ivQuickship;
      ImageView ivQuickship = ViewBindings.findChildViewById(rootView, id);
      if (ivQuickship == null) {
        break missingId;
      }

      id = R.id.ivValueBuys;
      ImageView ivValueBuys = ViewBindings.findChildViewById(rootView, id);
      if (ivValueBuys == null) {
        break missingId;
      }

      id = R.id.ivWinter;
      ImageView ivWinter = ViewBindings.findChildViewById(rootView, id);
      if (ivWinter == null) {
        break missingId;
      }

      id = R.id.ivtotalAccess;
      ImageView ivtotalAccess = ViewBindings.findChildViewById(rootView, id);
      if (ivtotalAccess == null) {
        break missingId;
      }

      id = R.id.llProductCard;
      LinearLayout llProductCard = ViewBindings.findChildViewById(rootView, id);
      if (llProductCard == null) {
        break missingId;
      }

      id = R.id.llProductModel;
      GridLayout llProductModel = ViewBindings.findChildViewById(rootView, id);
      if (llProductModel == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvDimensions;
      RecyclerView rvDimensions = ViewBindings.findChildViewById(rootView, id);
      if (rvDimensions == null) {
        break missingId;
      }

      id = R.id.rvFinish;
      RecyclerView rvFinish = ViewBindings.findChildViewById(rootView, id);
      if (rvFinish == null) {
        break missingId;
      }

      id = R.id.rvFitment;
      RecyclerView rvFitment = ViewBindings.findChildViewById(rootView, id);
      if (rvFitment == null) {
        break missingId;
      }

      id = R.id.rvLugs;
      RecyclerView rvLugs = ViewBindings.findChildViewById(rootView, id);
      if (rvLugs == null) {
        break missingId;
      }

      id = R.id.rvPerformance;
      RecyclerView rvPerformance = ViewBindings.findChildViewById(rootView, id);
      if (rvPerformance == null) {
        break missingId;
      }

      id = R.id.rvPrecision;
      RecyclerView rvPrecision = ViewBindings.findChildViewById(rootView, id);
      if (rvPrecision == null) {
        break missingId;
      }

      id = R.id.rvProductInformation;
      RecyclerView rvProductInformation = ViewBindings.findChildViewById(rootView, id);
      if (rvProductInformation == null) {
        break missingId;
      }

      id = R.id.rvSafety;
      RecyclerView rvSafety = ViewBindings.findChildViewById(rootView, id);
      if (rvSafety == null) {
        break missingId;
      }

      id = R.id.rvSize;
      RecyclerView rvSize = ViewBindings.findChildViewById(rootView, id);
      if (rvSize == null) {
        break missingId;
      }

      id = R.id.rvWeather;
      RecyclerView rvWeather = ViewBindings.findChildViewById(rootView, id);
      if (rvWeather == null) {
        break missingId;
      }

      id = R.id.rvWheelHub;
      RecyclerView rvWheelHub = ViewBindings.findChildViewById(rootView, id);
      if (rvWheelHub == null) {
        break missingId;
      }

      id = R.id.separator;
      View separator = ViewBindings.findChildViewById(rootView, id);
      if (separator == null) {
        break missingId;
      }

      id = R.id.tlProductSpecification;
      TableLayout tlProductSpecification = ViewBindings.findChildViewById(rootView, id);
      if (tlProductSpecification == null) {
        break missingId;
      }

      id = R.id.tvAddCart;
      TextView tvAddCart = ViewBindings.findChildViewById(rootView, id);
      if (tvAddCart == null) {
        break missingId;
      }

      id = R.id.tvAddToList;
      TextView tvAddToList = ViewBindings.findChildViewById(rootView, id);
      if (tvAddToList == null) {
        break missingId;
      }

      id = R.id.tvAddToQuote;
      TextView tvAddToQuote = ViewBindings.findChildViewById(rootView, id);
      if (tvAddToQuote == null) {
        break missingId;
      }

      id = R.id.tvCost;
      TextView tvCost = ViewBindings.findChildViewById(rootView, id);
      if (tvCost == null) {
        break missingId;
      }

      id = R.id.tvDimensions;
      TextView tvDimensions = ViewBindings.findChildViewById(rootView, id);
      if (tvDimensions == null) {
        break missingId;
      }

      id = R.id.tvFet;
      TextView tvFet = ViewBindings.findChildViewById(rootView, id);
      if (tvFet == null) {
        break missingId;
      }

      id = R.id.tvFinish;
      TextView tvFinish = ViewBindings.findChildViewById(rootView, id);
      if (tvFinish == null) {
        break missingId;
      }

      id = R.id.tvFitment;
      TextView tvFitment = ViewBindings.findChildViewById(rootView, id);
      if (tvFitment == null) {
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

      id = R.id.tvLocalPlusValue;
      TextView tvLocalPlusValue = ViewBindings.findChildViewById(rootView, id);
      if (tvLocalPlusValue == null) {
        break missingId;
      }

      id = R.id.tvLocalValue;
      TextView tvLocalValue = ViewBindings.findChildViewById(rootView, id);
      if (tvLocalValue == null) {
        break missingId;
      }

      id = R.id.tvLugs;
      TextView tvLugs = ViewBindings.findChildViewById(rootView, id);
      if (tvLugs == null) {
        break missingId;
      }

      id = R.id.tvMap;
      TextView tvMap = ViewBindings.findChildViewById(rootView, id);
      if (tvMap == null) {
        break missingId;
      }

      id = R.id.tvNational;
      TextView tvNational = ViewBindings.findChildViewById(rootView, id);
      if (tvNational == null) {
        break missingId;
      }

      id = R.id.tvNationalValue;
      TextView tvNationalValue = ViewBindings.findChildViewById(rootView, id);
      if (tvNationalValue == null) {
        break missingId;
      }

      id = R.id.tvOutofTheDoor;
      TextView tvOutofTheDoor = ViewBindings.findChildViewById(rootView, id);
      if (tvOutofTheDoor == null) {
        break missingId;
      }

      id = R.id.tvPerformance;
      TextView tvPerformance = ViewBindings.findChildViewById(rootView, id);
      if (tvPerformance == null) {
        break missingId;
      }

      id = R.id.tvPrecision;
      TextView tvPrecision = ViewBindings.findChildViewById(rootView, id);
      if (tvPrecision == null) {
        break missingId;
      }

      id = R.id.tvProductGroup;
      TextView tvProductGroup = ViewBindings.findChildViewById(rootView, id);
      if (tvProductGroup == null) {
        break missingId;
      }

      id = R.id.tvProductInformation;
      TextView tvProductInformation = ViewBindings.findChildViewById(rootView, id);
      if (tvProductInformation == null) {
        break missingId;
      }

      id = R.id.tvProductName;
      TextView tvProductName = ViewBindings.findChildViewById(rootView, id);
      if (tvProductName == null) {
        break missingId;
      }

      id = R.id.tvRebate;
      TextView tvRebate = ViewBindings.findChildViewById(rootView, id);
      if (tvRebate == null) {
        break missingId;
      }

      id = R.id.tvRetailPrice;
      TextView tvRetailPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvRetailPrice == null) {
        break missingId;
      }

      id = R.id.tvSafety;
      TextView tvSafety = ViewBindings.findChildViewById(rootView, id);
      if (tvSafety == null) {
        break missingId;
      }

      id = R.id.tvSidewall;
      TextView tvSidewall = ViewBindings.findChildViewById(rootView, id);
      if (tvSidewall == null) {
        break missingId;
      }

      id = R.id.tvSidewallValue;
      TextView tvSidewallValue = ViewBindings.findChildViewById(rootView, id);
      if (tvSidewallValue == null) {
        break missingId;
      }

      id = R.id.tvSize;
      TextView tvSize = ViewBindings.findChildViewById(rootView, id);
      if (tvSize == null) {
        break missingId;
      }

      id = R.id.tvSupplier;
      TextView tvSupplier = ViewBindings.findChildViewById(rootView, id);
      if (tvSupplier == null) {
        break missingId;
      }

      id = R.id.tvSupplierValue;
      TextView tvSupplierValue = ViewBindings.findChildViewById(rootView, id);
      if (tvSupplierValue == null) {
        break missingId;
      }

      id = R.id.tvViewMarketingPrograms;
      TextView tvViewMarketingPrograms = ViewBindings.findChildViewById(rootView, id);
      if (tvViewMarketingPrograms == null) {
        break missingId;
      }

      id = R.id.tvViewRebates;
      TextView tvViewRebates = ViewBindings.findChildViewById(rootView, id);
      if (tvViewRebates == null) {
        break missingId;
      }

      id = R.id.tvWarranty;
      TextView tvWarranty = ViewBindings.findChildViewById(rootView, id);
      if (tvWarranty == null) {
        break missingId;
      }

      id = R.id.tvWarrantyValue;
      TextView tvWarrantyValue = ViewBindings.findChildViewById(rootView, id);
      if (tvWarrantyValue == null) {
        break missingId;
      }

      id = R.id.tvWeather;
      TextView tvWeather = ViewBindings.findChildViewById(rootView, id);
      if (tvWeather == null) {
        break missingId;
      }

      id = R.id.tvWheelHub;
      TextView tvWheelHub = ViewBindings.findChildViewById(rootView, id);
      if (tvWheelHub == null) {
        break missingId;
      }

      id = R.id.vBackGround;
      View vBackGround = ViewBindings.findChildViewById(rootView, id);
      if (vBackGround == null) {
        break missingId;
      }

      return new FragmentProductDetailsBinding((ConstraintLayout) rootView, QtyValu, decreaseQty,
          increaseQty, iv3Peak, ivBrand, ivCVActive, ivCVInactive, ivHubcentric, ivMrktprgm,
          ivNewProduct, ivOE, ivProduct, ivQuickship, ivValueBuys, ivWinter, ivtotalAccess,
          llProductCard, llProductModel, progressbar, rvDimensions, rvFinish, rvFitment, rvLugs,
          rvPerformance, rvPrecision, rvProductInformation, rvSafety, rvSize, rvWeather, rvWheelHub,
          separator, tlProductSpecification, tvAddCart, tvAddToList, tvAddToQuote, tvCost,
          tvDimensions, tvFet, tvFinish, tvFitment, tvLocal, tvLocalPlus, tvLocalPlusValue,
          tvLocalValue, tvLugs, tvMap, tvNational, tvNationalValue, tvOutofTheDoor, tvPerformance,
          tvPrecision, tvProductGroup, tvProductInformation, tvProductName, tvRebate, tvRetailPrice,
          tvSafety, tvSidewall, tvSidewallValue, tvSize, tvSupplier, tvSupplierValue,
          tvViewMarketingPrograms, tvViewRebates, tvWarranty, tvWarrantyValue, tvWeather,
          tvWheelHub, vBackGround);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
