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
public final class ProductByCriteriaRepository_Factory implements Factory<ProductByCriteriaRepository> {
  private final Provider<ProductsApi> productApiProvider;

  public ProductByCriteriaRepository_Factory(Provider<ProductsApi> productApiProvider) {
    this.productApiProvider = productApiProvider;
  }

  @Override
  public ProductByCriteriaRepository get() {
    return newInstance(productApiProvider.get());
  }

  public static ProductByCriteriaRepository_Factory create(
      Provider<ProductsApi> productApiProvider) {
    return new ProductByCriteriaRepository_Factory(productApiProvider);
  }

  public static ProductByCriteriaRepository newInstance(ProductsApi productApi) {
    return new ProductByCriteriaRepository(productApi);
  }
}