// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public final class RejectDialogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView cancel;

  @NonNull
  public final View divider;

  @NonNull
  public final EditText etComments;

  @NonNull
  public final TextView reject;

  @NonNull
  public final TextView tvHeader;

  @NonNull
  public final TextView tvNote;

  private RejectDialogBinding(@NonNull ConstraintLayout rootView, @NonNull TextView cancel,
      @NonNull View divider, @NonNull EditText etComments, @NonNull TextView reject,
      @NonNull TextView tvHeader, @NonNull TextView tvNote) {
    this.rootView = rootView;
    this.cancel = cancel;
    this.divider = divider;
    this.etComments = etComments;
    this.reject = reject;
    this.tvHeader = tvHeader;
    this.tvNote = tvNote;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RejectDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RejectDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.reject_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RejectDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancel;
      TextView cancel = ViewBindings.findChildViewById(rootView, id);
      if (cancel == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.etComments;
      EditText etComments = ViewBindings.findChildViewById(rootView, id);
      if (etComments == null) {
        break missingId;
      }

      id = R.id.reject;
      TextView reject = ViewBindings.findChildViewById(rootView, id);
      if (reject == null) {
        break missingId;
      }

      id = R.id.tvHeader;
      TextView tvHeader = ViewBindings.findChildViewById(rootView, id);
      if (tvHeader == null) {
        break missingId;
      }

      id = R.id.tvNote;
      TextView tvNote = ViewBindings.findChildViewById(rootView, id);
      if (tvNote == null) {
        break missingId;
      }

      return new RejectDialogBinding((ConstraintLayout) rootView, cancel, divider, etComments,
          reject, tvHeader, tvNote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}