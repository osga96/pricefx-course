try {
    api.find("C", 0, 1, null, ["Region"], Filter.equal("customerId", out.Customer))["Region"][0]
} catch (e) {
    api.criticalAlert(e.getMessage())
}