if (out.ListPrice == null) {
    api.addWarning("List price was null")
    return null
}

if (out.ProductCostEUR == null) {
    api.addWarning("ProductCostEUR was not set")
    return null
}

return (out.ListPrice - out.ProductCostEUR) / out.ListPrice