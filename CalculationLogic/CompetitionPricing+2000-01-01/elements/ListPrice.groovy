if (out.CompetitorProductPrice == null) {
    api.addWarning("CompetitorProductPrice was null")
    return null
}

if (out.CompetitivePositioning == null) {
    api.addWarning("CompetitivePositioning was null")
    return null
}

// Week7 Competitive Pricing
return out.CompetitorProductPrice * out.CompetitivePositioning