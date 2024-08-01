def filterProductExtName = Filter.equal("name", "ProductCost")
def filterSku = Filter.equal("sku", "MB-0002")
def fields = ["attribute1"]

api.find("PX3", 0, api.getMaxFindResultsLimit(), "sku", fields, filterProductExtName, filterSku)