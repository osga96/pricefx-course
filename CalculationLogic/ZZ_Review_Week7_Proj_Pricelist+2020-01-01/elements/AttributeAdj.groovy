if (out.BasePrice == null) {
    api.addWarning("BasePrice was null")
    return null
}

if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productLifeCycle = api.product("ProductLifeCycle")

def attributeAdj = api.vLookup("AttributeAdj", "attribute1", productLifeCycle)

if (attributeAdj == null || !attributeAdj instanceof BigDecimal) {
    api.addWarning("Attribute adjustment couldn't be fetched")
    return null
}

return out.BasePrice * attributeAdj