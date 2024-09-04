if (quoteProcessor.isPostPhase()) {
    def lineItems = quoteProcessor.quoteView.lineItems.findAll {
        !it.folder
    }

    def totalInvoicePriceSum = 0.0

    lineItems.each { lineItem ->
        def totalInvoicePriceRow = lineItem?.outputs?.find {
            ("TotalInvoicePrice").equals(it?.get("resultName"))
        }

        def totalInvoicePrice = totalInvoicePriceRow.get("result") as BigDecimal

        if (totalInvoicePrice == null || !totalInvoicePrice instanceof BigDecimal) {
            totalInvoicePrice = 0.0
        }

        totalInvoicePriceSum += totalInvoicePrice
    }

    List<String> warnings = new ArrayList()

    if (totalInvoicePriceSum == 0.0) {
        warnings.add("Total invoice price SUM was 0.0")
    }

    quoteProcessor.addOrUpdateOutput([
            resultName   : "TotalInvoicePrice",
            resultLabel  : "Total Invoice Price",
            result       : totalInvoicePriceSum,
            formatType   : "MONEY",
            resultType   : "SIMPLE",
            cssProperties: "background-color:#ORANGE",
            warnings : warnings.isEmpty() ? null : warnings
    ])

    return totalInvoicePriceSum as BigDecimal
}