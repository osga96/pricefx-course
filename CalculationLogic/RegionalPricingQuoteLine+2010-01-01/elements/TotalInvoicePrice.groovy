if (out.InvoicePrice == null) {
    api.addWarning("Invoice price could not be calculated")
    return null
}

if (input.Quantity == null) {
    api.addWarning("Quantity input was not filled out")
    return null
}

return out.InvoicePrice.multiply(input.Quantity)