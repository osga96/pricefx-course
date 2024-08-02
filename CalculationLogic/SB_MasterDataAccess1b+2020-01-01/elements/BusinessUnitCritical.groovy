def fields = ["BusinessUnit"]

try {
    def highestValue = api.findLookupTableValues("PriceStrategy", ["CriticalAlert"], "-CriticalAlert")["CriticalAlert"][0]
    api.findLookupTableValues("PriceStrategy", fields, null, Filter.equal("CriticalAlert", highestValue))["BusinessUnit"][0]
} catch (e) {
    api.criticalAlert(e.getMessage())
}