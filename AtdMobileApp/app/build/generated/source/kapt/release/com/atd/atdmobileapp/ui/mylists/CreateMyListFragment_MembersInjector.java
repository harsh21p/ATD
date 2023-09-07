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
public final class CreateMyListFragment_MembersInjector implements MembersInjector<CreateMyListFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public CreateMyListFragment_MembersInjector(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<CreateMyListFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new CreateMyListFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(CreateMyListFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.mylists.CreateMyListFragment.sharedPrefManager")
  public static void injectSharedPrefManager(CreateMyListFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
