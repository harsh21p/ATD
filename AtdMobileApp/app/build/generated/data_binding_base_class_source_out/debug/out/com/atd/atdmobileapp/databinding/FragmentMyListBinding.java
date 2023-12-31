// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

public final class FragmentMyListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivNoList;

  @NonNull
  public final ImageView ivSorting;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final RecyclerView rvList;

  @NonNull
  public final TextView tvCreateAList;

  @NonNull
  public final TextView tvCreateList;

  @NonNull
  public final TextView tvNoList;

  private FragmentMyListBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivNoList,
      @NonNull ImageView ivSorting, @NonNull ProgressBar progressbar, @NonNull RecyclerView rvList,
      @NonNull TextView tvCreateAList, @NonNull TextView tvCreateList, @NonNull TextView tvNoList) {
    this.rootView = rootView;
    this.ivNoList = ivNoList;
    this.ivSorting = ivSorting;
    this.progressbar = progressbar;
    this.rvList = rvList;
    this.tvCreateAList = tvCreateAList;
    this.tvCreateList = tvCreateList;
    this.tvNoList = tvNoList;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivNoList;
      ImageView ivNoList = ViewBindings.findChildViewById(rootView, id);
      if (ivNoList == null) {
        break missingId;
      }

      id = R.id.ivSorting;
      ImageView ivSorting = ViewBindings.findChildViewById(rootView, id);
      if (ivSorting == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.rvList;
      RecyclerView rvList = ViewBindings.findChildViewById(rootView, id);
      if (rvList == null) {
        break missingId;
      }

      id = R.id.tvCreateAList;
      TextView tvCreateAList = ViewBindings.findChildViewById(rootView, id);
      if (tvCreateAList == null) {
        break missingId;
      }

      id = R.id.tvCreateList;
      TextView tvCreateList = ViewBindings.findChildViewById(rootView, id);
      if (tvCreateList == null) {
        break missingId;
      }

      id = R.id.tvNoList;
      TextView tvNoList = ViewBindings.findChildViewById(rootView, id);
      if (tvNoList == null) {
        break missingId;
      }

      return new FragmentMyListBinding((ConstraintLayout) rootView, ivNoList, ivSorting,
          progressbar, rvList, tvCreateAList, tvCreateList, tvNoList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
