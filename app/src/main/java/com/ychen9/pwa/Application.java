/*
 * Copyright 2020 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ychen9.pwa;


import android.util.Log;

import com.onesignal.OSPermissionSubscriptionState;
import com.onesignal.OneSignal;

public class Application extends android.app.Application {

  

  @Override
  public void onCreate() {
      super.onCreate();

      //Purnima
      // Enable verbose OneSignal logging to debug issues if needed.
      OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

      // OneSignal Initialization
      OneSignal.startInit(this)
              .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
              .unsubscribeWhenNotificationsAreDisabled(true)
              .init();
      // OneSignal.setAppId(ONESIGNAL_APP_ID);
      OSPermissionSubscriptionState status = OneSignal.getPermissionSubscriptionState();
      OneSignal.setSubscription(true);
      status.getPermissionStatus().getEnabled();
      status.getSubscriptionStatus().getSubscribed();
      Log.d("One signal", "Push Token hmm "+ status.getSubscriptionStatus().getUserId());
      Log.d("One signal", "Is subscribed "+ status.getSubscriptionStatus().getSubscribed());
      String userId = OneSignal.getPermissionSubscriptionState().getSubscriptionStatus().getPushToken();
      Log.d("One signal", "User ID "+ userId);
      String pushToken = OneSignal.getPermissionSubscriptionState().getSubscriptionStatus().getPushToken();
      Log.d("One signal", "Push token "+ pushToken);


      //Purnima
      
  }
}
