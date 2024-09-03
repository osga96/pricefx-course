if (out.BasePrice == null) {
    api.addWarning("Base price was not set")
    return null
}

if (out.MarginAdj == null) {
    api.addWarning("Margin adjustment was not calculated")
    return null
}

if (out.AttributeAdj == null) {
    api.addWarning("Attribute adjustment was not calculated")
    return null
}

if (out.PackagingAdj == null) {
    api.addWarning("Packaging adjustment was not calculated")
    return null
}

if (out.TaxTariffAdj == null) {
    api.addWarning("Tax tariff adjustment was not calculated")
    return null
}

return out.BasePrice + out.MarginAdj + out.AttributeAdj + out.PackagingAdj + out.TaxTariffAdj