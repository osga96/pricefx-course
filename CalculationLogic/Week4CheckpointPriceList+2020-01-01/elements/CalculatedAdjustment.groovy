def listPrice = out.ListPrice

if (listPrice == null) {
    api.addWarning("List price was not calculated correctly")
    return null
}

if (!listPrice instanceof BigDecimal) {
    api.addWarning("List price was not a number")
    return null
}

listPrice = listPrice as BigDecimal

def adjustmentPercentage = out.Adjustment

if (!adjustmentPercentage instanceof BigDecimal) {
    api.criticalAlert("Adjustment percentage was not a number")
    return null
}

if (adjustmentPercentage == null || adjustmentPercentage == 0) {
    api.addWarning("Adjustment percentage was not set or was 0, not applying adjustment")
    return listPrice
}

adjustmentPercentage = adjustmentPercentage as BigDecimal

def customerCurrency = out.Currency

if (customerCurrency == null) {
    api.addWarning("Customer currency was not set")
    return null
}

return adjustmentPercentage * listPrice