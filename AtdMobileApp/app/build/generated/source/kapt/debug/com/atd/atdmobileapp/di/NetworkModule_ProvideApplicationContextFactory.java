// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideApplicationContextFactory implements Factory<Context> {
  private final NetworkModule module;

  private final Provider<Application> applicationProvider;

  public NetworkModule_ProvideApplicationContextFactory(NetworkModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Context get() {
    return provideApplicationContext(module, applicationProvider.get());
  }

  public static NetworkModule_ProvideApplicationContextFactory create(NetworkModule module,
      Provider<Application> applicationProvider) {
    return new NetworkModule_ProvideApplicationContextFactory(module, applicationProvider);
  }

  public static Context provideApplicationContext(NetworkModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideApplicationContext(application));
  }
}
