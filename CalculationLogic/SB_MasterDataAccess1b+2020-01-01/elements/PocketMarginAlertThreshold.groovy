def keys = [
        key1: "Beef",
        key2: "Red"
]

try {
    api.vLookup(
            "PocketMarginAlertThreshold",
            ["attribute1"],
            keys
    )?.getAt('attribute1')
} catch (e) {
    api.criticalAlert(e.getMessage())
}