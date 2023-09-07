// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.barcode;

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
public final class BarcodeSearchFragment_MembersInjector implements MembersInjector<BarcodeSearchFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public BarcodeSearchFragment_MembersInjector(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<BarcodeSearchFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new BarcodeSearchFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(BarcodeSearchFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.barcode.BarcodeSearchFragment.sharedPrefManager")
  public static void injectSharedPrefManager(BarcodeSearchFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
