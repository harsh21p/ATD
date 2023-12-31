// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.repository;

import com.atd.atdmobileapp.roomdatabase.configlocations.ConfigLocationsDAO;
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
public final class RDBConfigLocationsRepository_Factory implements Factory<RDBConfigLocationsRepository> {
  private final Provider<ConfigLocationsDAO> daoProvider;

  public RDBConfigLocationsRepository_Factory(Provider<ConfigLocationsDAO> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public RDBConfigLocationsRepository get() {
    return newInstance(daoProvider.get());
  }

  public static RDBConfigLocationsRepository_Factory create(
      Provider<ConfigLocationsDAO> daoProvider) {
    return new RDBConfigLocationsRepository_Factory(daoProvider);
  }

  public static RDBConfigLocationsRepository newInstance(ConfigLocationsDAO dao) {
    return new RDBConfigLocationsRepository(dao);
  }
}
