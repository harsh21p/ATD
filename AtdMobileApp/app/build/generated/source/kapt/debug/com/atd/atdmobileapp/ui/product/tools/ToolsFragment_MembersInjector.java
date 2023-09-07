// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.product.tools;

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
public final class ToolsFragment_MembersInjector implements MembersInjector<ToolsFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public ToolsFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<ToolsFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new ToolsFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(ToolsFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.product.tools.ToolsFragment.sharedPrefManager")
  public static void injectSharedPrefManager(ToolsFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}