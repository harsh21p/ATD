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

public final class FragmentMyOrdersBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView noData;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvMyOrders;

  @NonNull
  public final TextView viewAll;

  private FragmentMyOrdersBinding(@NonNull ConstraintLayout rootView, @NonNull TextView noData,
      @NonNull ProgressBar progressbar, @NonNull RecyclerView rvMyOrders,
      @NonNull TextView viewAll) {
    this.rootView = rootView;
    this.noData = noData;
    this.progressbar = progressbar;
    this.rvMyOrders = rvMyOrders;
    this.viewAll = viewAll;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyOrdersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyOrdersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_orders, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyOrdersBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.noData;
      TextView noData = ViewBindings.findChildViewById(rootView, id);
      if (noData == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvMyOrders;
      RecyclerView rvMyOrders = ViewBindings.findChildViewById(rootView, id);
      if (rvMyOrders == null) {
        break missingId;
      }

      id = R.id.viewAll;
      TextView viewAll = ViewBindings.findChildViewById(rootView, id);
      if (viewAll == null) {
        break missingId;
      }

      return new FragmentMyOrdersBinding((ConstraintLayout) rootView, noData, progressbar,
          rvMyOrders, viewAll);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}