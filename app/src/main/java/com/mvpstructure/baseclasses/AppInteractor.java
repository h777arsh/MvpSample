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

package com.mvpstructure.baseclasses;

import com.mvpstructure.models.SampleResponse;
import com.mvpstructure.rest.RestClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * @author Harsh
 * @version 1.0
 */
public class AppInteractor {

  /**
   * load json data from api
   *
   * @param callback call back for response
   */
  public void loadJson(final InterActorCallback<List<SampleResponse>> callback) {

    Call<List<SampleResponse>> call = RestClient.Creator.getClient().getJsonData();

    call.enqueue(new Callback<List<SampleResponse>>() {
      @Override public void onResponse(Call<List<SampleResponse>> call,
          retrofit2.Response<List<SampleResponse>> response) {
        callback.onResponse(response.body());
        callback.onFinish();
      }

      @Override public void onFailure(Call<List<SampleResponse>> call, Throwable t) {
        callback.onError(t);
        callback.onFinish();
      }
    });
  }



}
