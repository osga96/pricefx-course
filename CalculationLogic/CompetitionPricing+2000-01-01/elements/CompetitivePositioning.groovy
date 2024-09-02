if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def productBusinessUnit = api.product().attribute2

if (productBusinessUnit == null) {
    api.addWarning("Product business unit was not set")
    return null
}

def filters = [
        Filter.equal("name", productBusinessUnit)
]

def competitionStrategy = api.findLookupTableValues("CompetitionStrategy", *filters)

if (competitionStrategy == null) {
    api.addWarning("competitionStrategy was not set")
    return null
}

if (competitionStrategy.size() == 0) {
    api.addWarning("Competition strategy was not found for business unit: " + productBusinessUnit)
}

return competitionStrategy[0]?.attribute1