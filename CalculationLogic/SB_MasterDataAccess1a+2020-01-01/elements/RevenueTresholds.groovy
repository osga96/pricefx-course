def matrixValueFilters = [
        Filter.equal("lookupTable.id", "59555")
]

def fields = ["attribute1"]

try {
    api.find("MLTV", 0, api.getMaxFindResultsLimit(), null, fields, *matrixValueFilters)
} catch (e) {
    api.criticalAlert(e.getMessage())
}