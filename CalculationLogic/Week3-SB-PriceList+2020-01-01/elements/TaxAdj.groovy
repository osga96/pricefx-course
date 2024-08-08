def fields = [
        "Region"
]

def customerRegion = api.find("C", 0, 1, null, fields, Filter.equal("customerId", input.customerId))

if (customerRegion == null) {
    api.addWarning("Customer region could not be found")
    return null
}

def taxFields = [
        "value"
]

def taxAdj = api.findLookupTableValues("TaxAdj", taxFields, null, Filter.equal("name", customerRegion[0].Region))[0].value as BigDecimal

if (taxAdj == null) {
    api.addWarning("Packaging adjustment could not be found")
    return null
}

return taxAdj * out.BasePrice
