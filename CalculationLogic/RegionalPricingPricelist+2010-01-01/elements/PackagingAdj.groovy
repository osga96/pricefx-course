if (out.BasePrice == null) {
    api.addWarning("Base price was not set")
    return null
}

if (out.PackagingAdjustmentPct == null) {
    api.addWarning("Packaging adjustment % was not fetched")
    return null
}

return out.BasePrice * out.PackagingAdjustmentPct