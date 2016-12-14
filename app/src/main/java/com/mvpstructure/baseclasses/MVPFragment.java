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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.mvpstructure.utils.AppUtils;

/**
 * @author Harsh
 * @version 1.0
 */

public abstract class MVPFragment<P extends BasePresenter<V>, V extends BaseView>
    extends BaseFragment {

  private P presenter;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = createPresenter();
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    presenter.attachView(attachView());
  }

  public abstract @NonNull P createPresenter();

  public abstract @NonNull V attachView();

  @Override public void onDestroy() {
    super.onDestroy();
    presenter.detachView();
  }

  public P getPresenter() {
    return presenter;
  }

  public boolean hasInternet() {
    return AppUtils.hasInternet();
  }
}
