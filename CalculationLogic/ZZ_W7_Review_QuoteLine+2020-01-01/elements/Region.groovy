def customerId = input.Customer as String

if (customerId == null) {
    api.addWarning("Customer was not set")
    return null
}

def region = api.customer("Region", customerId)

if (region == null) {
    api.addWarning("Region for customerId: $customerId was null")
    return null
}

return region