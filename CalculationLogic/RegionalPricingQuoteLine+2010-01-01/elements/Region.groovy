if (out.CustomerId == null) {
    api.addWarning("Customer was not set")
    return null
}

return api.customer("Region", out.CustomerId) as String