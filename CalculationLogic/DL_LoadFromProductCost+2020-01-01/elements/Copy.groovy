def target = api.getDatamartRowSet("target")


def filters = [
        Filter.equal("name", "ProductCost")
]

def records = api.stream("PX", null, *filters)
        ?.withCloseable { it.collect() }

records.each {
    target?.addRow(
            [
                    "ProductId": it.sku,
                    "AvgCost": it.attribute1,
            ]
    )

    api.trace(it.attribute1)
}