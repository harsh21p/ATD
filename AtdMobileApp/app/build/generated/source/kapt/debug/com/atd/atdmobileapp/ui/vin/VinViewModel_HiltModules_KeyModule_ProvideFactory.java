// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.vin;

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
public final class VinViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static VinViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(VinViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final VinViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new VinViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
