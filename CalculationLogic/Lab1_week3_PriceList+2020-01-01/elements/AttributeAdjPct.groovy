def productLifeCycle = api.product("ProductLifeCycle")
def attributeAdjPct = api.vLookup("AttributeAdj", "AttributeAdj", productLifeCycle.toString())

if(attributeAdjPct == null) {
    api.addWarning("Unable to look up Attribute Adjustment with the Product Life Cycle")
}

return attributeAdjPct