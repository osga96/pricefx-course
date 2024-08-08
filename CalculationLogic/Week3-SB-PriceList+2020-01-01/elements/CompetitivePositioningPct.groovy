def businessUnit = out.ProductBusinessUnit

def competitionStrategy = api.findLookupTableValues("CompetitionStrategy", Filter.equal("name", businessUnit))

if (competitionStrategy == null || competitionStrategy[0] == null) {
    api.addWarning("CompetitionStrategy not found for businessUnit: " + businessUnit + ", " + api.findLookupTableValues("CompetitionStrategy", Filter.equal("name", businessUnit)))
    return null
}

return competitionStrategy[0]?.attribute1 * out.BasePrice
