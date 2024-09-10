if (out.InvoicePrice == null) {
    api.addWarning("InvoicePrice was null")
    return null
}

if (input.Quantity == null) {
    api.addWarning("Quantity was null")
    return null
}

return out.InvoicePrice * input.Quantity