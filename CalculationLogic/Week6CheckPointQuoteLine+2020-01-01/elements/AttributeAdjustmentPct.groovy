def productLifeCycle = api.product("ProductLifeCycle")

if (productLifeCycle == null) {
    return 0
}

def filters = [
        Filter.equal("name", productLifeCycle)
]

def attributeAdjParameter = api.findLookupTableValues("AttributeAdj", *filters)

if (attributeAdjParameter == null || attributeAdjParameter.size() == 0) {
    return 0
}

return attributeAdjParameter[0]?.attribute1