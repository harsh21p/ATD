// Generated by Dagger (https://dagger.dev).
package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals;

import com.atd.atdmobileapp.repository.ApproveRejectOrderRepository;
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
public final class SubmitApprovalsViewModel_Factory implements Factory<SubmitApprovalsViewModel> {
  private final Provider<ApproveRejectOrderRepository> approveRejectOrderRepositoryProvider;

  public SubmitApprovalsViewModel_Factory(
      Provider<ApproveRejectOrderRepository> approveRejectOrderRepositoryProvider) {
    this.approveRejectOrderRepositoryProvider = approveRejectOrderRepositoryProvider;
  }

  @Override
  public SubmitApprovalsViewModel get() {
    return newInstance(approveRejectOrderRepositoryProvider.get());
  }

  public static SubmitApprovalsViewModel_Factory create(
      Provider<ApproveRejectOrderRepository> approveRejectOrderRepositoryProvider) {
    return new SubmitApprovalsViewModel_Factory(approveRejectOrderRepositoryProvider);
  }

  public static SubmitApprovalsViewModel newInstance(
      ApproveRejectOrderRepository approveRejectOrderRepository) {
    return new SubmitApprovalsViewModel(approveRejectOrderRepository);
  }
}
