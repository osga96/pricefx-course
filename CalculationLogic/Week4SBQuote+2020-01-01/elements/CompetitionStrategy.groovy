def productSku = api.currentItem()?.sku

if (productSku == null) {
    api.criticalAlert("Product was not set")
    return null
}

def product = api.find("P", 0 , api.getMaxFindResultsLimit(), null, Filter.equal("sku", productSku))

if (product == null || product.size() == 0) {
    api.criticalAlert("Product was not set")
    return null
}

if (product[0]?.attribute2 == null || ("".equals(product[0]?.attribute2))) {
    api.addWarning("Product businessUnit was not set in product entry")
    return null
}

def filters = [Filter.equal("name", product[0]?.attribute2)]

def competitionStrategy = api.findLookupTableValues("CompetitionStrategy", *filters)

if (competitionStrategy == null || competitionStrategy.size() == 0) {
    api.addWarning("CompetitionStrategy was not found for name: " + product[0]?.attribute2 + ", returning 1")
    return 1
}

if (out.ListPrice == null || out.ListPrice == 0) {
    api.criticalAlert("List price was null or 0")
    return null
}

return out.ListPrice * competitionStrategy[0]?.attribute1 as BigDecimal