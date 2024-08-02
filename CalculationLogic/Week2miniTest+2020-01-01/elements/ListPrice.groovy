try {
    def basePrice = out.BasePrice.attribute1[0] as BigDecimal
    def marginAdj = out.MarginAdj
    def attributeAdj = out.AttributeAdj
    def packagingAdj = out.PackagingAdj
    def taxTariffAdj = out.TaxTariffAdj
    def seasonalRate = out.SeasonalRate.attribute1 as BigDecimal

    (basePrice + marginAdj + attributeAdj + packagingAdj + taxTariffAdj) * seasonalRate
} catch (e) {
    api.criticalAlert(e.getMessage())
}
