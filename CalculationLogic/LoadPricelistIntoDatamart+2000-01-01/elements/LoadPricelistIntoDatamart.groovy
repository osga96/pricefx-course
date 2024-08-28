def fields = ["id", "targetDate"]

def filters = [
        Filter.equal("approvalState", "APPROVED")
]

def priceListIdDates = api.find("PL", 0, api.getMaxFindResultsLimit(), null, fields, *filters)
def target = api.getDatamartRowSet("target")

priceListIdDates.each {priceList ->
    def priceListItemFields = ["sku", "resultPrice", "currency"]

    def priceListItemFilters = [
            Filter.equal("pricelistId", priceList.id)
    ]

    def records = api.stream("PLI", null, priceListItemFields, *priceListItemFilters)
            ?.withCloseable { it.collect() }

    records.each { record ->
        target?.addRow([
                "ProductId" : record.sku,
                "TargetDate" : priceList.targetDate,
                "ResultPrice" : record.resultPrice,
                "Currency" : record.currency
        ])
    }
}