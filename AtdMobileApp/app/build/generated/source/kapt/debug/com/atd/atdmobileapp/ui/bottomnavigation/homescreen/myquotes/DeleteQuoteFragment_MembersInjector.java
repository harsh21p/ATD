// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes;

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
public final class DeleteQuoteFragment_MembersInjector implements MembersInjector<DeleteQuoteFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public DeleteQuoteFragment_MembersInjector(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<DeleteQuoteFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new DeleteQuoteFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(DeleteQuoteFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.DeleteQuoteFragment.sharedPrefManager")
  public static void injectSharedPrefManager(DeleteQuoteFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
