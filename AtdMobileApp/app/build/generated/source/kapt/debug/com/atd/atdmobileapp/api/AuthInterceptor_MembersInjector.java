// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.api;

import com.atd.atdmobileapp.utils.SharedPrefManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthInterceptor_MembersInjector implements MembersInjector<AuthInterceptor> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public AuthInterceptor_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<AuthInterceptor> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new AuthInterceptor_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(AuthInterceptor instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.api.AuthInterceptor.sharedPrefManager")
  public static void injectSharedPrefManager(AuthInterceptor instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}