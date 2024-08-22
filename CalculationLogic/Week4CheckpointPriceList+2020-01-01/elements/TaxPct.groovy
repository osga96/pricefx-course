def region = out.Region

if (region == null) {
    api.criticalAlert("Region was not set")
    return null
}

def filters = [
        Filter.equal("name", region)
]

def taxPct = api.findLookupTableValues("TaxAdj", *filters)

if (taxPct == null || taxPct[0] == null) {
    api.addWarning("Tax percentage could not be found for region: " + region + ", returning 0")
    return 0
}

return taxPct[0]?.value