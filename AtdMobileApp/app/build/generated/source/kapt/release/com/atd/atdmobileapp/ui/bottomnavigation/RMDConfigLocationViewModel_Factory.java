// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation;

import com.atd.atdmobileapp.repository.RDBConfigLocationsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RMDConfigLocationViewModel_Factory implements Factory<RMDConfigLocationViewModel> {
  private final Provider<RDBConfigLocationsRepository> rdbConfigLocationsRepositoryProvider;

  public RMDConfigLocationViewModel_Factory(
      Provider<RDBConfigLocationsRepository> rdbConfigLocationsRepositoryProvider) {
    this.rdbConfigLocationsRepositoryProvider = rdbConfigLocationsRepositoryProvider;
  }

  @Override
  public RMDConfigLocationViewModel get() {
    return newInstance(rdbConfigLocationsRepositoryProvider.get());
  }

  public static RMDConfigLocationViewModel_Factory create(
      Provider<RDBConfigLocationsRepository> rdbConfigLocationsRepositoryProvider) {
    return new RMDConfigLocationViewModel_Factory(rdbConfigLocationsRepositoryProvider);
  }

  public static RMDConfigLocationViewModel newInstance(
      RDBConfigLocationsRepository rdbConfigLocationsRepository) {
    return new RMDConfigLocationViewModel(rdbConfigLocationsRepository);
  }
}
