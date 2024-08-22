def customerCurrency = out.Currency

if (customerCurrency == null) {
    api.criticalAlert("Customer currency was not set")
    return null
}

def listPriceExtensionName = "ListPrice"

def productSku = api.currentItem()?.sku

if (productSku == null) {
    api.addWarning("Product was not set")
    return null
}

def filters = [
        Filter.equal("name", listPriceExtensionName),
        Filter.equal("sku", productSku),
        Filter.equal("Currency", customerCurrency),
        Filter.lessOrEqual("ValidFrom", api.targetDate())
]

listPrice = api.find("PX3", 0, api.getMaxFindResultsLimit(), "-ValidFrom", null, *filters)

if (listPrice == null || listPrice.size() == 0) {
    api.addWarning("List price value could not be found for product: " + productSku + ", with currency: " + customerCurrency + ", in product extension table: " + listPriceExtensionName)
    return null
}

return listPrice[0]?.attribute2