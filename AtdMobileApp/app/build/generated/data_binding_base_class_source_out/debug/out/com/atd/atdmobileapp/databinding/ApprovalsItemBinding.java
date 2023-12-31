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

public final class ApprovalsItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView datePlaced;

  @NonNull
  public final TextView total;

  @NonNull
  public final TextView tvSubmittedBy;

  private ApprovalsItemBinding(@NonNull CardView rootView, @NonNull TextView datePlaced,
      @NonNull TextView total, @NonNull TextView tvSubmittedBy) {
    this.rootView = rootView;
    this.datePlaced = datePlaced;
    this.total = total;
    this.tvSubmittedBy = tvSubmittedBy;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ApprovalsItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ApprovalsItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.approvals_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ApprovalsItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.datePlaced;
      TextView datePlaced = ViewBindings.findChildViewById(rootView, id);
      if (datePlaced == null) {
        break missingId;
      }

      id = R.id.total;
      TextView total = ViewBindings.findChildViewById(rootView, id);
      if (total == null) {
        break missingId;
      }

      id = R.id.tvSubmittedBy;
      TextView tvSubmittedBy = ViewBindings.findChildViewById(rootView, id);
      if (tvSubmittedBy == null) {
        break missingId;
      }

      return new ApprovalsItemBinding((CardView) rootView, datePlaced, total, tvSubmittedBy);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
