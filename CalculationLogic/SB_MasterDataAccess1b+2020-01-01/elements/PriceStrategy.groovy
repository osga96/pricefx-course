def attributes = [
        "CriticalAlert",
        "RedAlert"
]

def keys = [
        "name": "Meals"
]

try {
    api.vLookup(
            "PriceStrategy",
            attributes,
            keys
    )
} catch (e) {
    api.criticalAlert(e.getMessage())
}