// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals;

import com.atd.atdmobileapp.repository.MyApprovalsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MyApprovalsViewModel_Factory implements Factory<MyApprovalsViewModel> {
  private final Provider<MyApprovalsRepository> myOrderRepositoryProvider;

  public MyApprovalsViewModel_Factory(Provider<MyApprovalsRepository> myOrderRepositoryProvider) {
    this.myOrderRepositoryProvider = myOrderRepositoryProvider;
  }

  @Override
  public MyApprovalsViewModel get() {
    return newInstance(myOrderRepositoryProvider.get());
  }

  public static MyApprovalsViewModel_Factory create(
      Provider<MyApprovalsRepository> myOrderRepositoryProvider) {
    return new MyApprovalsViewModel_Factory(myOrderRepositoryProvider);
  }

  public static MyApprovalsViewModel newInstance(MyApprovalsRepository myOrderRepository) {
    return new MyApprovalsViewModel(myOrderRepository);
  }
}
