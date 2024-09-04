if (quoteProcessor.isPostPhase()) {
    def totalInvoicePrice = out.TotalInvoicePrice

    if (totalInvoicePrice == null || totalInvoicePrice == 0) {
        api.addWarning("Total invoice price could not be calculated correctly, actual value: " + out.TotalInvoicePrice)
        return null
    }

    /*def lineItems = quoteProcessor.quoteView?.lineItems?.findAll {
        !it.folder
    }

    def marginSum = 0.0

    List<String> warnings = new ArrayList<>()

    lineItems.each { lineItem ->
        def marginRow = lineItem?.outputs?.find {
            ("Margin").equals(it?.get("resultName"))
        }

        def margin = marginRow.get("result") as BigDecimal

        if (margin == null) {
            warnings.add("Margin was null")
            return null
        }

        def quantityRow = lineItem?.outputs?.find {
            ("Quantity").equals(it?.get("resultName"))
        }

        def quantity = quantityRow.get("result") as BigDecimal

        if (quantity == null || quantity == 0) {
            warnings.add("Quantity was not set or it was 0")
            return null
        }

        marginSum += margin * quantity
    }

    if (marginSum == 0.0) {
        warnings.add("Margin was not calculated correcly")
        return null
    }

    quoteProcessor.addOrUpdateOutput([
            resultName   : "OverallMarginPct",
            resultLabel  : "Overall Margin %",
            result       : marginSum / totalInvoicePrice,
            formatType   : "PERCENT",
            resultType   : "SIMPLE",
            cssProperties: "background-color:#99FFDD",
            warnings : warnings.isEmpty() ? null : warnings
    ])*/

    def folder = quoteProcessor.getHelper().getRoot()
    def marginSum = 0.0
    List<String> warnings = new ArrayList<>()

    for (lineItem in folder.getChildren()) {
        def margin = lineItem.getOutputByName("Margin").get("result")

        if (margin == null) {
            warnings.add("Margin was null")
            return null
        }

        def quantity = lineItem.getOutputByName("Quantity").get("result")

        if (quantity == null) {
            warnings.add("Quantity was null")
            return null
        }

        marginSum += margin * quantity
    }

    quoteProcessor.addOrUpdateOutput([
            "resultName" : "OverallMarginPct",
            "resultLabel" : "Overall Margin %",
            "result" : marginSum / totalInvoicePrice,
            "formatType" : "PERCENT",
            "resultType" : "SIMPLE",
            "warnings" : warnings.isEmpty() ? null : warnings
     ])
}