if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

def grossMarginPct = out.GrossMarginPct

if (grossMarginPct == null) {
    api.addWarning("GrossMarginPct was null")
    return null
}

def businessUnit = api.product("BusinessUnit")

if (businessUnit == null) {
    api.addWarning("BusinessUnit was null")
    return null
}

def yellowAlert = api.vLookup("PriceStrategy", "attribute3", businessUnit) as BigDecimal
def redAlert = api.vLookup("PriceStrategy", "attribute2", businessUnit) as BigDecimal
def criticalAlert = api.vLookup("PriceStrategy", "attribute1", businessUnit) as BigDecimal

if (grossMarginPct <= criticalAlert) {
    api.criticalAlert("GrossMarginPct was less or equal than the critical threshold of $criticalAlert")
} else if (grossMarginPct <= redAlert) {
    api.redAlert("GrossMarginPct was less or equal than the red alert threshold of $redAlert")
} else if (grossMarginPct <= yellowAlert) {
    api.yellowAlert("GrossMarginPct was less or equal than the yellow alert threshold of $yellowAlert")
}