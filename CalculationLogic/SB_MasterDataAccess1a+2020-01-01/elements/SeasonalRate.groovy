def filterRegion = Filter.equal("key1", out.CustomerRegion[0].attribute5)
def filterPG = Filter.equal("key2", out.ProductGroup[0].attribute1)
def filterDate = Filter.lessThan("key3", api.targetDate())

def output = data = api.findLookupTableValues("SeasonalRate", filterPG, filterRegion, filterDate)
//
//while(data = api.findLookupTableValues("SeasonalRate", filterPG, filterRegion, filterDate)) {
//    start += data.size()
//    for (row in data) {
//        def out = [
//                "CustomerId": row.customerId,
//                "Name": row.name,
//                "CustomerGroup": row.attribute1,
//                "BuyingGroup": row.attribute2,
//        ]
//        api.trace("Row: ", out)
//    }
//}