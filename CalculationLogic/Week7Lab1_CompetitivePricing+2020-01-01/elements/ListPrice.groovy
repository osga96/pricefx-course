if (out.CompetitorProductPrice == null) {
    api.addWarning("CompetitorProductPrice was null")
    return null
}

if (out.CompetitivePositioning == null) {
    api.addWarning("CompetitivePositioning was null")
    return null
}

return out.CompetitorProductPrice * out.CompetitivePositioning