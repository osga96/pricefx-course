def listPrice = out.ListPrice

if (listPrice == null || listPrice == 0) {
    api.criticalAlert("Invoice price can't be calculated because list price couldn't be calculated or it was 0")
    return null
}

def geographicAdjustmentValue = out.GeographicAdjustmentValue

if (geographicAdjustmentValue == null) {
    api.criticalAlert("Invoice price can't be calculated because geographicAdjustmentValue was null, it should have a numeric value (positive, negative or 0)")
    return null
}

def attributeAdjustmentValue = out.AttributeAdjustmentValue

if (attributeAdjustmentValue == null) {
    api.criticalAlert("Invoice price can't be calculated because attributeAdjustmentValue was null, it should have a numeric value (positive, negative or 0)")
    return null
}

def customerDiscountValue = out.CustomerDiscountValue

if (customerDiscountValue == null) {
    api.criticalAlert("Invoice price can't be calculated because customerDiscountValue was null, it should have a numeric value (positive, negative or 0)")
    return null
}

listPrice = listPrice as BigDecimal
geographicAdjustmentValue = geographicAdjustmentValue as BigDecimal
attributeAdjustmentValue = attributeAdjustmentValue as BigDecimal
customerDiscountValue = customerDiscountValue as BigDecimal

return (listPrice + geographicAdjustmentValue) - (attributeAdjustmentValue + customerDiscountValue)