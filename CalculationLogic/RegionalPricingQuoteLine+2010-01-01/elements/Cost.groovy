if (api.product() == null) {
    api.addWarning("Product was null")
    return null
}

def productCost = api.productExtension("ProductCost")

if (productCost == null || productCost.size() == 0) {
    api.addWarning("No product cost was found for product: " + api.product())
}

if (out.Currency == null) {
    api.addWarning("Customer currency was null")
    return null
}

if (out.Currency != "EUR") {
    return libs.MoneyUtils.ExchangeRate.convertMoney(productCost[0]?.attribute1, "EUR", out.Currency)
}

return productCost[0]?.attribute1