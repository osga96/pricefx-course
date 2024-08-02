def filters = [
        Filter.equal("sku", api.currentItem()?.sku)
]

def fields = [
        "sku",
        "ProductGroup",
        "Size",
        "ProductLifeCycle"
]

try {
    api.find("P", 0, api.getMaxFindResultsLimit(), "sku", fields, *filters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}

