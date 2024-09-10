if (out.BasePrice == null) {
    api.addWarning("BasePrice was null")
    return null
}

if (out.MarginAdj == null) {
    api.addWarning("MarginAdj was not set")
    return null
}

if (out.AttributeAdj == null) {
    api.addWarning("AttributeAdj was not set")
    return null
}

if (out.PackagingAdj == null) {
    api.addWarning("PackagingAdj was not set")
    return null
}

if (out.TaxTariffAdj == null) {
    api.addWarning("TaxTariffAdj was not set")
    return null
}

return out.BasePrice + out.MarginAdj + out.AttributeAdj + out.PackagingAdj + out.TaxTariffAdj