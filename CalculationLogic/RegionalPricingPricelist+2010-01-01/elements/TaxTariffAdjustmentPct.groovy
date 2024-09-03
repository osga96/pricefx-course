if (input.Region == null) {
    api.addWarning("Product was not set")
    return null
}

def region = input.Region

if (region == null) {
    api.addWarning("Region was not set")
    return null
}

def taxAdj = api.vLookup("TaxAdj", region)

if (taxAdj == null ) {
    api.addWarning("No TaxAdj was found for region: " + region)
    return null
}

return taxAdj as BigDecimal