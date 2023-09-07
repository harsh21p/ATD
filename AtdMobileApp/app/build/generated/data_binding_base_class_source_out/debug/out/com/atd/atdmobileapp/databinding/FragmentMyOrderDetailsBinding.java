// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class FragmentMyOrderDetailsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final View divider;

  @NonNull
  public final View divider2;

  @NonNull
  public final View divider3;

  @NonNull
  public final ApproveRejectButtonsBinding ordersSubmitFoote;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvOrderItemLine;

  @NonNull
  public final TextView tvConfirmation;

  @NonNull
  public final TextView tvConsumerName;

  @NonNull
  public final TextView tvFreight;

  @NonNull
  public final TextView tvFreightValue;

  @NonNull
  public final TextView tvInvoice;

  @NonNull
  public final TextView tvOrderAgain;

  @NonNull
  public final TextView tvOrderDate;

  @NonNull
  public final TextView tvOrderStatus;

  @NonNull
  public final TextView tvPO;

  @NonNull
  public final TextView tvPrintOrder;

  @NonNull
  public final TextView tvSubtotal;

  @NonNull
  public final TextView tvSubtotalValue;

  @NonNull
  public final TextView tvTotal;

  @NonNull
  public final TextView tvTotalValue;

  private FragmentMyOrderDetailsBinding(@NonNull ConstraintLayout rootView, @NonNull View divider,
      @NonNull View divider2, @NonNull View divider3,
      @NonNull ApproveRejectButtonsBinding ordersSubmitFoote, @NonNull ProgressBar progressbar,
      @NonNull RecyclerView rvOrderItemLine, @NonNull TextView tvConfirmation,
      @NonNull TextView tvConsumerName, @NonNull TextView tvFreight,
      @NonNull TextView tvFreightValue, @NonNull TextView tvInvoice, @NonNull TextView tvOrderAgain,
      @NonNull TextView tvOrderDate, @NonNull TextView tvOrderStatus, @NonNull TextView tvPO,
      @NonNull TextView tvPrintOrder, @NonNull TextView tvSubtotal,
      @NonNull TextView tvSubtotalValue, @NonNull TextView tvTotal,
      @NonNull TextView tvTotalValue) {
    this.rootView = rootView;
    this.divider = divider;
    this.divider2 = divider2;
    this.divider3 = divider3;
    this.ordersSubmitFoote = ordersSubmitFoote;
    this.progressbar = progressbar;
    this.rvOrderItemLine = rvOrderItemLine;
    this.tvConfirmation = tvConfirmation;
    this.tvConsumerName = tvConsumerName;
    this.tvFreight = tvFreight;
    this.tvFreightValue = tvFreightValue;
    this.tvInvoice = tvInvoice;
    this.tvOrderAgain = tvOrderAgain;
    this.tvOrderDate = tvOrderDate;
    this.tvOrderStatus = tvOrderStatus;
    this.tvPO = tvPO;
    this.tvPrintOrder = tvPrintOrder;
    this.tvSubtotal = tvSubtotal;
    this.tvSubtotalValue = tvSubtotalValue;
    this.tvTotal = tvTotal;
    this.tvTotalValue = tvTotalValue;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyOrderDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyOrderDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_order_details, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyOrderDetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.divider2;
      View divider2 = ViewBindings.findChildViewById(rootView, id);
      if (divider2 == null) {
        break missingId;
      }

      id = R.id.divider3;
      View divider3 = ViewBindings.findChildViewById(rootView, id);
      if (divider3 == null) {
        break missingId;
      }

      id = R.id.ordersSubmitFoote;
      View ordersSubmitFoote = ViewBindings.findChildViewById(rootView, id);
      if (ordersSubmitFoote == null) {
        break missingId;
      }
      ApproveRejectButtonsBinding binding_ordersSubmitFoote = ApproveRejectButtonsBinding.bind(ordersSubmitFoote);

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvOrderItemLine;
      RecyclerView rvOrderItemLine = ViewBindings.findChildViewById(rootView, id);
      if (rvOrderItemLine == null) {
        break missingId;
      }

      id = R.id.tvConfirmation;
      TextView tvConfirmation = ViewBindings.findChildViewById(rootView, id);
      if (tvConfirmation == null) {
        break missingId;
      }

      id = R.id.tvConsumerName;
      TextView tvConsumerName = ViewBindings.findChildViewById(rootView, id);
      if (tvConsumerName == null) {
        break missingId;
      }

      id = R.id.tvFreight;
      TextView tvFreight = ViewBindings.findChildViewById(rootView, id);
      if (tvFreight == null) {
        break missingId;
      }

      id = R.id.tvFreightValue;
      TextView tvFreightValue = ViewBindings.findChildViewById(rootView, id);
      if (tvFreightValue == null) {
        break missingId;
      }

      id = R.id.tvInvoice;
      TextView tvInvoice = ViewBindings.findChildViewById(rootView, id);
      if (tvInvoice == null) {
        break missingId;
      }

      id = R.id.tvOrderAgain;
      TextView tvOrderAgain = ViewBindings.findChildViewById(rootView, id);
      if (tvOrderAgain == null) {
        break missingId;
      }

      id = R.id.tvOrderDate;
      TextView tvOrderDate = ViewBindings.findChildViewById(rootView, id);
      if (tvOrderDate == null) {
        break missingId;
      }

      id = R.id.tvOrderStatus;
      TextView tvOrderStatus = ViewBindings.findChildViewById(rootView, id);
      if (tvOrderStatus == null) {
        break missingId;
      }

      id = R.id.tvPO;
      TextView tvPO = ViewBindings.findChildViewById(rootView, id);
      if (tvPO == null) {
        break missingId;
      }

      id = R.id.tvPrintOrder;
      TextView tvPrintOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvPrintOrder == null) {
        break missingId;
      }

      id = R.id.tvSubtotal;
      TextView tvSubtotal = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotal == null) {
        break missingId;
      }

      id = R.id.tvSubtotalValue;
      TextView tvSubtotalValue = ViewBindings.findChildViewById(rootView, id);
      if (tvSubtotalValue == null) {
        break missingId;
      }

      id = R.id.tvTotal;
      TextView tvTotal = ViewBindings.findChildViewById(rootView, id);
      if (tvTotal == null) {
        break missingId;
      }

      id = R.id.tvTotalValue;
      TextView tvTotalValue = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalValue == null) {
        break missingId;
      }

      return new FragmentMyOrderDetailsBinding((ConstraintLayout) rootView, divider, divider2,
          divider3, binding_ordersSubmitFoote, progressbar, rvOrderItemLine, tvConfirmation,
          tvConsumerName, tvFreight, tvFreightValue, tvInvoice, tvOrderAgain, tvOrderDate,
          tvOrderStatus, tvPO, tvPrintOrder, tvSubtotal, tvSubtotalValue, tvTotal, tvTotalValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}