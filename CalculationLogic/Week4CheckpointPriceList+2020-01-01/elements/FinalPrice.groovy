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

def calculatedAdj = out.CalculatedAdjustment

if (calculatedAdj == null) {
    api.addWarning("CalculatedAdj was not calculated correctly")
    return null
}

if (!calculatedAdj instanceof BigDecimal) {
    api.addWarning("CalculatedAdj was not a number")
    return null
}

calculatedAdj = calculatedAdj as BigDecimal

def calculatedTax = out.CalculatedTax

if (calculatedTax == null) {
    api.addWarning("CalculatedTax was not calculated correctly")
    return null
}

if (!calculatedTax instanceof BigDecimal) {
    api.addWarning("CalculatedTax was not a number")
    return null
}

calculatedTax = calculatedTax as BigDecimal

def customerCurrency = out.Currency

if (customerCurrency == null) {
    api.addWarning("Customer currency was not set")
    return null
}

return listPrice + calculatedAdj + calculatedTax