try {
    api.find("C", 0, 1, null, ["CustomerCurrency"], Filter.equal("customerId", out.Customer))["CustomerCurrency"][0]
} catch (e) {
    api.criticalAlert(e.getMessage())
}