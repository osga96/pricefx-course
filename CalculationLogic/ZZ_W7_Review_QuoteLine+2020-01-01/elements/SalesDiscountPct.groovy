if (out.ListPrice == null) {
    api.addWarning("List price was null")
    return null
}

if (out.InvoicePrice == null) {
    api.addWarning("InvoicePrice was null")
    return null
}

def salesDiscount = out.ListPrice - out.InvoicePrice

if (salesDiscount == 0) {
    return 0
} else {
    def region = out.Region as String
    def businessUnit = api.product("BusinessUnit") as String

    if (region == null) {
        api.addWarning("Region was null")
        return null
    }

    if (businessUnit == null) {
        api.addWarning("BusinessUnit was null")
        return null
    }

    def yellowAlert = api.vLookup("SalesDiscountThreshold", "attribute1", region, businessUnit) as BigDecimal
    def redAlert = api.vLookup("SalesDiscountThreshold", "attribute2", region, businessUnit) as BigDecimal
    def criticalAlert = api.vLookup("SalesDiscountThreshold", "attribute3", region, businessUnit) as BigDecimal
}