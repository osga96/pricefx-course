def customerId = out.Customer

if (customerId == null) {
    api.criticalAlert("CustomerId was not set")
    return null
}

// Already shows a warning and returns null if customer could not be found.
return api.customer("CustomerCurrency", customerId)