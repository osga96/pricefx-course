def filterPG = Filter.equal("key2", out.ProductGroup.attribute1)
def filterRegion = Filter.equal("key1", out.CustomerRegion.attribute5)
def filterDate = Filter.lessThan("key3", api.targetDate())

def fields = ["attribute1"]

api.findLookupTableValues("SeasonalRate", fields, "attribute1", filterPG, filterRegion, filterDate)