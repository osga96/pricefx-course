if (null in [out.BasePrice, out.MarginAdjAbs, out.AttributeAdjAbs]) {
    api.addWarning("List price cannot be calculated. Missing parameter(s).")
    return null
}

def listPrice = out.BasePrice + out.MarginAdjAbs + out.AttributeAdjAbs as BigDecimal
def roundedListPrice = libs.SharedLib.RoundingUtils.round(listPrice, 2)

api.trace("List Price", listPrice)
api.trace("Rounded List Price", roundedListPrice)

return roundedListPrice