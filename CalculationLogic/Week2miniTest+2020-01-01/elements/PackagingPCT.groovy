def fields = ["attribute1"]

def filters = [
        Filter.equal("name", out.Product.Size[0])
]

try {
    api.findLookupTableValues("PackagingAdj", fields, null, *filters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}