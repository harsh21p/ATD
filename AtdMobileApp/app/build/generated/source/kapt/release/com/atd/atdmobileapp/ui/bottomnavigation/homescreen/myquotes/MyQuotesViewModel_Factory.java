// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes;

import com.atd.atdmobileapp.repository.MyQuotesRepository;
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
public final class MyQuotesViewModel_Factory implements Factory<MyQuotesViewModel> {
  private final Provider<MyQuotesRepository> myQuotesRepositoryProvider;

  public MyQuotesViewModel_Factory(Provider<MyQuotesRepository> myQuotesRepositoryProvider) {
    this.myQuotesRepositoryProvider = myQuotesRepositoryProvider;
  }

  @Override
  public MyQuotesViewModel get() {
    return newInstance(myQuotesRepositoryProvider.get());
  }

  public static MyQuotesViewModel_Factory create(
      Provider<MyQuotesRepository> myQuotesRepositoryProvider) {
    return new MyQuotesViewModel_Factory(myQuotesRepositoryProvider);
  }

  public static MyQuotesViewModel newInstance(MyQuotesRepository myQuotesRepository) {
    return new MyQuotesViewModel(myQuotesRepository);
  }
}
