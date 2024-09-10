if (out.InvoicePrice == null) {
    api.addWarning("InvoicePrice was null")
    return null
}

if (out.Cost == null) {
    api.addWarning("Cost was null")
    return null
}

return out.InvoicePrice - out.Cost