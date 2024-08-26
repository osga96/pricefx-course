def prodExt = api.productExtension("ProductCost")

if (prodExt == null || prodExt[0] == null) {
    return null
}

def cost = api.productExtension("ProductCost")[0]?.attribute1


def filters = [
        Filter.equal("key1", "EUR"),  // From Ccy
        Filter.equal("key2", "USD"),    // To Ccy
        Filter.lessOrEqual("ValidFrom", api.targetDate()),
        Filter.greaterOrEqual("ValidTo", api.targetDate())
]

def exchangeRate = api.findLookupTableValues("ExchangeRate", *filters)
exchangeRate = exchangeRate[0]?.attribute2


return cost != null ? (cost * exchangeRate) : null