if (out.InvoicePrice == null) {
    api.addWarning("Invoice price could not be calculated")
    return null
}

if (out.Cost == null) {
    api.addWarning("Cost could not be calculated")
    return null
}

return out.InvoicePrice.subtract(out.Cost)