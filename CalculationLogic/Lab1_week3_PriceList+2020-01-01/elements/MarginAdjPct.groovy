def marginAdjPct = PriceListLib.marginAdj()

if(marginAdjPct == null) {
    api.addWarning("Unable to look up Margin Adjustment due to invalid Product Group")
}

return marginAdjPct