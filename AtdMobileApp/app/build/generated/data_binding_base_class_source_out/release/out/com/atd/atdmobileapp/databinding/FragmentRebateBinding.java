// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public final class FragmentRebateBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText etFrontTire;

  @NonNull
  public final EditText etRearTire;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final TextView tvFrontTire;

  @NonNull
  public final TextView tvRearTire;

  @NonNull
  public final TextView tvSearch;

  private FragmentRebateBinding(@NonNull ConstraintLayout rootView, @NonNull EditText etFrontTire,
      @NonNull EditText etRearTire, @NonNull ProgressBar progressbar, @NonNull TextView tvFrontTire,
      @NonNull TextView tvRearTire, @NonNull TextView tvSearch) {
    this.rootView = rootView;
    this.etFrontTire = etFrontTire;
    this.etRearTire = etRearTire;
    this.progressbar = progressbar;
    this.tvFrontTire = tvFrontTire;
    this.tvRearTire = tvRearTire;
    this.tvSearch = tvSearch;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRebateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRebateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_rebate, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRebateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etFrontTire;
      EditText etFrontTire = ViewBindings.findChildViewById(rootView, id);
      if (etFrontTire == null) {
        break missingId;
      }

      id = R.id.etRearTire;
      EditText etRearTire = ViewBindings.findChildViewById(rootView, id);
      if (etRearTire == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.tvFrontTire;
      TextView tvFrontTire = ViewBindings.findChildViewById(rootView, id);
      if (tvFrontTire == null) {
        break missingId;
      }

      id = R.id.tvRearTire;
      TextView tvRearTire = ViewBindings.findChildViewById(rootView, id);
      if (tvRearTire == null) {
        break missingId;
      }

      id = R.id.tvSearch;
      TextView tvSearch = ViewBindings.findChildViewById(rootView, id);
      if (tvSearch == null) {
        break missingId;
      }

      return new FragmentRebateBinding((ConstraintLayout) rootView, etFrontTire, etRearTire,
          progressbar, tvFrontTire, tvRearTire, tvSearch);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
