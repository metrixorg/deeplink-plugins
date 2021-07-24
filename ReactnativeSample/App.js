import React from 'react'
import AppContainer from './src/navigation'
import { MetrixDeeplink } from "@metrixorg/deeplink-react-native-plugin"

class App extends React.Component {

  constructor() {
      super();
      MetrixDeeplink.setDeferredDeeplinkResponseListener(this.deeplinkCallback);
  }

  render() {
    return <AppContainer />      
  }

  deeplinkCallback = (type, target, data) => {
    console.log("[ METRIX_DEEPLINK_SAMPLE ]: Deferred deeplink callback called. Type: " + type + ". Target: " + target + ". Data: " + JSON.stringify(data));
  };
}

export default App
