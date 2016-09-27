/*
 * Copyright (c) 2016.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.imobdev.mvpstructure.presenters;

import com.imobdev.mvpstructure.baseclasses.AppInteractor;
import com.imobdev.mvpstructure.baseclasses.BasePresenter;
import com.imobdev.mvpstructure.baseclasses.InterActorCallback;
import com.imobdev.mvpstructure.models.SampleResponse;
import com.imobdev.mvpstructure.views.MainView;
import java.util.List;

import static com.imobdev.mvpstructure.utils.AppUtils.log;
import static com.imobdev.mvpstructure.utils.AppUtils.loge;

/**
 * @author Harsh
 * @version 1.0
 */
public class MainPresenter extends BasePresenter<MainView> {
  private AppInteractor appInteractor;

  /**
   * create interactor object
   */
  public MainPresenter() {
    appInteractor = new AppInteractor();
  }

  /**
   * getting data from interactor
   */
  public void loadData() {

    if (hasInternet()) {
      appInteractor.loadJson(new InterActorCallback<List<SampleResponse>>() {

        @Override public void onStart() {

        }

        @Override public void onResponse(List<SampleResponse> response) {
          log(Integer.toString(response.size()));
          getView().onResponse(response);
        }

        @Override public void onFinish() {

        }

        @Override public void onError(Throwable message) {
          loge(message.getMessage());
        }
      });
    }
  }

  public void validate(String userName,String password){

    appInteractor.doLogin(userName, password, new InterActorCallback<SampleResponse>() {
      @Override public void onStart() {

      }

      @Override public void onResponse(SampleResponse response) {

      }

      @Override public void onFinish() {

      }

      @Override public void onError(Throwable message) {

      }
    });
  }
}

