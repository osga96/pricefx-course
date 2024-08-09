def customerId = input.CustomerEntry

if (customerId == null) {
    api.addWarning("Customer was not set")
    return null
}

def fields = ["attribute13"]
def customer = api.find("C", 0, 1, null, fields, Filter.equal("customerId", customerId))

if (customer == null || customer[0] == null) {
    api.addWarning("Customer with id: " + customerId + " could not be found")
    return null
}

return customer[0]?.attribute13