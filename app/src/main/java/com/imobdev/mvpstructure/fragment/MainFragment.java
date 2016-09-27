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

package com.imobdev.mvpstructure.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.imobdev.mvpstructure.R;
import com.imobdev.mvpstructure.baseclasses.MVPFragment;
import com.imobdev.mvpstructure.models.SampleResponse;
import com.imobdev.mvpstructure.presenters.MainPresenter;
import com.imobdev.mvpstructure.utils.AppUtils;
import com.imobdev.mvpstructure.views.MainView;
import java.util.List;

/**
 * @author Harsh
 * @version 1.0
 */

public class MainFragment extends MVPFragment<MainPresenter, MainView> implements MainView {

  @BindView(R.id.btnSubmit) Button btnSubmit;
  @BindView(R.id.container) FrameLayout container;
  @BindView(R.id.activity_main) LinearLayout activityMain;
  private Unbinder unbinder;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_main, container, false);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getPresenter().loadData();
  }

  @Override public void onResponse(List<SampleResponse> sampleResponse) {
    AppUtils.showToast(getActivity(), "Data Loaded");
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @NonNull @Override public MainPresenter createPresenter() {
    return new MainPresenter();
  }

  @NonNull @Override public MainView attachView() {
    return this;
  }
}
