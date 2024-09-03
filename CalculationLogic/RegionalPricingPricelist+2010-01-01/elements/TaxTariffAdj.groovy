if (out.BasePrice == null) {
    api.addWarning("Base price was not set")
    return null
}

if (out.TaxTariffAdjustmentPct == null) {
    api.addWarning("Tax tariff adjustment % was not fetched")
    return null
}

return out.BasePrice * out.TaxTariffAdjustmentPct