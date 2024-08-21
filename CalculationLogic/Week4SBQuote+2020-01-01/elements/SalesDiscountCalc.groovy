/*
def salesDiscountPercentage = out.SalesDiscountPct

if (salesDiscountPercentage == null) {
    api.logInfo("Sales discount was not set, setting to 0")
    return 0
}

if (salesDiscountPercentage == 0) {
    api.logInfo("Sales discount was set to 0")
    return 0
}

def listPrice = out.ListPrice

if (listPrice == null || listPrice == 0) {
    api.criticalAlert("List price was null or 0")
    return null
}

return listPrice * salesDiscountPercentage as BigDecimal*/

return out.SalesDiscountPct