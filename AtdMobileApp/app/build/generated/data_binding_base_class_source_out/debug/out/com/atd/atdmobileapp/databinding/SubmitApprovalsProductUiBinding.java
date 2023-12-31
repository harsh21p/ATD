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

public final class SubmitApprovalsProductUiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvProductName;

  @NonNull
  public final TextView tvQuantity;

  @NonNull
  public final TextView tvSupplier;

  private SubmitApprovalsProductUiBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView tvProductName, @NonNull TextView tvQuantity, @NonNull TextView tvSupplier) {
    this.rootView = rootView;
    this.tvProductName = tvProductName;
    this.tvQuantity = tvQuantity;
    this.tvSupplier = tvSupplier;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SubmitApprovalsProductUiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SubmitApprovalsProductUiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.submit_approvals_product_ui, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SubmitApprovalsProductUiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvProductName;
      TextView tvProductName = ViewBindings.findChildViewById(rootView, id);
      if (tvProductName == null) {
        break missingId;
      }

      id = R.id.tvQuantity;
      TextView tvQuantity = ViewBindings.findChildViewById(rootView, id);
      if (tvQuantity == null) {
        break missingId;
      }

      id = R.id.tvSupplier;
      TextView tvSupplier = ViewBindings.findChildViewById(rootView, id);
      if (tvSupplier == null) {
        break missingId;
      }

      return new SubmitApprovalsProductUiBinding((ConstraintLayout) rootView, tvProductName,
          tvQuantity, tvSupplier);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
