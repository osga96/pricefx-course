if (out.BasePrice == null) {
    api.addWarning("There was a problem getting the base price value")
    return null
}

if (out.PackagingAdj == null) {
    api.addWarning("There was a problem getting the packaging adjustment % value")
    return null
}

if (out.CompetitivePositioningPct == null) {
    api.addWarning("There was a problem getting the competitive positioning % value")
    return null
}

if (out.TaxAdj == null) {
    api.addWarning("There was a problem getting the tax % value")
    return null
}

return out.BasePrice + out.PackagingAdj + out.CompetitivePositioningPct + out.TaxAdj