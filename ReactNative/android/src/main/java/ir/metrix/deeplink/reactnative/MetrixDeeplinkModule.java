package ir.metrix.deeplink.reactnative;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class MetrixDeeplinkModule extends ReactContextBaseJavaModule {

    private static final String TAG = "MetrixDeeplink";

    public MetrixDeeplinkModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return TAG;
    }
}