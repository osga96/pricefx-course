def filters = [
        Filter.equal("FromCurrency", "USD"),
        Filter.equal("ToCurrency", "EUR"),
        Filter.greaterOrEqual("ValidTo", api.targetDate()),
]

def fields = ["ExchangeRate"]

try {
    api.findLookupTableValues("ExchangeRate", fields, null, *filters)["ExchangeRate"][0] as BigDecimal
} catch (e) {
    api.criticalAlert(e.getMessage())
}