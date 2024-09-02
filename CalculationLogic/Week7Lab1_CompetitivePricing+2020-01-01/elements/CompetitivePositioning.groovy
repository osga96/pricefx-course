if (out.ProductBusinessUnit == null) {
    api.addWarning("Product business unit was not set")
    return null
}

def filters = [
        Filter.equal("name", out.ProductBusinessUnit)
]

def competitionStrategy = api.findLookupTableValues("CompetitionStrategy", *filters)

if (competitionStrategy == null) {
    api.addWarning("competitionStrategy was not set")
    return null
}

if (competitionStrategy.size() == 0) {
    api.addWarning("Competition strategy was not found for business unit: " + out.ProductBusinessUnit)
}

return competitionStrategy[0]?.attribute1