// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPreferencesBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView arrow1;

  @NonNull
  public final ImageView arrow2;

  @NonNull
  public final ImageView arrow3;

  @NonNull
  public final ImageView arrow4;

  @NonNull
  public final ImageView arrow5;

  @NonNull
  public final BusinessDaysBinding businessDaysChart;

  @NonNull
  public final ConstraintLayout daysLayout;

  @NonNull
  public final ImageView ivCloseTireType;

  @NonNull
  public final TextView resetAll;

  @NonNull
  public final ScrollView scrollViewPref;

  @NonNull
  public final ToggleButton swEndOfBusinessDay;

  @NonNull
  public final ToggleButton swOrderCutOff;

  @NonNull
  public final ToggleButton swStartOfBusinessDay;

  @NonNull
  public final ToggleButton switch1;

  @NonNull
  public final TimePicker timePicker;

  @NonNull
  public final TimePicker timePickerEndTime;

  @NonNull
  public final LinearLayoutCompat tireTypesHeader;

  @NonNull
  public final TextView ttvShowProductCost;

  @NonNull
  public final TextView tvAddToCart;

  @NonNull
  public final TextView tvAddToCartValue;

  @NonNull
  public final TextView tvAvailabilityFilter;

  @NonNull
  public final TextView tvAvailabilityFilterValue;

  @NonNull
  public final TextView tvBrands;

  @NonNull
  public final TextView tvBusinessDays;

  @NonNull
  public final TextView tvEndOfBusinessDay;

  @NonNull
  public final TextView tvEndTime;

  @NonNull
  public final TextView tvEndTimeValue;

  @NonNull
  public final TextView tvFitmentResult;

  @NonNull
  public final TextView tvFitmentResultValue;

  @NonNull
  public final TextView tvMyBrands;

  @NonNull
  public final TextView tvMyBrandsValue;

  @NonNull
  public final TextView tvNotification;

  @NonNull
  public final TextView tvOrderCutOff;

  @NonNull
  public final TextView tvPricing;

  @NonNull
  public final TextView tvSave;

  @NonNull
  public final TextView tvSearchResults;

  @NonNull
  public final TextView tvSortOrder;

  @NonNull
  public final TextView tvSortOrderValue;

  @NonNull
  public final TextView tvStartOfBusinessDay;

  @NonNull
  public final TextView tvStartTime;

  @NonNull
  public final TextView tvStartTimeValue;

  @NonNull
  public final View view1;

  @NonNull
  public final View view10;

  @NonNull
  public final View view2;

  @NonNull
  public final View view3;

  @NonNull
  public final View view4;

  @NonNull
  public final View view5;

  @NonNull
  public final View view6;

  @NonNull
  public final View view7;

  @NonNull
  public final View view8;

  @NonNull
  public final View view9;

  @NonNull
  public final View viewTop;

  private FragmentPreferencesBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView arrow1,
      @NonNull ImageView arrow2, @NonNull ImageView arrow3, @NonNull ImageView arrow4,
      @NonNull ImageView arrow5, @NonNull BusinessDaysBinding businessDaysChart,
      @NonNull ConstraintLayout daysLayout, @NonNull ImageView ivCloseTireType,
      @NonNull TextView resetAll, @NonNull ScrollView scrollViewPref,
      @NonNull ToggleButton swEndOfBusinessDay, @NonNull ToggleButton swOrderCutOff,
      @NonNull ToggleButton swStartOfBusinessDay, @NonNull ToggleButton switch1,
      @NonNull TimePicker timePicker, @NonNull TimePicker timePickerEndTime,
      @NonNull LinearLayoutCompat tireTypesHeader, @NonNull TextView ttvShowProductCost,
      @NonNull TextView tvAddToCart, @NonNull TextView tvAddToCartValue,
      @NonNull TextView tvAvailabilityFilter, @NonNull TextView tvAvailabilityFilterValue,
      @NonNull TextView tvBrands, @NonNull TextView tvBusinessDays,
      @NonNull TextView tvEndOfBusinessDay, @NonNull TextView tvEndTime,
      @NonNull TextView tvEndTimeValue, @NonNull TextView tvFitmentResult,
      @NonNull TextView tvFitmentResultValue, @NonNull TextView tvMyBrands,
      @NonNull TextView tvMyBrandsValue, @NonNull TextView tvNotification,
      @NonNull TextView tvOrderCutOff, @NonNull TextView tvPricing, @NonNull TextView tvSave,
      @NonNull TextView tvSearchResults, @NonNull TextView tvSortOrder,
      @NonNull TextView tvSortOrderValue, @NonNull TextView tvStartOfBusinessDay,
      @NonNull TextView tvStartTime, @NonNull TextView tvStartTimeValue, @NonNull View view1,
      @NonNull View view10, @NonNull View view2, @NonNull View view3, @NonNull View view4,
      @NonNull View view5, @NonNull View view6, @NonNull View view7, @NonNull View view8,
      @NonNull View view9, @NonNull View viewTop) {
    this.rootView = rootView;
    this.arrow1 = arrow1;
    this.arrow2 = arrow2;
    this.arrow3 = arrow3;
    this.arrow4 = arrow4;
    this.arrow5 = arrow5;
    this.businessDaysChart = businessDaysChart;
    this.daysLayout = daysLayout;
    this.ivCloseTireType = ivCloseTireType;
    this.resetAll = resetAll;
    this.scrollViewPref = scrollViewPref;
    this.swEndOfBusinessDay = swEndOfBusinessDay;
    this.swOrderCutOff = swOrderCutOff;
    this.swStartOfBusinessDay = swStartOfBusinessDay;
    this.switch1 = switch1;
    this.timePicker = timePicker;
    this.timePickerEndTime = timePickerEndTime;
    this.tireTypesHeader = tireTypesHeader;
    this.ttvShowProductCost = ttvShowProductCost;
    this.tvAddToCart = tvAddToCart;
    this.tvAddToCartValue = tvAddToCartValue;
    this.tvAvailabilityFilter = tvAvailabilityFilter;
    this.tvAvailabilityFilterValue = tvAvailabilityFilterValue;
    this.tvBrands = tvBrands;
    this.tvBusinessDays = tvBusinessDays;
    this.tvEndOfBusinessDay = tvEndOfBusinessDay;
    this.tvEndTime = tvEndTime;
    this.tvEndTimeValue = tvEndTimeValue;
    this.tvFitmentResult = tvFitmentResult;
    this.tvFitmentResultValue = tvFitmentResultValue;
    this.tvMyBrands = tvMyBrands;
    this.tvMyBrandsValue = tvMyBrandsValue;
    this.tvNotification = tvNotification;
    this.tvOrderCutOff = tvOrderCutOff;
    this.tvPricing = tvPricing;
    this.tvSave = tvSave;
    this.tvSearchResults = tvSearchResults;
    this.tvSortOrder = tvSortOrder;
    this.tvSortOrderValue = tvSortOrderValue;
    this.tvStartOfBusinessDay = tvStartOfBusinessDay;
    this.tvStartTime = tvStartTime;
    this.tvStartTimeValue = tvStartTimeValue;
    this.view1 = view1;
    this.view10 = view10;
    this.view2 = view2;
    this.view3 = view3;
    this.view4 = view4;
    this.view5 = view5;
    this.view6 = view6;
    this.view7 = view7;
    this.view8 = view8;
    this.view9 = view9;
    this.viewTop = viewTop;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPreferencesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPreferencesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_preferences, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPreferencesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.arrow1;
      ImageView arrow1 = ViewBindings.findChildViewById(rootView, id);
      if (arrow1 == null) {
        break missingId;
      }

      id = R.id.arrow2;
      ImageView arrow2 = ViewBindings.findChildViewById(rootView, id);
      if (arrow2 == null) {
        break missingId;
      }

      id = R.id.arrow3;
      ImageView arrow3 = ViewBindings.findChildViewById(rootView, id);
      if (arrow3 == null) {
        break missingId;
      }

      id = R.id.arrow4;
      ImageView arrow4 = ViewBindings.findChildViewById(rootView, id);
      if (arrow4 == null) {
        break missingId;
      }

      id = R.id.arrow5;
      ImageView arrow5 = ViewBindings.findChildViewById(rootView, id);
      if (arrow5 == null) {
        break missingId;
      }

      id = R.id.businessDaysChart;
      View businessDaysChart = ViewBindings.findChildViewById(rootView, id);
      if (businessDaysChart == null) {
        break missingId;
      }
      BusinessDaysBinding binding_businessDaysChart = BusinessDaysBinding.bind(businessDaysChart);

      id = R.id.daysLayout;
      ConstraintLayout daysLayout = ViewBindings.findChildViewById(rootView, id);
      if (daysLayout == null) {
        break missingId;
      }

      id = R.id.ivCloseTireType;
      ImageView ivCloseTireType = ViewBindings.findChildViewById(rootView, id);
      if (ivCloseTireType == null) {
        break missingId;
      }

      id = R.id.resetAll;
      TextView resetAll = ViewBindings.findChildViewById(rootView, id);
      if (resetAll == null) {
        break missingId;
      }

      id = R.id.scrollViewPref;
      ScrollView scrollViewPref = ViewBindings.findChildViewById(rootView, id);
      if (scrollViewPref == null) {
        break missingId;
      }

      id = R.id.swEndOfBusinessDay;
      ToggleButton swEndOfBusinessDay = ViewBindings.findChildViewById(rootView, id);
      if (swEndOfBusinessDay == null) {
        break missingId;
      }

      id = R.id.swOrderCutOff;
      ToggleButton swOrderCutOff = ViewBindings.findChildViewById(rootView, id);
      if (swOrderCutOff == null) {
        break missingId;
      }

      id = R.id.swStartOfBusinessDay;
      ToggleButton swStartOfBusinessDay = ViewBindings.findChildViewById(rootView, id);
      if (swStartOfBusinessDay == null) {
        break missingId;
      }

      id = R.id.switch1;
      ToggleButton switch1 = ViewBindings.findChildViewById(rootView, id);
      if (switch1 == null) {
        break missingId;
      }

      id = R.id.timePicker;
      TimePicker timePicker = ViewBindings.findChildViewById(rootView, id);
      if (timePicker == null) {
        break missingId;
      }

      id = R.id.timePickerEndTime;
      TimePicker timePickerEndTime = ViewBindings.findChildViewById(rootView, id);
      if (timePickerEndTime == null) {
        break missingId;
      }

      id = R.id.tireTypesHeader;
      LinearLayoutCompat tireTypesHeader = ViewBindings.findChildViewById(rootView, id);
      if (tireTypesHeader == null) {
        break missingId;
      }

      id = R.id.ttvShowProductCost;
      TextView ttvShowProductCost = ViewBindings.findChildViewById(rootView, id);
      if (ttvShowProductCost == null) {
        break missingId;
      }

      id = R.id.tvAddToCart;
      TextView tvAddToCart = ViewBindings.findChildViewById(rootView, id);
      if (tvAddToCart == null) {
        break missingId;
      }

      id = R.id.tvAddToCartValue;
      TextView tvAddToCartValue = ViewBindings.findChildViewById(rootView, id);
      if (tvAddToCartValue == null) {
        break missingId;
      }

      id = R.id.tvAvailabilityFilter;
      TextView tvAvailabilityFilter = ViewBindings.findChildViewById(rootView, id);
      if (tvAvailabilityFilter == null) {
        break missingId;
      }

      id = R.id.tvAvailabilityFilterValue;
      TextView tvAvailabilityFilterValue = ViewBindings.findChildViewById(rootView, id);
      if (tvAvailabilityFilterValue == null) {
        break missingId;
      }

      id = R.id.tvBrands;
      TextView tvBrands = ViewBindings.findChildViewById(rootView, id);
      if (tvBrands == null) {
        break missingId;
      }

      id = R.id.tvBusinessDays;
      TextView tvBusinessDays = ViewBindings.findChildViewById(rootView, id);
      if (tvBusinessDays == null) {
        break missingId;
      }

      id = R.id.tvEndOfBusinessDay;
      TextView tvEndOfBusinessDay = ViewBindings.findChildViewById(rootView, id);
      if (tvEndOfBusinessDay == null) {
        break missingId;
      }

      id = R.id.tvEndTime;
      TextView tvEndTime = ViewBindings.findChildViewById(rootView, id);
      if (tvEndTime == null) {
        break missingId;
      }

      id = R.id.tvEndTimeValue;
      TextView tvEndTimeValue = ViewBindings.findChildViewById(rootView, id);
      if (tvEndTimeValue == null) {
        break missingId;
      }

      id = R.id.tvFitmentResult;
      TextView tvFitmentResult = ViewBindings.findChildViewById(rootView, id);
      if (tvFitmentResult == null) {
        break missingId;
      }

      id = R.id.tvFitmentResultValue;
      TextView tvFitmentResultValue = ViewBindings.findChildViewById(rootView, id);
      if (tvFitmentResultValue == null) {
        break missingId;
      }

      id = R.id.tvMyBrands;
      TextView tvMyBrands = ViewBindings.findChildViewById(rootView, id);
      if (tvMyBrands == null) {
        break missingId;
      }

      id = R.id.tvMyBrandsValue;
      TextView tvMyBrandsValue = ViewBindings.findChildViewById(rootView, id);
      if (tvMyBrandsValue == null) {
        break missingId;
      }

      id = R.id.tvNotification;
      TextView tvNotification = ViewBindings.findChildViewById(rootView, id);
      if (tvNotification == null) {
        break missingId;
      }

      id = R.id.tvOrderCutOff;
      TextView tvOrderCutOff = ViewBindings.findChildViewById(rootView, id);
      if (tvOrderCutOff == null) {
        break missingId;
      }

      id = R.id.tvPricing;
      TextView tvPricing = ViewBindings.findChildViewById(rootView, id);
      if (tvPricing == null) {
        break missingId;
      }

      id = R.id.tvSave;
      TextView tvSave = ViewBindings.findChildViewById(rootView, id);
      if (tvSave == null) {
        break missingId;
      }

      id = R.id.tvSearchResults;
      TextView tvSearchResults = ViewBindings.findChildViewById(rootView, id);
      if (tvSearchResults == null) {
        break missingId;
      }

      id = R.id.tvSortOrder;
      TextView tvSortOrder = ViewBindings.findChildViewById(rootView, id);
      if (tvSortOrder == null) {
        break missingId;
      }

      id = R.id.tvSortOrderValue;
      TextView tvSortOrderValue = ViewBindings.findChildViewById(rootView, id);
      if (tvSortOrderValue == null) {
        break missingId;
      }

      id = R.id.tvStartOfBusinessDay;
      TextView tvStartOfBusinessDay = ViewBindings.findChildViewById(rootView, id);
      if (tvStartOfBusinessDay == null) {
        break missingId;
      }

      id = R.id.tvStartTime;
      TextView tvStartTime = ViewBindings.findChildViewById(rootView, id);
      if (tvStartTime == null) {
        break missingId;
      }

      id = R.id.tvStartTimeValue;
      TextView tvStartTimeValue = ViewBindings.findChildViewById(rootView, id);
      if (tvStartTimeValue == null) {
        break missingId;
      }

      id = R.id.view1;
      View view1 = ViewBindings.findChildViewById(rootView, id);
      if (view1 == null) {
        break missingId;
      }

      id = R.id.view10;
      View view10 = ViewBindings.findChildViewById(rootView, id);
      if (view10 == null) {
        break missingId;
      }

      id = R.id.view2;
      View view2 = ViewBindings.findChildViewById(rootView, id);
      if (view2 == null) {
        break missingId;
      }

      id = R.id.view3;
      View view3 = ViewBindings.findChildViewById(rootView, id);
      if (view3 == null) {
        break missingId;
      }

      id = R.id.view4;
      View view4 = ViewBindings.findChildViewById(rootView, id);
      if (view4 == null) {
        break missingId;
      }

      id = R.id.view5;
      View view5 = ViewBindings.findChildViewById(rootView, id);
      if (view5 == null) {
        break missingId;
      }

      id = R.id.view6;
      View view6 = ViewBindings.findChildViewById(rootView, id);
      if (view6 == null) {
        break missingId;
      }

      id = R.id.view7;
      View view7 = ViewBindings.findChildViewById(rootView, id);
      if (view7 == null) {
        break missingId;
      }

      id = R.id.view8;
      View view8 = ViewBindings.findChildViewById(rootView, id);
      if (view8 == null) {
        break missingId;
      }

      id = R.id.view9;
      View view9 = ViewBindings.findChildViewById(rootView, id);
      if (view9 == null) {
        break missingId;
      }

      id = R.id.viewTop;
      View viewTop = ViewBindings.findChildViewById(rootView, id);
      if (viewTop == null) {
        break missingId;
      }

      return new FragmentPreferencesBinding((ConstraintLayout) rootView, arrow1, arrow2, arrow3,
          arrow4, arrow5, binding_businessDaysChart, daysLayout, ivCloseTireType, resetAll,
          scrollViewPref, swEndOfBusinessDay, swOrderCutOff, swStartOfBusinessDay, switch1,
          timePicker, timePickerEndTime, tireTypesHeader, ttvShowProductCost, tvAddToCart,
          tvAddToCartValue, tvAvailabilityFilter, tvAvailabilityFilterValue, tvBrands,
          tvBusinessDays, tvEndOfBusinessDay, tvEndTime, tvEndTimeValue, tvFitmentResult,
          tvFitmentResultValue, tvMyBrands, tvMyBrandsValue, tvNotification, tvOrderCutOff,
          tvPricing, tvSave, tvSearchResults, tvSortOrder, tvSortOrderValue, tvStartOfBusinessDay,
          tvStartTime, tvStartTimeValue, view1, view10, view2, view3, view4, view5, view6, view7,
          view8, view9, viewTop);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
