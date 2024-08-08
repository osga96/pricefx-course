def productCost = api.productExtension("ProductCost")

if (productCost == null) {
    api.addWarning("ProductCost product extension could not be found")
}

if (productCost[0]?.attribute1 == null) {
    api.addWarning("The product average cost was not found or is not set correctly")
}

return productCost[0]?.attribute1 as BigDecimal