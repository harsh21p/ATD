// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

public final class FragmentMyListDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText etProductNumber;

  @NonNull
  public final ImageView ivAddProduct;

  @NonNull
  public final LinearLayout llListActions;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvList;

  @NonNull
  public final TextView tvAddItemDes;

  @NonNull
  public final TextView tvAddProduct;

  @NonNull
  public final TextView tvAddToList;

  @NonNull
  public final TextView tvDeleteList;

  @NonNull
  public final TextView tvDiSelectAll;

  @NonNull
  public final TextView tvEditList;

  @NonNull
  public final TextView tvListActions;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvNoDataAvailable;

  @NonNull
  public final TextView tvPrintList;

  @NonNull
  public final ApproveRejectButtonsBinding tvRemoveAddCart;

  @NonNull
  public final TextView tvRenameList;

  @NonNull
  public final TextView tvSelectAll;

  @NonNull
  public final TextView tvTotalItems;

  private FragmentMyListDetailsBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText etProductNumber, @NonNull ImageView ivAddProduct,
      @NonNull LinearLayout llListActions, @NonNull ProgressBar progressbar,
      @NonNull RecyclerView rvList, @NonNull TextView tvAddItemDes, @NonNull TextView tvAddProduct,
      @NonNull TextView tvAddToList, @NonNull TextView tvDeleteList,
      @NonNull TextView tvDiSelectAll, @NonNull TextView tvEditList,
      @NonNull TextView tvListActions, @NonNull TextView tvName,
      @NonNull TextView tvNoDataAvailable, @NonNull TextView tvPrintList,
      @NonNull ApproveRejectButtonsBinding tvRemoveAddCart, @NonNull TextView tvRenameList,
      @NonNull TextView tvSelectAll, @NonNull TextView tvTotalItems) {
    this.rootView = rootView;
    this.etProductNumber = etProductNumber;
    this.ivAddProduct = ivAddProduct;
    this.llListActions = llListActions;
    this.progressbar = progressbar;
    this.rvList = rvList;
    this.tvAddItemDes = tvAddItemDes;
    this.tvAddProduct = tvAddProduct;
    this.tvAddToList = tvAddToList;
    this.tvDeleteList = tvDeleteList;
    this.tvDiSelectAll = tvDiSelectAll;
    this.tvEditList = tvEditList;
    this.tvListActions = tvListActions;
    this.tvName = tvName;
    this.tvNoDataAvailable = tvNoDataAvailable;
    this.tvPrintList = tvPrintList;
    this.tvRemoveAddCart = tvRemoveAddCart;
    this.tvRenameList = tvRenameList;
    this.tvSelectAll = tvSelectAll;
    this.tvTotalItems = tvTotalItems;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyListDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyListDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_list_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyListDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etProductNumber;
      EditText etProductNumber = ViewBindings.findChildViewById(rootView, id);
      if (etProductNumber == null) {
        break missingId;
      }

      id = R.id.ivAddProduct;
      ImageView ivAddProduct = ViewBindings.findChildViewById(rootView, id);
      if (ivAddProduct == null) {
        break missingId;
      }

      id = R.id.llListActions;
      LinearLayout llListActions = ViewBindings.findChildViewById(rootView, id);
      if (llListActions == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvList;
      RecyclerView rvList = ViewBindings.findChildViewById(rootView, id);
      if (rvList == null) {
        break missingId;
      }

      id = R.id.tvAddItemDes;
      TextView tvAddItemDes = ViewBindings.findChildViewById(rootView, id);
      if (tvAddItemDes == null) {
        break missingId;
      }

      id = R.id.tvAddProduct;
      TextView tvAddProduct = ViewBindings.findChildViewById(rootView, id);
      if (tvAddProduct == null) {
        break missingId;
      }

      id = R.id.tvAddToList;
      TextView tvAddToList = ViewBindings.findChildViewById(rootView, id);
      if (tvAddToList == null) {
        break missingId;
      }

      id = R.id.tvDeleteList;
      TextView tvDeleteList = ViewBindings.findChildViewById(rootView, id);
      if (tvDeleteList == null) {
        break missingId;
      }

      id = R.id.tvDiSelectAll;
      TextView tvDiSelectAll = ViewBindings.findChildViewById(rootView, id);
      if (tvDiSelectAll == null) {
        break missingId;
      }

      id = R.id.tvEditList;
      TextView tvEditList = ViewBindings.findChildViewById(rootView, id);
      if (tvEditList == null) {
        break missingId;
      }

      id = R.id.tvListActions;
      TextView tvListActions = ViewBindings.findChildViewById(rootView, id);
      if (tvListActions == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tvNoDataAvailable;
      TextView tvNoDataAvailable = ViewBindings.findChildViewById(rootView, id);
      if (tvNoDataAvailable == null) {
        break missingId;
      }

      id = R.id.tvPrintList;
      TextView tvPrintList = ViewBindings.findChildViewById(rootView, id);
      if (tvPrintList == null) {
        break missingId;
      }

      id = R.id.tvRemoveAddCart;
      View tvRemoveAddCart = ViewBindings.findChildViewById(rootView, id);
      if (tvRemoveAddCart == null) {
        break missingId;
      }
      ApproveRejectButtonsBinding binding_tvRemoveAddCart = ApproveRejectButtonsBinding.bind(tvRemoveAddCart);

      id = R.id.tvRenameList;
      TextView tvRenameList = ViewBindings.findChildViewById(rootView, id);
      if (tvRenameList == null) {
        break missingId;
      }

      id = R.id.tvSelectAll;
      TextView tvSelectAll = ViewBindings.findChildViewById(rootView, id);
      if (tvSelectAll == null) {
        break missingId;
      }

      id = R.id.tvTotalItems;
      TextView tvTotalItems = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalItems == null) {
        break missingId;
      }

      return new FragmentMyListDetailsBinding((ConstraintLayout) rootView, etProductNumber,
          ivAddProduct, llListActions, progressbar, rvList, tvAddItemDes, tvAddProduct, tvAddToList,
          tvDeleteList, tvDiSelectAll, tvEditList, tvListActions, tvName, tvNoDataAvailable,
          tvPrintList, binding_tvRemoveAddCart, tvRenameList, tvSelectAll, tvTotalItems);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}