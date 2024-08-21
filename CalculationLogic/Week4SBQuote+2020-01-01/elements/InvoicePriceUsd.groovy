if (out.CompetitionStrategy == null || out.CompetitionStrategy == 0) {
    api.criticalAlert("Competition Strategy was not set")
    return null
}

def invoiceInUsd = out.CompetitionStrategy - out.SalesDiscountCalc

if (api.currentItem() == null) {
    api.addWarning("Product was not set in context")
    return null
}

def productSku = api.currentItem()?.sku

if (productSku == null) {
    api.criticalAlert("Product was not set")
    return null
}

def product = api.find("P", 0 , api.getMaxFindResultsLimit(), null, Filter.equal("sku", productSku))

if (product == null || product.size() == 0) {
    api.criticalAlert("Product was not set")
    return null
}

def productCurrency = product[0]?.currency

if (productCurrency == null || ("").equals(productCurrency)) {
    api.criticalAlert("Product currency was null or empty, actual value: " + productCurrency)
    return null
}

if ("USD".equals(productCurrency)) {
    return invoiceInUsd
} else {
    def exchangeRateFilters =
            [
                    Filter.equal("FromCurrency", "EUR"),
                    Filter.equal("ToCurrency", "USD"),
                    Filter.lessOrEqual("ValidFrom", api.targetDate()),
                    Filter.greaterOrEqual("ValidTo", api.targetDate()),
            ]
    def exchangeRate = api.findLookupTableValues("ExchangeRate", ["attribute2"], null, *exchangeRateFilters)

    if (exchangeRate == null || exchangeRate.size() == 0 || exchangeRate[0] == null) {
        api.addWarning("exchangeRate currency was null or empty, actual value: " + exchangeRate + " values were productCurrency: " + productCurrency + ", customerCurrency: " + customerCurrency)
        return null
    }

    def rate = exchangeRate[0].attribute2 as BigDecimal

    return invoiceInUsd * rate
}