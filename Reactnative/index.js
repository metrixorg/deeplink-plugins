import {
    NativeModules
} from 'react-native';

let metrixDeeplinkModule = NativeModules.MetrixDeeplink;

var MetrixDeeplink = {};

MetrixDeeplink.shouldLaunchDeeplink = true

MetrixDeeplink.setDeferredDeeplinkResponseListener = function(callback) {
    metrixDeeplinkModule.setDeferredDeeplinkResponseListener(this.shouldLaunchDeeplink, callback);
};

module.exports = { MetrixDeeplink }