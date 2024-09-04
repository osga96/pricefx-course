def customerId = input.Customer

if (customerId == null) {
    api.addWarning("Customer was not set")
    return null
}

return customerId as String