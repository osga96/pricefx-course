if (out.CustomerId == null) {
    api.addWarning("Customer was not set")
    return null
}

return api.customer("CustomerCurrency", out.CustomerId) as String