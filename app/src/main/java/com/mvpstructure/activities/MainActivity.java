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

package com.mvpstructure.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.mvpstructure.R;
import com.mvpstructure.baseclasses.BaseActivity;
import com.mvpstructure.baseclasses.BaseApplication;
import com.mvpstructure.models.SampleResponse;
import com.mvpstructure.presenter.MainPresenter;
import com.mvpstructure.views.MainView;
import java.util.List;
import javax.inject.Inject;

/**
 * @author Harsh
 * @version 1.0
 */
public class MainActivity extends BaseActivity implements MainView {

  @Inject MainPresenter presenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ((BaseApplication) getApplication()).getComponent().inject(this);
    presenter.attachView(this);
    presenter.test();

  }

  @Override public boolean hasInternet() {
    return false;
  }

  @Override public void showProgress(boolean show) {

  }

  @Override public void onResponse(List<SampleResponse> sampleResponse) {

  }
}
