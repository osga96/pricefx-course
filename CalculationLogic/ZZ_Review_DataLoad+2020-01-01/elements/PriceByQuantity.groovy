if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory().createUserEntry("Quantity").getInput()
} else {
    /*def listPriceExt = api.productExtension("ListPrice", api.currentItem("sku") as String)

    if (api.productExtension("ListPrice") == null) {
        return null
    }

    def price = listPriceExt?.attribute2 as BigDecimal
    def quantity = input.Quantity

    if (price == null || quantity == null) {
        return null
    }

    return price * quantity*/



}

return api.currentItem()