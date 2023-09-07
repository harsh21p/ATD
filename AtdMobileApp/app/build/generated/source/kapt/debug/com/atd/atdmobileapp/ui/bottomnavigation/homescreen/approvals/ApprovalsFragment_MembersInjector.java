// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals;

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
public final class ApprovalsFragment_MembersInjector implements MembersInjector<ApprovalsFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public ApprovalsFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<ApprovalsFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new ApprovalsFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(ApprovalsFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.ApprovalsFragment.sharedPrefManager")
  public static void injectSharedPrefManager(ApprovalsFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
