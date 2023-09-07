// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class MylistChildItemsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivProducts;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvTotalItems;

  private MylistChildItemsBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivProducts,
      @NonNull TextView tvName, @NonNull TextView tvTotalItems) {
    this.rootView = rootView;
    this.ivProducts = ivProducts;
    this.tvName = tvName;
    this.tvTotalItems = tvTotalItems;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MylistChildItemsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MylistChildItemsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.mylist_child_items, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MylistChildItemsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivProducts;
      ImageView ivProducts = ViewBindings.findChildViewById(rootView, id);
      if (ivProducts == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tvTotalItems;
      TextView tvTotalItems = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalItems == null) {
        break missingId;
      }

      return new MylistChildItemsBinding((ConstraintLayout) rootView, ivProducts, tvName,
          tvTotalItems);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}