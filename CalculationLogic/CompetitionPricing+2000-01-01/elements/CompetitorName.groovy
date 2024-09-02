def competitorData = out.Competition

if (competitorData == null) {
    api.addWarning("Competitor data was not found")
    return null
}

if (competitorData instanceof BigDecimal) {
    api.criticalAlert("Competitor data was a BigDecimal")
    return competitorData
} else {
    return competitorData.get("competitor")
}