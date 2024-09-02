if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productCostExtension = api.productExtension("ProductCost")

if (productCostExtension == null) {
    api.addWarning("productCostExtension was not set for product: " + api.product())
    return null
}

return productCostExtension[0]?.attribute1