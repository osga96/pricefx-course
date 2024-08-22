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

def taxPct = out.TaxPct

if (taxPct == null || taxPct == 0) {
    api.addWarning("Tax percentage was not set or was 0, not applying tax")
    return listPrice
}

if (!taxPct instanceof BigDecimal) {
    api.addWarning("Tax percentage was not a number")
    return null
}

taxPct = taxPct as BigDecimal

def customerCurrency = out.Currency

if (customerCurrency == null) {
    api.addWarning("Customer currency was not set")
    return null
}

return taxPct * listPrice