def pEx = api.productExtension("ReviewProductExtension")

if (pEx == null) {
    return null
}

def price = pEx[0]?.attribute1

price = price as BigDecimal

return price - (price * 0.1)