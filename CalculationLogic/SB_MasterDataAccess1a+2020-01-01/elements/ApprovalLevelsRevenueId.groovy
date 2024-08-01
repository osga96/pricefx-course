try {
    api.findLookupTable("ApprovalLevelsRevenue").id
} catch (e) {
    api.criticalAlert(e.getMessage())
}