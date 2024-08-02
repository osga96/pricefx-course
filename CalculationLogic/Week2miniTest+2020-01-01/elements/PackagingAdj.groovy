try {
    def basePrice = out.BasePrice.attribute1[0] as BigDecimal
    def packagingPCT = out.PackagingPCT.attribute1[0] as BigDecimal
    basePrice * packagingPCT
} catch (e) {
    api.criticalAlert(e.getMessage())
}