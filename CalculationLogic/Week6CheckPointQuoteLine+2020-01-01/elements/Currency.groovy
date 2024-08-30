def customer = out.Customer

if (customer == null) {
    api.addWarning("Customer was not set")
    return null
}

return api.customer("CustomerCurrency", out.Customer as String)