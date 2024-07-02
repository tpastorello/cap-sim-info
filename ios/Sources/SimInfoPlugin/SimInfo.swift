import Foundation

@objc public class SimInfo: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
