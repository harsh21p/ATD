// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<Context> contextProvider;

  public MainViewModel_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(contextProvider.get());
  }

  public static MainViewModel_Factory create(Provider<Context> contextProvider) {
    return new MainViewModel_Factory(contextProvider);
  }

  public static MainViewModel newInstance(Context context) {
    return new MainViewModel(context);
  }
}
