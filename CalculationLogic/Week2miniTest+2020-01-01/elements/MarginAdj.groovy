try {
    def basePrice = out.BasePrice.attribute1[0] as BigDecimal
    def marginPCT = out.MarginPCT.value[0] as BigDecimal
    basePrice * marginPCT
} catch (e) {
    api.criticalAlert(e.getMessage())
}