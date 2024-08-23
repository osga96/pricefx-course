/**
 * Calculates expected profitability ( Margin % ) of the given Price List Item (PLI)
 *
 * @param pli Object (as Map) of Pricelist Line Item (i.e. single row of the Pricelist)
 * @return the calculated expected profitability ( Margin % ) of the line
 */
def getMarginPct(pli) {
    def basePrice = pli.calculationResults?.find { it.resultName == "BasePrice" }?.result
    def listPrice = pli.calculationResults?.find { it.resultName == "ListPrices" }?.result
    def marginPct = null
    if (listPrice && basePrice != null) marginPct = (listPrice - basePrice) / listPrice
    return marginPct
}
api.stream("PLI", null, Filter.equal("pricelistId", pricelist.id))?.withCloseable { iterator ->
    iterator.each { pli ->
        def marginPct = getMarginPct(pli)
        def businessUnit = api.product("BusinessUnit", pli.sku)

        def filters = [Filter.equal("name", businessUnit)]
        def priceListApprovalLevel = api.findLookupTableValues("PriceListApprovalLevels", *filters)

        if (priceListApprovalLevel != null && priceListApprovalLevel.size() > 0) {
            def threshold = priceListApprovalLevel[0]?.attribute1

            api.trace(marginPct)
            api.trace(threshold)
            api.trace("-----")

            if (threshold != null) {
                if (marginPct < threshold) {
                    workflow.addApprovalStep("Product Manager")
                            .withReasons("Total Invoice Price > " +
                                    (threshold as String) + "EUR")
                            .withUserGroupApprovers("ProductManager")
                            .withMinApprovalsNeeded(1)
                }
            }
        }

    }
}

workflow.addWatcherStep("Pricing  Manager")
        .withUserGroupWatchers("PricingManager")
        .withReasons("PricingManager needs to approve this quote")