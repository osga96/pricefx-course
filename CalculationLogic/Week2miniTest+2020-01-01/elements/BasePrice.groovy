def filters = [
        Filter.equal("name", "ProductCost"),
        Filter.equal("sku", out.Product?.sku[0])
]
def fields = [
        "attribute1"
]
try {
    api.find("PX", 0, api.getMaxFindResultsLimit(), null, fields, *filters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}