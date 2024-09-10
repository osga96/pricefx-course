if (out.BasePrice == null) {
    api.addWarning("BasePrice was null")
    return null
}

if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productGroup = api.product("ProductGroup")

def marginAdj = api.vLookup("MarginAdj", productGroup)

if (marginAdj == null || !marginAdj instanceof BigDecimal) {
    api.addWarning("Margin adjustment couldn't be fetched")
    return null
}

return out.BasePrice * marginAdj