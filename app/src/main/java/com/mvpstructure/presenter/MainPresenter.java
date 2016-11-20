package com.mvpstructure.presenter;

import com.mvpstructure.baseclasses.BasePresenter;
import com.mvpstructure.models.CityListResponse;
import com.mvpstructure.networking.NetworkError;
import com.mvpstructure.networking.Service;
import com.mvpstructure.views.MainView;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * @author Harsh
 * @version 1.0
 */
public class MainPresenter extends BasePresenter<MainView> {

  private Service service;


  @Inject public MainPresenter(Service service) {
    this.service = service;
  }

  @Override public void attachView(MainView mvpView) {
    super.attachView(mvpView);
  }

  @Override public void detachView() {
    super.detachView();
  }

  public void test(){
    service.getCityList(new Service.GetCityListCallback() {
      @Override public void onSuccess(CityListResponse cityListResponse) {
        Timber.i("response successful");
      }

      @Override public void onError(NetworkError networkError) {
        Timber.i("response error");
      }
    });
  }
}
