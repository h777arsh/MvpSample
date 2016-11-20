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

import android.app.Application;
import android.content.Context;
import com.mvpstructure.BuildConfig;
import com.mvpstructure.component.AppComponent;
import com.mvpstructure.component.DaggerAppComponent;
import com.mvpstructure.networking.ApplicationModule;
import timber.log.Timber;

/**
 * @author Harsh
 * @version 1.0
 */

public class BaseApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
    getComponent();
  }

  public static BaseApplication get(Context context) {
    return (BaseApplication) context.getApplicationContext();
  }

  AppComponent appComponent;

  public AppComponent getComponent() {
    if (appComponent == null) {
      appComponent =
          DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }
    return appComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(AppComponent appComponent) {
    this.appComponent = appComponent;
  }
}
