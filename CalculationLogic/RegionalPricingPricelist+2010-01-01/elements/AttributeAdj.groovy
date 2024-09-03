if (out.BasePrice == null) {
    api.addWarning("Base price was not set")
    return null
}

if (out.AttributeAdjustmentPct == null) {
    api.addWarning("Attribute adjustment % was not fetched")
    return null
}

return out.BasePrice * out.AttributeAdjustmentPct