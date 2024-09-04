if (out.Currency == null) {
    api.addWarning("Currency was not set")
    return null
}

if (api.product() == null) {
    api.addWarning("Product was null")
    return null
}

if (out.Region == null) {
    api.addWarning("Region was null")
    return null
}

if (api.pricelist(out.Region) == null) {
    api.addWarning("Price list price could not be fetched for product: " + api.product())
    return null
}

if (api.pricelist(out.Region, "currency") == null) {
    api.addWarning("Price list currency was not set for product: " + api.product())
    return null
}

def resultPrice = api.pricelist(out.Region) as BigDecimal
def listPriceCurrency = api.pricelist(out.Region, "currency") as String

if (!listPriceCurrency.equals(out.Currency)) {
    return libs.MoneyUtils.ExchangeRate.convertMoney(resultPrice, listPriceCurrency, out.Currency)
}

return resultPrice