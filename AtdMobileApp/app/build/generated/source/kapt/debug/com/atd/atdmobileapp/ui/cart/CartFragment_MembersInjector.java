// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.cart;

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
public final class CartFragment_MembersInjector implements MembersInjector<CartFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public CartFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<CartFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new CartFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(CartFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.cart.CartFragment.sharedPrefManager")
  public static void injectSharedPrefManager(CartFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}
