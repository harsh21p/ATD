// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.licenceplate;

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
public final class LicencePlateFragment_MembersInjector implements MembersInjector<LicencePlateFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public LicencePlateFragment_MembersInjector(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<LicencePlateFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new LicencePlateFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(LicencePlateFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.licenceplate.LicencePlateFragment.sharedPrefManager")
  public static void injectSharedPrefManager(LicencePlateFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
