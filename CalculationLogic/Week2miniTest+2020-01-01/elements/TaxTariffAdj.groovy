try {
    def basePrice = out.BasePrice.attribute1[0] as BigDecimal
    def taxTariffPCT = out.TaxTariffPCT.value[0] as BigDecimal
    basePrice * taxTariffPCT
} catch (e) {
    api.criticalAlert(e.getMessage())
}