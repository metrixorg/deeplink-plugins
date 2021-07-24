package ir.metrix.deeplink.reactnative;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

import java.util.Map;

import org.jetbrains.annotations.NotNull;

import ir.metrix.deeplink.OnMetrixDeferredDeeplinkListener;
import ir.metrix.deeplink.MetrixDeeplinkModel;
import ir.metrix.deeplink.MetrixDeeplink;

public class MetrixDeeplinkModule extends ReactContextBaseJavaModule {

    private static final String TAG = "MetrixDeeplink";

    public MetrixDeeplinkModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void setDeferredDeeplinkResponseListener(final boolean shouldLaunchDeeplink, final Callback callback) {

        if (callback != null) {
            MetrixDeeplink.setDeferredDeeplinkResponseListener(new OnMetrixDeferredDeeplinkListener() {
                @Override
                public boolean launchReceivedDeeplink(@NotNull MetrixDeeplinkModel metrixDeeplinkModel) {
                    callback.invoke(metrixDeeplinkModel.getType().name(), metrixDeeplinkModel.getTarget(), getWritableMapFromData(metrixDeeplinkModel.getData()));
                    return shouldLaunchDeeplink;
                }
            });
        }
    }

    private WritableMap getWritableMapFromData(Map<String, String> data) {
        WritableMap map = Arguments.createMap();
        
        for (Map.Entry<String, String> entry : data.entrySet()) {
            map.putString(entry.getKey(), entry.getValue());
        }

        return map;
    }
}