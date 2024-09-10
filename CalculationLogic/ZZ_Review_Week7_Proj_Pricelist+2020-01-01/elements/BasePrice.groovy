if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def filters = [Filter.equal("sku", api.product("ProductId"))]

def basePrice = api.productExtension("ProductCost", *filters)

if (basePrice == null || basePrice[0] == null) {
    api.addWarning("Base price was null")
    return null
}

if (out.Currency != null && out.Currency != "EUR") {

    def currency = out.Currency as String
    def exchangeRate = libs.ZZ_REVIEW_MoneyUtils.ExchangeRate.getExchangeRate("EUR", currency, api.targetDate())

    if (exchangeRate == null || !exchangeRate instanceof BigDecimal) {
        api.addWarning("ExchangeRate was null or it was not a BigDecimal")
        return null
    }

    return basePrice[0]?.attribute1 * exchangeRate
} else {
    return basePrice[0]?.attribute1
}
