def businessUnit = out.ProductBusinessUnit

def competitionStrategy = api.findLookupTableValues("CompetitionStrategy", Filter.equal("name", businessUnit))

if (competitionStrategy == null || competitionStrategy[0] == null) {
    api.addWarning("CompetitionStrategy not found for businessUnit: " + businessUnit + ", " + api.findLookupTableValues("CompetitionStrategy", Filter.equal("name", businessUnit)))
    return null
}

competitionStrategy = competitionStrategy[0]?.attribute1 as BigDecimal

if (competitionStrategy == null) {
    api.addWarning("Competition Strategy was null for businessUnit: " + businessUnit)
    return null
}

if (out.BasePrice == null) {
    api.addWarning("Base price was null")
    return null
}

return competitionStrategy * out.BasePrice
