// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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

public final class FragmentVINBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText etVin;

  @NonNull
  public final ImageView ivBarCode;

  @NonNull
  public final TextView noResultTv1;

  @NonNull
  public final TextView noResultTv2;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final TextView tvSearch;

  @NonNull
  public final TextView tvVin;

  private FragmentVINBinding(@NonNull ConstraintLayout rootView, @NonNull EditText etVin,
      @NonNull ImageView ivBarCode, @NonNull TextView noResultTv1, @NonNull TextView noResultTv2,
      @NonNull ProgressBar progressbar, @NonNull TextView tvSearch, @NonNull TextView tvVin) {
    this.rootView = rootView;
    this.etVin = etVin;
    this.ivBarCode = ivBarCode;
    this.noResultTv1 = noResultTv1;
    this.noResultTv2 = noResultTv2;
    this.progressbar = progressbar;
    this.tvSearch = tvSearch;
    this.tvVin = tvVin;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentVINBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentVINBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_v_i_n, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentVINBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etVin;
      EditText etVin = ViewBindings.findChildViewById(rootView, id);
      if (etVin == null) {
        break missingId;
      }

      id = R.id.ivBarCode;
      ImageView ivBarCode = ViewBindings.findChildViewById(rootView, id);
      if (ivBarCode == null) {
        break missingId;
      }

      id = R.id.noResultTv1;
      TextView noResultTv1 = ViewBindings.findChildViewById(rootView, id);
      if (noResultTv1 == null) {
        break missingId;
      }

      id = R.id.noResultTv2;
      TextView noResultTv2 = ViewBindings.findChildViewById(rootView, id);
      if (noResultTv2 == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.tvSearch;
      TextView tvSearch = ViewBindings.findChildViewById(rootView, id);
      if (tvSearch == null) {
        break missingId;
      }

      id = R.id.tvVin;
      TextView tvVin = ViewBindings.findChildViewById(rootView, id);
      if (tvVin == null) {
        break missingId;
      }

      return new FragmentVINBinding((ConstraintLayout) rootView, etVin, ivBarCode, noResultTv1,
          noResultTv2, progressbar, tvSearch, tvVin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
