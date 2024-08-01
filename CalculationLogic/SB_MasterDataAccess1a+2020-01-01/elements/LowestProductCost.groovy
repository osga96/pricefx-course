def filterProductExtName = Filter.equal("name", "ProductCost")
def fields = ["attribute1"]

api.find("PX3", 0, 1, "attribute1", fields, filterProductExtName)[0].attribute1 as BigDecimal