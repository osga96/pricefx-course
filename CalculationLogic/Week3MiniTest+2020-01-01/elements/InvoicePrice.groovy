if (out.Price == null) {
    api.addWarning("Price was null")
    return null
}

if (input.IntegerEntry == null) {
    api.addWarning("RadioEntry was null")
    return null
}

if (input.UserEntry == null) {
    api.addWarning("OptionEntry was null")
    return null
}

if (out.Adjustment == null) {
    api.addWarning("Adjustment was null")
    return null
}

def price = out.Price as BigDecimal
def integerEntry = input.IntegerEntry as Integer
def userEntry = input.UserEntry as BigDecimal
def adjustment = out.Adjustment as BigDecimal

def invoicePrice = price * integerEntry + userEntry + adjustment

def suffix = out.Currency

return libs.SharedLib.RoundingUtils.round(invoicePrice, 2)