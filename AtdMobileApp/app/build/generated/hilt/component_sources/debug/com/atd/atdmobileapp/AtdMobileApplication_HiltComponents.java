package com.atd.atdmobileapp;

import com.atd.atdmobileapp.di.DbModule;
import com.atd.atdmobileapp.di.FirebaseModule;
import com.atd.atdmobileapp.di.NetworkModule;
import com.atd.atdmobileapp.ui.barcode.BarcodeSearchFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.BottomNavigationScreenFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.ConfigLocationViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.RMDConfigLocationViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.account.AccountFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.account.AccountViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.account.preferences.PreferencesFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.HomeViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.ApprovalsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.MyApprovalsViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.approvals.submitaprovals.SubmitApprovalsViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersSearchFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.MyOrdersViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrderDetailsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myorders.myorderdetails.MyOrderDetailsViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.DeleteQuoteFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.EditQuoteFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.MyQuotesViewModel_HiltModules;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.MyQuotsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes.ViewMyQuotesFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.hometabscreen.HomeTabFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.bottomnavigation.mygarage.MyGarageFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.cart.CartFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.cart.CartViewModel_HiltModules;
import com.atd.atdmobileapp.ui.cart.checkout.CheckoutFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.cart.checkout.CheckoutViewModel_HiltModules;
import com.atd.atdmobileapp.ui.cart.deliverydayandwindow.DeliveryDayAndWindowFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.cart.deliverydayandwindow.DeliveryDayAndWindowViewModel_HiltModules;
import com.atd.atdmobileapp.ui.cart.quantityanddelivery.QuantityAndDeliveryFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.cart.quantityanddelivery.QuantityAndDeliveryViewModel_HiltModules;
import com.atd.atdmobileapp.ui.chooseprofile.ChooseProfileFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.KeyWordSearchFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.keywordsearch.keywordrecentsearches.RecentKeywordSearchViewModel_HiltModules;
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.CutOffTimesViewModel_HiltModules;
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.KeywordSearchResultsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.keywordsearch.keywordsearchresults.ProductByKeywordViewModel_HiltModules;
import com.atd.atdmobileapp.ui.licenceplate.LicencePlateFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.licenceplate.LicencePlateViewModel_HiltModules;
import com.atd.atdmobileapp.ui.licenceplate.OCRLicencePlate_GeneratedInjector;
import com.atd.atdmobileapp.ui.login.LoginFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.login.LoginViewModel_HiltModules;
import com.atd.atdmobileapp.ui.mylists.CreateMyListFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.mylists.FrequencyDialog_GeneratedInjector;
import com.atd.atdmobileapp.ui.mylists.MyListDetailsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.mylists.MyListFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.mylists.MyListViewModel_HiltModules;
import com.atd.atdmobileapp.ui.onboarding.pages.ProductDeliveryFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.onboarding.pages.StreamLinedSearchFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.onboarding.pages.WelcomeToATDFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.ProductFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.ProductViewModel_HiltModules;
import com.atd.atdmobileapp.ui.product.TubesAndFlapsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.supplies.SuppliesFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.tirerepair.TireRepairFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.tires.TiresFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.tires.brands.TiresBrandsViewModel_HiltModules;
import com.atd.atdmobileapp.ui.product.tools.ToolsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.wheelaccessories.WheelAccessoriesFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.product.wheels.WheelsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.productdetails.ProductDetailsFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.rebate.RebateFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.selectlocation.SelectLocationViewModel_HiltModules;
import com.atd.atdmobileapp.ui.selectlocation.SelectLocation_GeneratedInjector;
import com.atd.atdmobileapp.ui.splash.SplashFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.VehicleSearch_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.VehicleViewModel_HiltModules;
import com.atd.atdmobileapp.ui.vehicle.make.MakeFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.model.ModelFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.oesize.OESizeFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.positionandsize.SizeFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.trim.TrimFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vehicle.year.YearFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vin.BarcodeFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vin.VINFragment_GeneratedInjector;
import com.atd.atdmobileapp.ui.vin.VinViewModel_HiltModules;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.inject.Singleton;

