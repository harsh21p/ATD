// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.mygarage;

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
public final class MyGarageFragment_MembersInjector implements MembersInjector<MyGarageFragment> {
  private final Provider<SharedPrefManager> sharedPrefManagerProvider;

  public MyGarageFragment_MembersInjector(Provider<SharedPrefManager> sharedPrefManagerProvider) {
    this.sharedPrefManagerProvider = sharedPrefManagerProvider;
  }

  public static MembersInjector<MyGarageFragment> create(
      Provider<SharedPrefManager> sharedPrefManagerProvider) {
    return new MyGarageFragment_MembersInjector(sharedPrefManagerProvider);
  }

  @Override
  public void injectMembers(MyGarageFragment instance) {
    injectSharedPrefManager(instance, sharedPrefManagerProvider.get());
  }

  @InjectedFieldSignature("com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageFragment.sharedPrefManager")
  public static void injectSharedPrefManager(MyGarageFragment instance,
      SharedPrefManager sharedPrefManager) {
    instance.sharedPrefManager = sharedPrefManager;
  }
}