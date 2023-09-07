// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.repository;

import com.atd.atdmobileapp.api.ListApi;
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
public final class MyListRepository_Factory implements Factory<MyListRepository> {
  private final Provider<ListApi> listApiProvider;

  public MyListRepository_Factory(Provider<ListApi> listApiProvider) {
    this.listApiProvider = listApiProvider;
  }

  @Override
  public MyListRepository get() {
    return newInstance(listApiProvider.get());
  }

  public static MyListRepository_Factory create(Provider<ListApi> listApiProvider) {
    return new MyListRepository_Factory(listApiProvider);
  }

  public static MyListRepository newInstance(ListApi listApi) {
    return new MyListRepository(listApi);
  }
}
