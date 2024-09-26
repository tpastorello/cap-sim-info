import Foundation
import Capacitor


@objc(SimInfoPlugin)
public class SimInfoPlugin: CAPPlugin {
    @objc func getSimInfo(_ call: CAPPluginCall) {        
        call.reject("SIM info not accessible on iOS")
    }
}
