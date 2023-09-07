// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.cart.checkout;

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
public final class CheckoutFragment_MembersInjector implements MembersInjector<CheckoutFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public CheckoutFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<CheckoutFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new CheckoutFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(CheckoutFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.cart.checkout.CheckoutFragment.sharedPrefManager")
  public static void injectSharedPrefManager(CheckoutFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
