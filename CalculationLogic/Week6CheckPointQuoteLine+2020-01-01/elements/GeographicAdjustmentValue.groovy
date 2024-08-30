def isGeographicAdjustmentEnabled = input.GeographicAdjustment

if (isGeographicAdjustmentEnabled == null || !isGeographicAdjustmentEnabled) {
    return 0 as BigDecimal
}

def customer = out.Customer

if (customer == null) {
    api.addWarning("Customer was not set")
    return null
}

def customerRegion = api.customer("Region", out.Customer as String)

if (customerRegion == null) {
    api.addWarning("Customer region was not set")
    return null
}

def listPrice = out.ListPrice

if (listPrice == null || listPrice == 0) {
    api.criticalAlert("List price was either null or 0")
    return null
}

switch (customer) {
    case "Europe":
        return listPrice + (listPrice * 0.12) as BigDecimal
    case "Asia":
        return listPrice + (listPrice * 0.10) as BigDecimal
    case "America":
        return listPrice + (listPrice * 0.08) as BigDecimal
    default:
        return listPrice + (listPrice * 0.07) as BigDecimal
}