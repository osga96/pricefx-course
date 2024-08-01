def filterProductExtName = Filter.equal("name", "ProductCost")
def filterSku = Filter.equal("sku", "MB-0002")
def fields = ["attribute1"]

try {
    api.find("PX3", 0, 1, "sku", fields, filterProductExtName, filterSku)[0].attribute1 as BigDecimal
} catch (e) {
    api.criticalAlert(e.getMessage())
}