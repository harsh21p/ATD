// Generated by view binder compiler. Do not edit!
package com.atd.atdmobileapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.atd.atdmobileapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public final class FragmentBarcodeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ZXingScannerView scannerView;

  private FragmentBarcodeBinding(@NonNull ConstraintLayout rootView,
      @NonNull ZXingScannerView scannerView) {
    this.rootView = rootView;
    this.scannerView = scannerView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBarcodeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBarcodeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_barcode, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBarcodeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.scannerView;
      ZXingScannerView scannerView = ViewBindings.findChildViewById(rootView, id);
      if (scannerView == null) {
        break missingId;
      }

      return new FragmentBarcodeBinding((ConstraintLayout) rootView, scannerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
