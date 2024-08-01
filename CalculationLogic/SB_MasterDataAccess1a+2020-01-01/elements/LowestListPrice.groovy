def filters = [
        Filter.equal("name", "ListPrice")
]
def fields = [
        "attribute2"
]

try {
    api.find("PX", 0, 1, "attribute2", fields, *filters)[0].attribute2 as BigDecimal
} catch (e) {
    api.criticalAlert(e.getMessage())
}