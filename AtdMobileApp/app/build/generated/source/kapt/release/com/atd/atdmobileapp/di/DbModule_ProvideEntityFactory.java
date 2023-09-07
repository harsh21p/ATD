// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import com.atd.atdmobileapp.roomdatabase.keywordsearch.PreviousKeywordSearchEntity;
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
public final class DbModule_ProvideEntityFactory implements Factory<PreviousKeywordSearchEntity> {
  @Override
  public PreviousKeywordSearchEntity get() {
    return provideEntity();
  }

  public static DbModule_ProvideEntityFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PreviousKeywordSearchEntity provideEntity() {
    return Preconditions.checkNotNullFromProvides(DbModule.INSTANCE.provideEntity());
  }

  private static final class InstanceHolder {
    private static final DbModule_ProvideEntityFactory INSTANCE = new DbModule_ProvideEntityFactory();
  }
}
