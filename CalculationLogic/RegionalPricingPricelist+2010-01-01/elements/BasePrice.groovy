def productCost = api.productExtension("ProductCost")

if (productCost == null || productCost[0] == null) {
    api.addWarning("Product cost was not found")
    return null
}

if ("USD" == out.Currency) {
    // return productCost[0]?.attribute2 is valid too due to previous lab (Average Cost USD)
    return libs.MoneyUtils.ExchangeRate.convertMoney(productCost[0]?.attribute1, "EUR", "USD")
}

return productCost[0]?.attribute1