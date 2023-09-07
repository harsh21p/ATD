// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.onboarding.pages;

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
public final class WelcomeToATDFragment_MembersInjector implements MembersInjector<WelcomeToATDFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public WelcomeToATDFragment_MembersInjector(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<WelcomeToATDFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new WelcomeToATDFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(WelcomeToATDFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.onboarding.pages.WelcomeToATDFragment.sharedPrefManager")
  public static void injectSharedPrefManager(WelcomeToATDFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}