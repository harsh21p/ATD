// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.vehicle.oesize;

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
public final class OESizeFragment_MembersInjector implements MembersInjector<OESizeFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public OESizeFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<OESizeFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new OESizeFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(OESizeFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.vehicle.oesize.OESizeFragment.sharedPrefManager")
  public static void injectSharedPrefManager(OESizeFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
