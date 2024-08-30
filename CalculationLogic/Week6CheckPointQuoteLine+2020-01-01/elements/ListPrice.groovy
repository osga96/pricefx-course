def productId = api.product("ProductId")

if (productId == null) {
    api.addWarning("List price can't be calculated, productId/sku was not set")
    return null
}

if (out.Currency == null) {
    api.addWarning("List price can't be calculated, customer currency was not set")
    return null
}

if (input.TargetDate == null) {
    api.addWarning("No target date was set to the quote")
    return null
}

def filters = [
        Filter.equal("name", "ListPrice"),
        Filter.equal("sku", productId),
        Filter.equal("attribute3", out.Currency),
        Filter.lessOrEqual("attribute1", input.TargetDate)
]

def records = api.stream("PX3", "-attribute1", *filters)
        ?.withCloseable { it.collect() }

if (records == null || records?.size() == 0) {
    api.addWarning("No records were found for productId: " + productId + " in product extension List Price with currency: EUR")
    return null
}

def mostRecentListPrice = records[0]?.attribute2

if (mostRecentListPrice == null) {
    api.addWarning("List price for record: " + productId + " was not set.")
    return null
}

return mostRecentListPrice