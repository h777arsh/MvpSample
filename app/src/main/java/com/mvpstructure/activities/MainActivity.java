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
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mvpstructure.R;
import com.mvpstructure.baseclasses.MVPActivity;
import com.mvpstructure.fragment.MainFragment;
import com.mvpstructure.models.SampleResponse;
import com.mvpstructure.presenters.MainPresenter;
import com.mvpstructure.utils.AppUtils;
import com.mvpstructure.views.MainView;
import java.util.List;

/**
 * @author Harsh
 * @version 1.0
 */
public class MainActivity extends MVPActivity<MainPresenter, MainView> implements MainView {

  @BindView(R.id.btnSubmit) Button btnSubmit;
  @BindView(R.id.container) FrameLayout container;
  @BindView(R.id.activity_main) LinearLayout activityMain;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    btnSubmit.setOnClickListener(mOnClickListener);

    if (savedInstanceState == null) {
      addFragment(new MainFragment(), false);
    }
  }

  @NonNull @Override public MainPresenter createPresenter() {
    return new MainPresenter();
  }

  @NonNull @Override public MainView attachView() {
    return this;
  }

  private View.OnClickListener mOnClickListener = new View.OnClickListener() {
    @Override public void onClick(View view) {
      getPresenter().loadData();
    }
  };

  @Override public void onResponse(List<SampleResponse> sampleResponse) {
    AppUtils.showToast(this, "Data is loaded");
  }

  private void addFragment(Fragment fragment, boolean addToBackStack) {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.container, fragment);
    if (addToBackStack) transaction.addToBackStack(fragment.getClass().getSimpleName());
    transaction.commit();
  }
}
