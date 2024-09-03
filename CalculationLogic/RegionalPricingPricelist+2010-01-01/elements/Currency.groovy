if (out.Region == null) {
    api.addWarning("Region was not set")
    return null
}

def currency = api.vLookup("Region", "attribute1", out.Region)

if (currency == null) {
    api.addWarning("Currency was not found for region: " + out.Region)
    return null
}

return currency