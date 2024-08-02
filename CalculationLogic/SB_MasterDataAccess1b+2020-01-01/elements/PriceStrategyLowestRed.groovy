try {
    def lowestValue = api.findLookupTableValues("PriceStrategy", ["RedAlert"], "RedAlert")["RedAlert"][0]
    api.findLookupTableValues("PriceStrategy", ["name"], null, Filter.equal("RedAlert", lowestValue))
} catch (e) {
    api.criticalAlert(e.getMessage())
}