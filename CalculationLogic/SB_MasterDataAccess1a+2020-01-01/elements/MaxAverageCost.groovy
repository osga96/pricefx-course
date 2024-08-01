def filterProductExtName = Filter.equal("name", "ProductCost")

try {
    api.find("PX3", 0, 1, null, ["attribute1": "MAX"], true, filterProductExtName)[0].attribute1 as BigDecimal
} catch (e) {
    api.criticalAlert(e.getMessage())
}