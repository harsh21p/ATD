// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class CutOffTimesViewModel_Factory implements Factory<CutOffTimesViewModel> {
  @Override
  public CutOffTimesViewModel get() {
    return newInstance();
  }

  public static CutOffTimesViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CutOffTimesViewModel newInstance() {
    return new CutOffTimesViewModel();
  }

  private static final class InstanceHolder {
    private static final CutOffTimesViewModel_Factory INSTANCE = new CutOffTimesViewModel_Factory();
  }
}
