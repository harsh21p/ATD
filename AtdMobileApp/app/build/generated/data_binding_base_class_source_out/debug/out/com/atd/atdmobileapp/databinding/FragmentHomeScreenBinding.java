// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeScreenBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ConstraintLayout ClOrder;

  @NonNull
  public final RelativeLayout atdHeader;

  @NonNull
  public final TextView badgeCount;

  @NonNull
  public final BottomNavigationView bottomNavigationView;

  @NonNull
  public final FrameLayout bottomNavigationViewFrame;

  @NonNull
  public final FrameLayout cartContainer;

  @NonNull
  public final ImageView ivApprovals;

  @NonNull
  public final ImageView ivAtdCart;

  @NonNull
  public final TextView ivAtdLogo;

  @NonNull
  public final ImageView ivSearch;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final LinearLayout rootViewHome;

  @NonNull
  public final TextView tvConsumerName;

  @NonNull
  public final TextView tvDate;

  @NonNull
  public final TextView tvHeaderText;

  @NonNull
  public final TextView tvLocationNumber;

  @NonNull
  public final TextView tvOrder;

  @NonNull
  public final TextView tvOrderConfirmation;

  @NonNull
  public final TextView tvOrderMessage;

  @NonNull
  public final TextView tvPo;

  @NonNull
  public final TextView tvSaveOrder;

  @NonNull
  public final TextView tvViewOrder;

  @NonNull
  public final View viewHeader;

  @NonNull
  public final ImageView viewSeperator;

  private FragmentHomeScreenBinding(@NonNull LinearLayout rootView,
      @NonNull ConstraintLayout ClOrder, @NonNull RelativeLayout atdHeader,
      @NonNull TextView badgeCount, @NonNull BottomNavigationView bottomNavigationView,
      @NonNull FrameLayout bottomNavigationViewFrame, @NonNull FrameLayout cartContainer,
      @NonNull ImageView ivApprovals, @NonNull ImageView ivAtdCart, @NonNull TextView ivAtdLogo,
      @NonNull ImageView ivSearch, @NonNull ProgressBar progressbar,
      @NonNull LinearLayout rootViewHome, @NonNull TextView tvConsumerName,
      @NonNull TextView tvDate, @NonNull TextView tvHeaderText, @NonNull TextView tvLocationNumber,
      @NonNull TextView tvOrder, @NonNull TextView tvOrderConfirmation,
      @NonNull TextView tvOrderMessage, @NonNull TextView tvPo, @NonNull TextView tvSaveOrder,
      @NonNull TextView tvViewOrder, @NonNull View viewHeader, @NonNull ImageView viewSeperator) {
    this.rootView = rootView;
    this.ClOrder = ClOrder;
    this.atdHeader = atdHeader;
    this.badgeCount = badgeCount;
    this.bottomNavigationView = bottomNavigationView;
    this.bottomNavigationViewFrame = bottomNavigationViewFrame;
    this.cartContainer = cartContainer;
    this.ivApprovals = ivApprovals;
    this.ivAtdCart = ivAtdCart;
    this.ivAtdLogo = ivAtdLogo;
    this.ivSearch = ivSearch;
    this.progressbar = progressbar;
    this.rootViewHome = rootViewHome;
    this.tvConsumerName = tvConsumerName;
    this.tvDate = tvDate;
    this.tvHeaderText = tvHeaderText;
    this.tvLocationNumber = tvLocationNumber;
    this.tvOrder = tvOrder;
    this.tvOrderConfirmation = tvOrderConfirmation;
    this.tvOrderMessage = tvOrderMessage;
    this.tvPo = tvPo;
    this.tvSaveOrder = tvSaveOrder;
    this.tvViewOrder = tvViewOrder;
    this.viewHeader = viewHeader;
    this.viewSeperator = viewSeperator;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home_screen, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeScreenBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ClOrder;
      ConstraintLayout ClOrder = ViewBindings.findChildViewById(rootView, id);
      if (ClOrder == null) {
        break missingId;
      }

      id = R.id.atdHeader;
      RelativeLayout atdHeader = ViewBindings.findChildViewById(rootView, id);
      if (atdHeader == null) {
        break missingId;
      }

      id = R.id.badgeCount;
      TextView badgeCount = ViewBindings.findChildViewById(rootView, id);
      if (badgeCount == null) {
        break missingId;
      }

      id = R.id.bottomNavigationView;
      BottomNavigationView bottomNavigationView = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigationView == null) {
        break missingId;
      }

      id = R.id.bottomNavigationViewFrame;
      FrameLayout bottomNavigationViewFrame = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigationViewFrame == null) {
        break missingId;
      }

      id = R.id.cartContainer;
      FrameLayout cartContainer = ViewBindings.findChildViewById(rootView, id);
      if (cartContainer == null) {
        break missingId;
      }

      id = R.id.ivApprovals;
      ImageView ivApprovals = ViewBindings.findChildViewById(rootView, id);
      if (ivApprovals == null) {
        break missingId;
      }

      id = R.id.ivAtdCart;
      ImageView ivAtdCart = ViewBindings.findChildViewById(rootView, id);
      if (ivAtdCart == null) {
        break missingId;
      }

      id = R.id.ivAtdLogo;
      TextView ivAtdLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivAtdLogo == null) {
        break missingId;
      }

      id = R.id.ivSearch;
      ImageView ivSearch = ViewBindings.findChildViewById(rootView, id);
      if (ivSearch == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = ViewBindings.findChildViewById(rootView, id);
      if (progressbar == null) {
        break missingId;
      }

      LinearLayout rootViewHome = (LinearLayout) rootView;

      id = R.id.tvConsumerName;
      TextView tvConsumerName = ViewBindings.findChildViewById(rootView, id);
      if (tvConsumerName == null) {
        break missingId;
      }

      id = R.id.tvDate;
      TextView tvDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDate == null) {
        break missingId;
      }

      id = R.id.tvHeaderText;
      TextView tvHeaderText = ViewBindings.findChildViewById(rootView, id);
      if (tvHeaderText == null) {
        break missingId;
      }

      id = R.id.tvLocationNumber;
      TextView tvLocationNumber = ViewBindings.findChildViewById(rootView, id);
      if (tvLocationNumber == null) {
        break missingId;
      }

      id = R.id.tvOrder;
      TextView tvOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvOrder == null) {
        break missingId;
      }

      id = R.id.tvOrderConfirmation;
      TextView tvOrderConfirmation = ViewBindings.findChildViewById(rootView, id);
      if (tvOrderConfirmation == null) {
        break missingId;
      }

      id = R.id.tvOrderMessage;
      TextView tvOrderMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvOrderMessage == null) {
        break missingId;
      }

      id = R.id.tvPo;
      TextView tvPo = ViewBindings.findChildViewById(rootView, id);
      if (tvPo == null) {
        break missingId;
      }

      id = R.id.tvSaveOrder;
      TextView tvSaveOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvSaveOrder == null) {
        break missingId;
      }

      id = R.id.tvViewOrder;
      TextView tvViewOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvViewOrder == null) {
        break missingId;
      }

      id = R.id.viewHeader;
      View viewHeader = ViewBindings.findChildViewById(rootView, id);
      if (viewHeader == null) {
        break missingId;
      }

      id = R.id.viewSeperator;
      ImageView viewSeperator = ViewBindings.findChildViewById(rootView, id);
      if (viewSeperator == null) {
        break missingId;
      }

      return new FragmentHomeScreenBinding((LinearLayout) rootView, ClOrder, atdHeader, badgeCount,
          bottomNavigationView, bottomNavigationViewFrame, cartContainer, ivApprovals, ivAtdCart,
          ivAtdLogo, ivSearch, progressbar, rootViewHome, tvConsumerName, tvDate, tvHeaderText,
          tvLocationNumber, tvOrder, tvOrderConfirmation, tvOrderMessage, tvPo, tvSaveOrder,
          tvViewOrder, viewHeader, viewSeperator);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}