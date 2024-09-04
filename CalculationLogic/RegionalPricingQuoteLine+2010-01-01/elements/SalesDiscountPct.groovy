import java.math.RoundingMode

if (out.SalesDiscount == null) {
    api.addWarning("Sales discount could not be calculated")
    return null
}

if (out.ListPrice == null || out.ListPrice == 0) {
    api.addWarning("List price could not be calculated")
    return null
}

def salesDiscountPct = out.SalesDiscount / out.ListPrice

if (out.Region == null) {
    api.addWarning("Region was null")
    return null
}

if (out.BusinessUnit == null) {
    api.addWarning("Business Unit was not set for: " + api.product())
    return null
}

def filters = [
        Filter.equal("key1", out.Region),
        Filter.equal("key2", out.BusinessUnit)
]

def thresholds = api.findLookupTableValues("SalesDiscountThreshold", null, *filters)

if (thresholds != null && thresholds.size() > 0) {
    //def yellowAlert = thresholds[0]?.attribute1
    def redAlert = thresholds[0]?.attribute2
    //def criticalAlert = thresholds[0]?.attribute3

    if (redAlert != null && salesDiscountPct > redAlert) {
        api.redAlert("Sales discount of: " + salesDiscountPct + "% is above the red alert threshold: " + redAlert)
    }
}

return out.SalesDiscount.divide(out.ListPrice, RoundingMode.HALF_EVEN)