def productLifeCycle = out.Product.ProductLifeCycle[0]

def fields = ["attribute1"]

def filters = [
        Filter.equal("name", productLifeCycle)
]

try {
    api.findLookupTableValues("AttributeAdj", fields, null, *filters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}