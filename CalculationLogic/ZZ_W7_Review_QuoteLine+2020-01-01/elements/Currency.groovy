def customerId = input.Customer as String

if (customerId == null) {
    api.addWarning("Customer was not set")
    return null
}

def customerCurrency = api.customer("CustomerCurrency", customerId)

if (customerCurrency == null) {
    api.addWarning("Currency was null for customer: $customerId")
    return null
}

return customerCurrency