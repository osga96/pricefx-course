def overridePrice = input.OverridePrice

if (overridePrice == null || overridePrice == 0.00) {
    return 0
}

def listPrice = api.pricelist("GlobalPriceListWeek4")

if (listPrice == null || listPrice == 0.00) {
    return 0
}

return ((overridePrice-listPrice) / ((overridePrice+listPrice) / 2)) * 100 as BigDecimal