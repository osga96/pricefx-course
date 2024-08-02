def fields = ["attribute1"]

def filters = [
        Filter.equal("key1", out.Region),
        Filter.equal("key2", out.Product.ProductGroup[0]),
        Filter.lessOrEqual("key3", api.targetDate())
]

try {
    api.findLookupTableValues("SeasonalRate", fields, "-key3", *filters)[0]
} catch (e) {
    api.criticalAlert(e.getMessage())
}