def invoicePrice = out.InvoicePrice

if (invoicePrice == null || invoicePrice == 0) {
    api.criticalAlert("Total invoice price can't be calculated because the singular invoice price couldn't be calculated or it was 0")
    return null
}

def quantity = out.Quantity

if (quantity == null) {
    quantity = 1
}

return invoicePrice * quantity