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

public final class MyquotesItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView datePlaced;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView orderStatus;

  @NonNull
  public final TextView quoteNum;

  @NonNull
  public final TextView quotedBy;

  private MyquotesItemBinding(@NonNull CardView rootView, @NonNull TextView datePlaced,
      @NonNull TextView name, @NonNull TextView orderStatus, @NonNull TextView quoteNum,
      @NonNull TextView quotedBy) {
    this.rootView = rootView;
    this.datePlaced = datePlaced;
    this.name = name;
    this.orderStatus = orderStatus;
    this.quoteNum = quoteNum;
    this.quotedBy = quotedBy;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MyquotesItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MyquotesItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.myquotes_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MyquotesItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.datePlaced;
      TextView datePlaced = ViewBindings.findChildViewById(rootView, id);
      if (datePlaced == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.orderStatus;
      TextView orderStatus = ViewBindings.findChildViewById(rootView, id);
      if (orderStatus == null) {
        break missingId;
      }

      id = R.id.quoteNum;
      TextView quoteNum = ViewBindings.findChildViewById(rootView, id);
      if (quoteNum == null) {
        break missingId;
      }

      id = R.id.quotedBy;
      TextView quotedBy = ViewBindings.findChildViewById(rootView, id);
      if (quotedBy == null) {
        break missingId;
      }

      return new MyquotesItemBinding((CardView) rootView, datePlaced, name, orderStatus, quoteNum,
          quotedBy);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
