BigDecimal getExchangeRate(String fromCurrency, String toCurrency, Date targetDate) {
    def filters = [
            Filter.equal("key1", fromCurrency),
            Filter.equal("key2", toCurrency),
            Filter.lessOrEqual("key3", targetDate),
            Filter.greaterOrEqual("attribute1", targetDate)
    ]

    def row = api.findLookupTableValues("ExchangeRate", null, *filters)

    return row[0]?.attribute2
}