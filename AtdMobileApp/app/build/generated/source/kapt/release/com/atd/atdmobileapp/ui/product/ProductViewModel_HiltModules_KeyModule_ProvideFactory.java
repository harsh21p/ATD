// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.product;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProductViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static ProductViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(ProductViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final ProductViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ProductViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}