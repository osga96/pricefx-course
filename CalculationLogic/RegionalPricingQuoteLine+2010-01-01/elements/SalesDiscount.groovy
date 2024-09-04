if (out.ListPrice == null) {
    api.addWarning("List price could not be calculated")
    return null
}

// We don't check InvoicePrice, as it has to be either
// filled out by customer or it's equal to ListPrice

return out.ListPrice.subtract(out.InvoicePrice)