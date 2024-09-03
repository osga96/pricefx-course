if (out.BasePrice == null) {
    api.addWarning("Base price was not set")
    return null
}

if (out.MarginAdjustmentPct == null) {
    api.addWarning("Margin Adjustment % was not fetched")
    return null
}

return out.BasePrice * out.MarginAdjustmentPct