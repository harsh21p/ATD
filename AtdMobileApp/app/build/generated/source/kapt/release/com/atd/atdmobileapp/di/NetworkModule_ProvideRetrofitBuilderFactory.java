// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideRetrofitBuilderFactory implements Factory<Retrofit.Builder> {
  private final NetworkModule module;

  public NetworkModule_ProvideRetrofitBuilderFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public Retrofit.Builder get() {
    return provideRetrofitBuilder(module);
  }

  public static NetworkModule_ProvideRetrofitBuilderFactory create(NetworkModule module) {
    return new NetworkModule_ProvideRetrofitBuilderFactory(module);
  }

  public static Retrofit.Builder provideRetrofitBuilder(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideRetrofitBuilder());
  }
}
