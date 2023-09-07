// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class QuoteFeesServicesCustomLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView serviceName;

  @NonNull
  public final TextView serviceQty;

  @NonNull
  public final TextView serviceRetailCost;

  @NonNull
  public final TextView serviceTotalCost;

  private QuoteFeesServicesCustomLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView serviceName, @NonNull TextView serviceQty,
      @NonNull TextView serviceRetailCost, @NonNull TextView serviceTotalCost) {
    this.rootView = rootView;
    this.serviceName = serviceName;
    this.serviceQty = serviceQty;
    this.serviceRetailCost = serviceRetailCost;
    this.serviceTotalCost = serviceTotalCost;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static QuoteFeesServicesCustomLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static QuoteFeesServicesCustomLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.quote_fees_services_custom_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static QuoteFeesServicesCustomLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.serviceName;
      TextView serviceName = ViewBindings.findChildViewById(rootView, id);
      if (serviceName == null) {
        break missingId;
      }

      id = R.id.serviceQty;
      TextView serviceQty = ViewBindings.findChildViewById(rootView, id);
      if (serviceQty == null) {
        break missingId;
      }

      id = R.id.serviceRetailCost;
      TextView serviceRetailCost = ViewBindings.findChildViewById(rootView, id);
      if (serviceRetailCost == null) {
        break missingId;
      }

      id = R.id.serviceTotalCost;
      TextView serviceTotalCost = ViewBindings.findChildViewById(rootView, id);
      if (serviceTotalCost == null) {
        break missingId;
      }

      return new QuoteFeesServicesCustomLayoutBinding((ConstraintLayout) rootView, serviceName,
          serviceQty, serviceRetailCost, serviceTotalCost);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}