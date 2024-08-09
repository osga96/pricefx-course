if (out.Price == null) {
    api.addWarning("Price was null")
    return null
}

if (input.RadioEntry == null) {
    api.addWarning("RadioEntry was null")
    return null
}

if (input.OptionEntry == null) {
    api.addWarning("OptionEntry was null")
    return null
}

def price = out.Price as BigDecimal
def radioEntry = input.RadioEntry as BigDecimal
def optionEntry = input.OptionEntry as BigDecimal

def suffix = out.Currency

def adjustmentPrice = price * (1 + radioEntry + optionEntry)

return libs.SharedLib.RoundingUtils.round(adjustmentPrice, 2)
