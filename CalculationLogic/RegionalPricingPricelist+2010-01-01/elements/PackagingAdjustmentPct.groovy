if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productSize = api.product("Size")

if (productSize == null) {
    api.addWarning("Product size was not set for product: " + api.product())
    return null
}

def packagingAdj = api.vLookup("PackagingAdj", "attribute1", productSize)

if (packagingAdj == null ) {
    api.addWarning("No PackagingAdj was found for product size: " + productSize)
    return null
}

return packagingAdj as BigDecimal