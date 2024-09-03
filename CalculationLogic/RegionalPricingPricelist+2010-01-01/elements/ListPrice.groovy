if (out.BasePrice == null) {
    api.criticalAlert("Base price was not set")
    return null
}

if (out.MarginAdj == null) {
    api.criticalAlert("Margin adjustment was not calculated")
    return null
}

if (out.AttributeAdj == null) {
    api.criticalAlert("Attribute adjustment was not calculated")
    return null
}

if (out.PackagingAdj == null) {
    api.criticalAlert("Packaging adjustment was not calculated")
    return null
}

if (out.TaxTariffAdj == null) {
    api.criticalAlert("Tax tariff adjustment was not calculated")
    return null
}

return out.BasePrice + out.MarginAdj + out.AttributeAdj + out.PackagingAdj + out.TaxTariffAdj