def listPrice = out.ListPrice

if (listPrice == null || listPrice == 0) {
    api.criticalAlert("List price was either null or 0")
    return null
}

def adjustment = out.AttributeAdjustmentPct

if (adjustment == null) {
    return 0
}

if (adjustment > 1) {
    adjustment = adjustment / 100
}

return listPrice * adjustment