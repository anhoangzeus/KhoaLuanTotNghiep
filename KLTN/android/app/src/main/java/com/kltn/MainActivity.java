package com.kltn;

import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
import vn.zalopay.sdk.ZaloPaySDK;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "KLTN";
  }
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
      return new ReactActivityDelegate(this, getMainComponentName()) {
          @Override
          protected ReactRootView createRootView() {
              return new RNGestureHandlerEnabledRootView(MainActivity.this);
          }
      };
  }

  @Override
  public void onNewIntent(Intent intent) {
      super.onNewIntent(intent);
      ZaloPaySDK.getInstance().onResult(intent);
  }
}
