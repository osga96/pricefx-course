if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productLifeCycle = api.product("ProductLifeCycle")

if (productLifeCycle == null) {
    api.addWarning("Product lifecycle was not set for product: " + api.product())
    return null
}

def attributeAdj = api.vLookup("AttributeAdj", "attribute1", productLifeCycle)

if (attributeAdj == null ) {
    api.addWarning("No AttributeAdj was found for product lifecycle: " + productLifeCycle)
    return null
}

return attributeAdj as BigDecimal