if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productGroup = api.product("ProductGroup")

if (productGroup == null) {
    api.addWarning("Product group was not set for product: " + api.product())
    return null
}

def marginAdj = api.vLookup("MarginAdj", productGroup)

if (marginAdj == null ) {
    api.addWarning("No MarginAdj was found for product group: " + productGroup)
    return null
}

return marginAdj as BigDecimal