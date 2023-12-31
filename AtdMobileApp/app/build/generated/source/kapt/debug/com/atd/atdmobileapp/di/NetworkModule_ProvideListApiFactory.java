// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import com.atd.atdmobileapp.api.ListApi;
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
public final class NetworkModule_ProvideListApiFactory implements Factory<ListApi> {
  private final NetworkModule module;

  private final Provider<Retrofit.Builder> retrofitBuilderProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public NetworkModule_ProvideListApiFactory(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.retrofitBuilderProvider = retrofitBuilderProvider;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public ListApi get() {
    return provideListApi(module, retrofitBuilderProvider.get(), okHttpClientProvider.get());
  }

  public static NetworkModule_ProvideListApiFactory create(NetworkModule module,
      Provider<Retrofit.Builder> retrofitBuilderProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new NetworkModule_ProvideListApiFactory(module, retrofitBuilderProvider, okHttpClientProvider);
  }

  public static ListApi provideListApi(NetworkModule instance, Retrofit.Builder retrofitBuilder,
      OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideListApi(retrofitBuilder, okHttpClient));
  }
}
