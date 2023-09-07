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

public final class ProductTopListItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivBackGround;

  @NonNull
  public final ImageView ivIcon;

  @NonNull
  public final TextView tvName;

  private ProductTopListItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView ivBackGround, @NonNull ImageView ivIcon, @NonNull TextView tvName) {
    this.rootView = rootView;
    this.ivBackGround = ivBackGround;
    this.ivIcon = ivIcon;
    this.tvName = tvName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProductTopListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProductTopListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.product_top_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProductTopListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivBackGround;
      ImageView ivBackGround = ViewBindings.findChildViewById(rootView, id);
      if (ivBackGround == null) {
        break missingId;
      }

      id = R.id.ivIcon;
      ImageView ivIcon = ViewBindings.findChildViewById(rootView, id);
      if (ivIcon == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      return new ProductTopListItemBinding((ConstraintLayout) rootView, ivBackGround, ivIcon,
          tvName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}