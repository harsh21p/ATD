// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.repository;

import com.atd.atdmobileapp.api.UserApi;
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
public final class ConfigLocationRepository_Factory implements Factory<ConfigLocationRepository> {
  private final Provider<UserApi> userApiProvider;

  public ConfigLocationRepository_Factory(Provider<UserApi> userApiProvider) {
    this.userApiProvider = userApiProvider;
  }

  @Override
  public ConfigLocationRepository get() {
    return newInstance(userApiProvider.get());
  }

  public static ConfigLocationRepository_Factory create(Provider<UserApi> userApiProvider) {
    return new ConfigLocationRepository_Factory(userApiProvider);
  }

  public static ConfigLocationRepository newInstance(UserApi userApi) {
    return new ConfigLocationRepository(userApi);
  }
}
