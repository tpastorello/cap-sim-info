// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapSimInfo",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapSimInfo",
            targets: ["SimInfoPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "SimInfoPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/SimInfoPlugin"),
        .testTarget(
            name: "SimInfoPluginTests",
            dependencies: ["SimInfoPlugin"],
            path: "ios/Tests/SimInfoPluginTests")
    ]
)