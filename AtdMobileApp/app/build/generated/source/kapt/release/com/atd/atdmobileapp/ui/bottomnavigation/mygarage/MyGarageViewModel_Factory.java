// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.mygarage;

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
public final class MyGarageViewModel_Factory implements Factory<MyGarageViewModel> {
  @Override
  public MyGarageViewModel get() {
    return newInstance();
  }

  public static MyGarageViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MyGarageViewModel newInstance() {
    return new MyGarageViewModel();
  }

  private static final class InstanceHolder {
    private static final MyGarageViewModel_Factory INSTANCE = new MyGarageViewModel_Factory();
  }
}
