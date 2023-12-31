// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomDeleteLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView tvCancel;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final TextView tvYes;

  private CustomDeleteLayoutBinding(@NonNull LinearLayout rootView, @NonNull TextView tvCancel,
      @NonNull TextView tvDescription, @NonNull TextView tvTitle, @NonNull TextView tvYes) {
    this.rootView = rootView;
    this.tvCancel = tvCancel;
    this.tvDescription = tvDescription;
    this.tvTitle = tvTitle;
    this.tvYes = tvYes;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomDeleteLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomDeleteLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_delete_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomDeleteLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvCancel;
      TextView tvCancel = ViewBindings.findChildViewById(rootView, id);
      if (tvCancel == null) {
        break missingId;
      }

      id = R.id.tvDescription;
      TextView tvDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDescription == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      id = R.id.tvYes;
      TextView tvYes = ViewBindings.findChildViewById(rootView, id);
      if (tvYes == null) {
        break missingId;
      }

      return new CustomDeleteLayoutBinding((LinearLayout) rootView, tvCancel, tvDescription,
          tvTitle, tvYes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
