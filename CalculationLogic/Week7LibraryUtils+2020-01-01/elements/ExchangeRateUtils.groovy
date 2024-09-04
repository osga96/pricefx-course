BigDecimal getExchangeRate(String fromCurrency) {
    def filters = [
            Filter.equal("key1", fromCurrency),
            Filter.greaterOrEqual("attribute1", api.targetDate()),
            Filter.lessOrEqual("key3", api.targetDate())
    ]

    def exchangeRateValue = api.findLookupTableValues("ExchangeRate", *filters)

    if (exchangeRateValue == null || exchangeRateValue.size() == 0) {
        api.addWarning("Exchange rate could not be found for: " + fromCurrency)
        return null
    }

    return exchangeRateValue[0]?.attribute2
}