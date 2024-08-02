def productGroup = out.Product.ProductGroup[0]
def filters = [
        Filter.equal("name", productGroup)
]

try {
    api.findLookupTableValues("MarginAdj", ["value"], null, *filters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}