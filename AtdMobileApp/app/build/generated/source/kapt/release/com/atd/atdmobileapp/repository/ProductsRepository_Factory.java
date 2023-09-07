// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.repository;

import com.atd.atdmobileapp.api.ProductsApi;
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
public final class ProductsRepository_Factory implements Factory<ProductsRepository> {
  private final Provider<ProductsApi> productsApiProvider;

  public ProductsRepository_Factory(Provider<ProductsApi> productsApiProvider) {
    this.productsApiProvider = productsApiProvider;
  }

  @Override
  public ProductsRepository get() {
    return newInstance(productsApiProvider.get());
  }

  public static ProductsRepository_Factory create(Provider<ProductsApi> productsApiProvider) {
    return new ProductsRepository_Factory(productsApiProvider);
  }

  public static ProductsRepository newInstance(ProductsApi productsApi) {
    return new ProductsRepository(productsApi);
  }
}