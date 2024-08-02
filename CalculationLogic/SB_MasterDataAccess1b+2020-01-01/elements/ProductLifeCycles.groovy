def fields = ["ProductLifeCycle"]

try {
    api.findLookupTableValues("AttributeAdj", fields, null)
} catch (e) {
    api.criticalAlert(e.getMessage())
}