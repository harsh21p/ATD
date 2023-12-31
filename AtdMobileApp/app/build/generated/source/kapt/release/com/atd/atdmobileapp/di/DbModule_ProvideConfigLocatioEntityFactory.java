// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationEntity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DbModule_ProvideConfigLocatioEntityFactory implements Factory<ConfigLocationEntity> {
  @Override
  public ConfigLocationEntity get() {
    return provideConfigLocatioEntity();
  }

  public static DbModule_ProvideConfigLocatioEntityFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ConfigLocationEntity provideConfigLocatioEntity() {
    return Preconditions.checkNotNullFromProvides(DbModule.INSTANCE.provideConfigLocatioEntity());
  }

  private static final class InstanceHolder {
    private static final DbModule_ProvideConfigLocatioEntityFactory INSTANCE = new DbModule_ProvideConfigLocatioEntityFactory();
  }
}
