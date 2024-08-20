api.trace("quoteView", quoteProcessor.quoteView)

if (quoteProcessor.isPrePhase()) {
    api.trace("isPrePhase")
    return
} else if (quoteProcessor.isPostPhase()) {
    api.trace("currentPhase", "isPostPhase")
    List<Object> lineItems = quoteProcessor.quoteView.lineItems.findAll {
        !it.folder
    }

    List<String> warnings = null
    BigDecimal sum = 0.0
    for (lineItem in lineItems) {
        totalInvoicePriceOutputRow = lineItem?.outputs?.find {
            it.resultName?.equals("TotalInvoicePrice")
        }
        if (totalInvoicePriceOutputRow == null || totalInvoicePriceOutputRow?.result == null) {
            sum = null
            warnings = ["Unable to calculate: value for TotalInvoicePrice is " +
                                "missing on one of the line items."]
            break
        }
        sum += totalInvoicePriceOutputRow?.result
    }



    // Add output
    def output = [
            resultName   : "TotalInvoicePrice",
            resultLabel  : "Total Invoice Price",
            result       : sum,
            formatType   : "MONEY_EUR",
            resultType   : "SIMPLE",
            cssProperties: "background-color:#99FFDD",
            warnings : warnings
    ]
    quoteProcessor.addOrUpdateOutput(output)

    return sum

}