if (out.BasePrice == null) {
    api.addWarning("BasePrice was null")
    return null
}

if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productSize = api.product("Size")

def packagingAdj = api.vLookup("PackagingAdj", "attribute1", productSize)

if (packagingAdj == null || !packagingAdj instanceof BigDecimal) {
    api.addWarning("Attribute adjustment couldn't be fetched")
    return null
}

return out.BasePrice * packagingAdj