Map findAllMasterDataPaginated(String typeCode, int start, String sortBy, String tableName) {
    def finalMap = new LinkedHashMap()

    if (typeCode == "C") {
        while (data = api.find(typeCode, start, api.getMaxFindResultsLimit(), sortBy)) {
            start += data.size()
            finalMap.putAll(
                    data.collectEntries {
                        [(it.customerId as String) : it.name]
                    }
            )
        }
    } else if (typeCode == "P"){
        while (data = api.find(typeCode, start, api.getMaxFindResultsLimit(), sortBy)) {
            start += data.size()
            finalMap.putAll(
                    data.collectEntries {
                        [(it.sku as String) : it.label]
                    }
            )
        }
    }

    return finalMap
}