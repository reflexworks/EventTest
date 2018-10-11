package com.eventtest;

import android.util.Log;
import android.view.KeyEvent;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventTestModule extends ReactContextBaseJavaModule {

    private static final String MODULE_NAME = "EventTestModule";
    private static final String EVENT_NAME = "testEvent";
    private static final String EVENT_PARAM_VAL = "val";

    /** ReactContext */
    private ReactContext mReactContext;
    /** JS module */
    private DeviceEventManagerModule.RCTDeviceEventEmitter mJSModule = null;

    /**
     * コンストラクタ
     * @param reactContext ReactContext
     */
    protected EventTestModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    /**
     * このnativeモジュールの名前を取得.
     * @return 本nativeモジュール名
     */
    @Override
    public String getName() {
        return MODULE_NAME;
    }

    /**
     * called by JS
     */
    @ReactMethod
    public void getNow(Callback errorCallback, Callback successCallback) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        String nowStr = format.format(new Date());
        Log.i("EventTest", "call getNow:" + nowStr);

        try {
            successCallback.invoke(nowStr);

        } catch (Exception e) {
            errorCallback.invoke(e.getMessage());
        }
    }

}
