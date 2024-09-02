if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

if (api.productCompetition() == null) {
    api.addWarning("Product competition was not set")
    return null
}

def lpgTargetDate = api.targetDate()

def filters = [
        Filter.equal("priceType", "Online"),
        Filter.lessOrEqual("infoDate", lpgTargetDate)
]

def competitorData = api.productCompetition(*filters)

if (competitorData == null) {
    api.addWarning("No results in competition data found for product " + api.product() + " and priceType: Online")
    return null
}

// We sort the competitors by latest info dates.
competitorData = competitorData.sort{a,b -> b.infoDate <=> a.infoDate}

return competitorData[0]