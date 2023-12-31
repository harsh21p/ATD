// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.rebate;

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
public final class RebateFragment_MembersInjector implements MembersInjector<RebateFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public RebateFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<RebateFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new RebateFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(RebateFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.rebate.RebateFragment.sharedPrefManager")
  public static void injectSharedPrefManager(RebateFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
