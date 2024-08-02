try {
    api.find("C", 0, 1, null, ["customerId"], Filter.equal("customerId", "CD-00004"))["customerId"][0]
} catch (e) {
    api.criticalAlert(e.getMessage())
}
