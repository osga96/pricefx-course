try {
    def basePrice = out.BasePrice.attribute1[0] as BigDecimal
    def attributePCT = out.AttributePCT.attribute1[0] as BigDecimal
    basePrice * attributePCT
} catch (e) {
    api.criticalAlert(e.getMessage())
}