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
public final class EditQuoteFragment_MembersInjector implements MembersInjector<EditQuoteFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public EditQuoteFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<EditQuoteFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new EditQuoteFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(EditQuoteFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.EditQuoteFragment.sharedPrefManager")
  public static void injectSharedPrefManager(EditQuoteFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
