def fields = ["price"]

try {
    api.find("PCOMP", 0, 1, "-price", fields)[0].price as BigDecimal
} catch (e) {
    api.criticalAlert(e.getMessage())
}