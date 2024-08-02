def fields = ["value"]

def filters = [
        Filter.equal("name", out.Region)
]

try {
    api.findLookupTableValues("TaxAdj", fields, null, *filters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}