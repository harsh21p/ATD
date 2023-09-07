// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import com.atd.atdmobileapp.api.OrderApi;
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
public final class NetworkModule_ProvideOrderApiFactory implements Factory<OrderApi> {
  private final NetworkModule module;

  private final Provider<Retrofit.Builder> retrofitBuilderProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvideOrderApiFactory(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.retrofitBuilderProvider = retrofitBuilderProvider;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public OrderApi get() {
    return provideOrderApi(module, retrofitBuilderProvider.get(), okHttpClientProvider.get());
  }

  public static NetworkModule_ProvideOrderApiFactory create(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvideOrderApiFactory(module, retrofitBuilderProvider, okHttpClientProvider);
  }

  public static OrderApi provideOrderApi(NetworkModule instance, Retrofit.Builder retrofitBuilder,
      OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideOrderApi(retrofitBuilder, okHttpClient));
  }
}
