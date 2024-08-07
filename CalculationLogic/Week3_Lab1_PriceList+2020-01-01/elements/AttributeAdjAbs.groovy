if(null in [out.BasePrice,out.AttributeAdjPct]) {
    api.addWarning("Attribute Adjustment cannot be calculated: missing parameter(s)")
    return null
}

if(out.AttributeAdjPct == 1) {
    api.addWarning("Attribute Adjustment cannot be 100% -> division by 0")
    return null
}

return out.BasePrice * out.AttributeAdjPct