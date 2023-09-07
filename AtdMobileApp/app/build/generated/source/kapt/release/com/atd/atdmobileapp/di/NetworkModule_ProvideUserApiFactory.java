// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import com.atd.atdmobileapp.api.UserApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideUserApiFactory implements Factory<UserApi> {
  private final NetworkModule module;

  private final Provider<Retrofit.Builder> retrofitBuilderProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvideUserApiFactory(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.retrofitBuilderProvider = retrofitBuilderProvider;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public UserApi get() {
    return provideUserApi(module, retrofitBuilderProvider.get(), okHttpClientProvider.get());
  }

  public static NetworkModule_ProvideUserApiFactory create(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvideUserApiFactory(module, retrofitBuilderProvider, okHttpClientProvider);
  }

  public static UserApi provideUserApi(NetworkModule instance, Retrofit.Builder retrofitBuilder,
      OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideUserApi(retrofitBuilder, okHttpClient));
  }
}