def filters = [
        Filter.equal("ProductGroup", "Beef"),
        Filter.equal("AlertSeverity", "Critical")
]

def fields = ["Threshold"]

try {
    api.findLookupTableValues("PocketMarginAlertThreshold", fields, null, *filters)["Threshold"][0]
} catch (e) {
    api.criticalAlert(e.getMessage())
}