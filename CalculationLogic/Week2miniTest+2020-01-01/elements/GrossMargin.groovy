def listPrice = out.ListPrice
def basePrice = out.BasePrice.attribute1[0] as BigDecimal

(listPrice - basePrice) / listPrice