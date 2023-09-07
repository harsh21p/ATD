// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentStreamLinedSearchBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout listItems;

  @NonNull
  public final LinearLayout titleLayout;

  @NonNull
  public final TextView tvDescription;

  @NonNull
  public final TextView tvNextStreamLinedSearch;

  @NonNull
  public final TextView tvSkip;

  @NonNull
  public final TextView tvTitle;

  private FragmentStreamLinedSearchBinding(@NonNull RelativeLayout rootView,
      @NonNull LinearLayout listItems, @NonNull LinearLayout titleLayout,
      @NonNull TextView tvDescription, @NonNull TextView tvNextStreamLinedSearch,
      @NonNull TextView tvSkip, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.listItems = listItems;
    this.titleLayout = titleLayout;
    this.tvDescription = tvDescription;
    this.tvNextStreamLinedSearch = tvNextStreamLinedSearch;
    this.tvSkip = tvSkip;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentStreamLinedSearchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentStreamLinedSearchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_stream_lined_search, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentStreamLinedSearchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.listItems;
      LinearLayout listItems = ViewBindings.findChildViewById(rootView, id);
      if (listItems == null) {
        break missingId;
      }

      id = R.id.titleLayout;
      LinearLayout titleLayout = ViewBindings.findChildViewById(rootView, id);
      if (titleLayout == null) {
        break missingId;
      }

      id = R.id.tvDescription;
      TextView tvDescription = ViewBindings.findChildViewById(rootView, id);
      if (tvDescription == null) {
        break missingId;
      }

      id = R.id.tvNextStreamLinedSearch;
      TextView tvNextStreamLinedSearch = ViewBindings.findChildViewById(rootView, id);
      if (tvNextStreamLinedSearch == null) {
        break missingId;
      }

      id = R.id.tvSkip;
      TextView tvSkip = ViewBindings.findChildViewById(rootView, id);
      if (tvSkip == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new FragmentStreamLinedSearchBinding((RelativeLayout) rootView, listItems, titleLayout,
          tvDescription, tvNextStreamLinedSearch, tvSkip, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}