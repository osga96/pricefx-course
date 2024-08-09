if (input.ProductEntry == null) {
    api.addWarning("Product was not set")
    return null
}

def fields = ["attribute2"]

def filters = [
        Filter.equal("name", "ListPrice"),
        Filter.equal("sku", input.ProductEntry),
        Filter.equal("attribute3", out.Currency),
        Filter.lessOrEqual("attribute1", new Date())
]

def priceList = api.find("PX3", 0, api.getMaxFindResultsLimit(), "-attribute1", *filters)[0]

def suffix = out.Currency

return priceList.attribute2