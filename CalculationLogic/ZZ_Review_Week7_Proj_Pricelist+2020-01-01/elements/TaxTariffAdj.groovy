if (out.BasePrice == null) {
    api.addWarning("BasePrice was null")
    return null
}

if (out.Region == null) {
    api.addWarning("Region was not set")
    return null
}

def region = out.Region

def taxTariffAdj = api.vLookup("TaxAdj", region)

if (taxTariffAdj == null || !taxTariffAdj instanceof BigDecimal) {
    api.addWarning("Attribute adjustment couldn't be fetched")
    return null
}

return out.BasePrice * taxTariffAdj