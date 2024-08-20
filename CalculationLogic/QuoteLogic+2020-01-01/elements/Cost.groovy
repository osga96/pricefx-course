if (api.productExtension("ProductCost") == null || api.productExtension("ProductCost")?.size == 0) {
    api.addWarning("Product extension ProductCost was null or empty")
}

return api.productExtension("ProductCost")[0].attribute1