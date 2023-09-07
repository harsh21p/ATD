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

public final class AlertBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView alertMessage;

  @NonNull
  public final TextView alertOK;

  @NonNull
  public final TextView alertTitle;

  @NonNull
  public final View divider;

  private AlertBinding(@NonNull ConstraintLayout rootView, @NonNull TextView alertMessage,
      @NonNull TextView alertOK, @NonNull TextView alertTitle, @NonNull View divider) {
    this.rootView = rootView;
    this.alertMessage = alertMessage;
    this.alertOK = alertOK;
    this.alertTitle = alertTitle;
    this.divider = divider;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AlertBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AlertBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.alert, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AlertBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.alertMessage;
      TextView alertMessage = ViewBindings.findChildViewById(rootView, id);
      if (alertMessage == null) {
        break missingId;
      }

      id = R.id.alertOK;
      TextView alertOK = ViewBindings.findChildViewById(rootView, id);
      if (alertOK == null) {
        break missingId;
      }

      id = R.id.alertTitle;
      TextView alertTitle = ViewBindings.findChildViewById(rootView, id);
      if (alertTitle == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      return new AlertBinding((ConstraintLayout) rootView, alertMessage, alertOK, alertTitle,
          divider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
