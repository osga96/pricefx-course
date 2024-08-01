def filterProductExtName = Filter.equal("name", "ProductCost")
def fields = ["attribute1"]

api.find("PX3", 0, api.getMaxFindResultsLimit(), "attribute1", fields, filterProductExtName)[0]