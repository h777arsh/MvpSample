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

package com.mvpstructure.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Harsh
 * @version 1.0
 */
public class AppUtils {
  private static String TAG = "AppName";

  public static boolean hasInternet() {
    return true;
  }

  public static String getText(TextView textView) {
    return textView.getText().toString().trim();
  }

  public static void showToast(Activity activity, String message) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
  }

  public static void log(String text) {
    Log.d(TAG, text);
  }

  public static void loge(String text) {
    Log.e(TAG, text);
  }
}
