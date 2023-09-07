// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class OrderItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView datePlaced;

  @NonNull
  public final TextView orderNum;

  @NonNull
  public final TextView orderStatus;

  @NonNull
  public final TextView tvCnfNum;

  private OrderItemBinding(@NonNull CardView rootView, @NonNull TextView datePlaced,
      @NonNull TextView orderNum, @NonNull TextView orderStatus, @NonNull TextView tvCnfNum) {
    this.rootView = rootView;
    this.datePlaced = datePlaced;
    this.orderNum = orderNum;
    this.orderStatus = orderStatus;
    this.tvCnfNum = tvCnfNum;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static OrderItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OrderItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.order_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OrderItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.datePlaced;
      TextView datePlaced = ViewBindings.findChildViewById(rootView, id);
      if (datePlaced == null) {
        break missingId;
      }

      id = R.id.orderNum;
      TextView orderNum = ViewBindings.findChildViewById(rootView, id);
      if (orderNum == null) {
        break missingId;
      }

      id = R.id.orderStatus;
      TextView orderStatus = ViewBindings.findChildViewById(rootView, id);
      if (orderStatus == null) {
        break missingId;
      }

      id = R.id.tvCnfNum;
      TextView tvCnfNum = ViewBindings.findChildViewById(rootView, id);
      if (tvCnfNum == null) {
        break missingId;
      }

      return new OrderItemBinding((CardView) rootView, datePlaced, orderNum, orderStatus, tvCnfNum);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
