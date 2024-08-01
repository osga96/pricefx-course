def revenueThresholds = new ArrayList()

api.findLookupTableValues("ApprovalLevelsRevenue", null).forEach {
    def filter = Filter.equal("typedId", it.typedId)
    revenueThresholds.add(api.find("MLTV", 0, api.getMaxFindResultsLimit(), null, filter).attribute1)
}
return revenueThresholds