def listPrice = out.ListPrice

if (listPrice == null || listPrice == 0) {
    api.criticalAlert("List price was either null or 0")
    return null
}

def customerDiscount = input.CustomerDiscount

if (customerDiscount == null || customerDiscount == 0) {
    return 0
}

return listPrice - (listPrice * customerDiscount)