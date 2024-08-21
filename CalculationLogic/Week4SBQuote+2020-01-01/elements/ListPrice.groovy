def overridePricePct = out.OverRidePricePCT

if (overridePricePct == null || overridePricePct == 0 || overridePricePct < 50) {
    def listName = "GlobalPriceListWeek4"
    def priceListValue = api.pricelist(listName)

    if (priceListValue == null || priceListValue == 0) {
        api.criticalAlert("Price List value cannot be found for list name: " + listName)
        api.abortCalculation()
        return null
    }

    return priceListValue
    // REVIEW: As I have multiple pricelists created, this cannot be done with find:
    // api.find("PL", 0, api.getMaxFindResultsLimit(), null, ["resultPrice"], Filter.equal("sku", api.currentItem()?.sku))
}

if (overridePricePct >= 50) {
    return input.OverridePrice
}