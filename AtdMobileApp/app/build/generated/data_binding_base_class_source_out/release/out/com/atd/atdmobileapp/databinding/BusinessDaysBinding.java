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

public final class BusinessDaysBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView tSun;

  @NonNull
  public final TextView tvFri;

  @NonNull
  public final TextView tvMon;

  @NonNull
  public final TextView tvSat;

  @NonNull
  public final TextView tvThu;

  @NonNull
  public final TextView tvTue;

  @NonNull
  public final TextView tvWed;

  private BusinessDaysBinding(@NonNull LinearLayout rootView, @NonNull TextView tSun,
      @NonNull TextView tvFri, @NonNull TextView tvMon, @NonNull TextView tvSat,
      @NonNull TextView tvThu, @NonNull TextView tvTue, @NonNull TextView tvWed) {
    this.rootView = rootView;
    this.tSun = tSun;
    this.tvFri = tvFri;
    this.tvMon = tvMon;
    this.tvSat = tvSat;
    this.tvThu = tvThu;
    this.tvTue = tvTue;
    this.tvWed = tvWed;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BusinessDaysBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BusinessDaysBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.business_days, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BusinessDaysBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tSun;
      TextView tSun = ViewBindings.findChildViewById(rootView, id);
      if (tSun == null) {
        break missingId;
      }

      id = R.id.tvFri;
      TextView tvFri = ViewBindings.findChildViewById(rootView, id);
      if (tvFri == null) {
        break missingId;
      }

      id = R.id.tvMon;
      TextView tvMon = ViewBindings.findChildViewById(rootView, id);
      if (tvMon == null) {
        break missingId;
      }

      id = R.id.tvSat;
      TextView tvSat = ViewBindings.findChildViewById(rootView, id);
      if (tvSat == null) {
        break missingId;
      }

      id = R.id.tvThu;
      TextView tvThu = ViewBindings.findChildViewById(rootView, id);
      if (tvThu == null) {
        break missingId;
      }

      id = R.id.tvTue;
      TextView tvTue = ViewBindings.findChildViewById(rootView, id);
      if (tvTue == null) {
        break missingId;
      }

      id = R.id.tvWed;
      TextView tvWed = ViewBindings.findChildViewById(rootView, id);
      if (tvWed == null) {
        break missingId;
      }

      return new BusinessDaysBinding((LinearLayout) rootView, tSun, tvFri, tvMon, tvSat, tvThu,
          tvTue, tvWed);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
