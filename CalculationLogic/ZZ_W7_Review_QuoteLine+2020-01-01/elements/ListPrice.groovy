if (api.product() == null) {
    api.addWarning("Product was null")
    return null
}

def region = out.Region
def pricelistName = ""

if ("Europe".equals(region)) {
    pricelistName = "ZZ_REVIEW_EUROPE"
} else if ("America".equals(region)) {
    pricelistName = "ZZ_REVIEW_AMERICA"
} else {
    api.addWarning("Region $region was not recognized.")
    return null
}

def currency = out.Currency as String

if (currency == null) {
    api.addWarning("Currency was not set")
    return null
}

def priceList = api.pricelist(pricelistName)

if (priceList == null || !priceList instanceof BigDecimal) {
    api.addWarning("PriceList was not valid")
    return null
}

if ("EUR".equals(currency)) {
    return priceList
} else {
    def exchangeRate = libs.ZZ_REVIEW_MoneyUtils.ExchangeRate.getExchangeRate("EUR", currency, api.targetDate())

    if (exchangeRate == null || !exchangeRate instanceof BigDecimal) {
        api.addWarning("ExchangeRate was null or it was not a BigDecimal")
        return null
    }

    return priceList * exchangeRate
}