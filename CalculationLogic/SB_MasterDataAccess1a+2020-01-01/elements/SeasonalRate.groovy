def filterPG = Filter.equal("key2", out.ProductGroup[0].attribute1)
def filterRegion = Filter.equal("key1", out.CustomerRegion[0].attribute5)
// As key3 is valid from, we check that the key3 date is before today (all dates before today are valid)
def filterDate = Filter.lessThan("key3", api.targetDate())

def fields = ["attribute1"]

def lookupTableId = api.findLookupTable("SeasonalRate")?.id

def matrixValueFilters = [
        Filter.equal("lookupTable.id", lookupTableId),
        filterPG,
        filterRegion,
        filterDate
]

try {
    api.find("MLTV3", 0, api.getMaxFindResultsLimit(), null, fields, *matrixValueFilters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}