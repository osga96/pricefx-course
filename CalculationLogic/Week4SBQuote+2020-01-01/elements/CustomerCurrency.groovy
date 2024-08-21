def customerId = input.Customer
def filters = [Filter.equal("customerId", customerId)]

def customer = api.find("C", 0, api.getMaxFindResultsLimit(), null, ["CustomerCurrency"], *filters)
def customerCurrency = "USD"

if (customer == null || customer[0] == null) {
    api.addWarning("Customer could not be found, customerId value: " + customerId + ", returning USD")
} else {
    if (customer[0]?.get("CustomerCurrency") != null || !("").equals(customer[0].get("CustomerCurrency"))) {
        customerCurrency = customer[0]?.get("CustomerCurrency")
    }
}

return customerCurrency