// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.mylists;

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
public final class FrequencyDialog_MembersInjector implements MembersInjector<FrequencyDialog> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public FrequencyDialog_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<FrequencyDialog> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new FrequencyDialog_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(FrequencyDialog instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.mylists.FrequencyDialog.sharedPrefManager")
  public static void injectSharedPrefManager(FrequencyDialog instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
