// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.api;

import android.content.Context;
import com.atd.atdmobileapp.utils.SharedPrefManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthInterceptor_Factory implements Factory<AuthInterceptor> {
  private final Provider<Context> contextProvider;

  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public AuthInterceptor_Factory(Provider<Context> contextProvider,
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.contextProvider = contextProvider;
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  @Override
  public AuthInterceptor get() {
    AuthInterceptor instance = newInstance(contextProvider.get());
    AuthInterceptor_MembersInjector.injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
    return instance;
  }

  public static AuthInterceptor_Factory create(Provider<Context> contextProvider,
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new AuthInterceptor_Factory(contextProvider, sharedPrefManagerProvider);
  }

  public static AuthInterceptor newInstance(Context context) {
    return new AuthInterceptor(context);
  }
}