public final class AtdMobileApplication_HiltComponents {
  private AtdMobileApplication_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          ApplicationContextModule.class,
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class,
          DbModule.class,
          FirebaseModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          NetworkModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements AtdMobileApplication_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AccountViewModel_HiltModules.KeyModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          CartViewModel_HiltModules.KeyModule.class,
          CheckoutViewModel_HiltModules.KeyModule.class,
          ConfigLocationViewModel_HiltModules.KeyModule.class,
          CutOffTimesViewModel_HiltModules.KeyModule.class,
          DeliveryDayAndWindowViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          HomeViewModel_HiltModules.KeyModule.class,
          LicencePlateViewModel_HiltModules.KeyModule.class,
          LoginViewModel_HiltModules.KeyModule.class,
          MainViewModel_HiltModules.KeyModule.class,
          MyApprovalsViewModel_HiltModules.KeyModule.class,
          MyListViewModel_HiltModules.KeyModule.class,
          MyOrderDetailsViewModel_HiltModules.KeyModule.class,
          MyOrdersViewModel_HiltModules.KeyModule.class,
          MyQuotesViewModel_HiltModules.KeyModule.class,
          ProductByKeywordViewModel_HiltModules.KeyModule.class,
          ProductViewModel_HiltModules.KeyModule.class,
          QuantityAndDeliveryViewModel_HiltModules.KeyModule.class,
          RMDConfigLocationViewModel_HiltModules.KeyModule.class,
          RecentKeywordSearchViewModel_HiltModules.KeyModule.class,
          SelectLocationViewModel_HiltModules.KeyModule.class,
          SubmitApprovalsViewModel_HiltModules.KeyModule.class,
          TiresBrandsViewModel_HiltModules.KeyModule.class,
          VehicleViewModel_HiltModules.KeyModule.class,
          VinViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class,
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements MainActivity_GeneratedInjector,
      OCRLicencePlate_GeneratedInjector,
      BarcodeFragment_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AccountViewModel_HiltModules.BindsModule.class,
          CartViewModel_HiltModules.BindsModule.class,
          CheckoutViewModel_HiltModules.BindsModule.class,
          ConfigLocationViewModel_HiltModules.BindsModule.class,
          CutOffTimesViewModel_HiltModules.BindsModule.class,
          DeliveryDayAndWindowViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          HomeViewModel_HiltModules.BindsModule.class,
          LicencePlateViewModel_HiltModules.BindsModule.class,
          LoginViewModel_HiltModules.BindsModule.class,
          MainViewModel_HiltModules.BindsModule.class,
          MyApprovalsViewModel_HiltModules.BindsModule.class,
          MyListViewModel_HiltModules.BindsModule.class,
          MyOrderDetailsViewModel_HiltModules.BindsModule.class,
          MyOrdersViewModel_HiltModules.BindsModule.class,
          MyQuotesViewModel_HiltModules.BindsModule.class,
          ProductByKeywordViewModel_HiltModules.BindsModule.class,
          ProductViewModel_HiltModules.BindsModule.class,
          QuantityAndDeliveryViewModel_HiltModules.BindsModule.class,
          RMDConfigLocationViewModel_HiltModules.BindsModule.class,
          RecentKeywordSearchViewModel_HiltModules.BindsModule.class,
          SelectLocationViewModel_HiltModules.BindsModule.class,
          SubmitApprovalsViewModel_HiltModules.BindsModule.class,
          TiresBrandsViewModel_HiltModules.BindsModule.class,
          VehicleViewModel_HiltModules.BindsModule.class,
          VinViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements BarcodeSearchFragment_GeneratedInjector,
      BottomNavigationScreenFragment_GeneratedInjector,
      AccountFragment_GeneratedInjector,
      PreferencesFragment_GeneratedInjector,
      ApprovalsFragment_GeneratedInjector,
      SubmitApprovalsFragment_GeneratedInjector,
      MyOrdersFragment_GeneratedInjector,
      MyOrdersSearchFragment_GeneratedInjector,
      MyOrderDetailsFragment_GeneratedInjector,
      DeleteQuoteFragment_GeneratedInjector,
      EditQuoteFragment_GeneratedInjector,
      MyQuotsFragment_GeneratedInjector,
      ViewMyQuotesFragment_GeneratedInjector,
      HomeTabFragment_GeneratedInjector,
      MyGarageFragment_GeneratedInjector,
      CartFragment_GeneratedInjector,
      CheckoutFragment_GeneratedInjector,
      DeliveryDayAndWindowFragment_GeneratedInjector,
      QuantityAndDeliveryFragment_GeneratedInjector,
      ChooseProfileFragment_GeneratedInjector,
      KeyWordSearchFragment_GeneratedInjector,
      KeywordSearchResultsFragment_GeneratedInjector,
      LicencePlateFragment_GeneratedInjector,
      LoginFragment_GeneratedInjector,
      CreateMyListFragment_GeneratedInjector,
      FrequencyDialog_GeneratedInjector,
      MyListDetailsFragment_GeneratedInjector,
      MyListFragment_GeneratedInjector,
      ProductDeliveryFragment_GeneratedInjector,
      StreamLinedSearchFragment_GeneratedInjector,
      WelcomeToATDFragment_GeneratedInjector,
      ProductFragment_GeneratedInjector,
      TubesAndFlapsFragment_GeneratedInjector,
      SuppliesFragment_GeneratedInjector,
      TireRepairFragment_GeneratedInjector,
      TiresFragment_GeneratedInjector,
      TiresBrandFragment_GeneratedInjector,
      ToolsFragment_GeneratedInjector,
      WheelAccessoriesFragment_GeneratedInjector,
      WheelsFragment_GeneratedInjector,
      ProductDetailsFragment_GeneratedInjector,
      RebateFragment_GeneratedInjector,
      SelectLocation_GeneratedInjector,
      SplashFragment_GeneratedInjector,
      VehicleSearch_GeneratedInjector,
      MakeFragment_GeneratedInjector,
      ModelFragment_GeneratedInjector,
      OESizeFragment_GeneratedInjector,
      SizeFragment_GeneratedInjector,
      TrimFragment_GeneratedInjector,
      YearFragment_GeneratedInjector,
      VINFragment_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
