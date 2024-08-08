def productCost = api.productExtension("ProductCost")

if (productCost == null) {
    api.addWarning("ProductCost product extension could not be found")
}

if (productCost?.getAt(0)?.attribute1 == null) {
    api.addWarning("The product's packaging adjustment was not found or is not set")
}

return productCost?.getAt(0)?.attribute1 as BigDecimal