def totalInvoicePrice = 0.0

quote.lineItems.findAll {
    !it.folder
}.each { lineItem ->
    BigDecimal lineItemTotalInvoicePrice = lineItem.outputs.find {
        it.resultName == "TotalInvoicePrice"
    }?.result

    if (!lineItemTotalInvoicePrice) {
        api.throwException("Unable to build workflow. Unable to calculate " +
                " Total Invoice Price for entire quote. Missing for row " +
                " ${lineItem.sku}")
    }

    totalInvoicePrice += lineItemTotalInvoicePrice


    def highestLevel = "0"
    def highestValue = 0
    def product = ""
    def finalRegion = ""

    def approvalLevels = api.findLookupTableValues("ApprovalThreshold", "ApprovalLevel")
    approvalLevels.each { level ->
        def revenueThreshold = level.attribute2

        if (totalInvoicePrice >= revenueThreshold) {
            def region = level.key2

            if ("Europe".equals(region)) {
                highestLevel = level.key1
                highestValue = totalInvoicePrice
                product = lineItem.label
                finalRegion = region
            }


        }
    }

    if (highestLevel != "0") {
        def customerName = api.customer("CustomerName", quote.customerId)
        def reasonMsg = "Total Euro Price is over level " + highestLevel + ", value " + highestValue + ", for product " + product + ", and company " + customerName

        if (highestLevel == "1") {
            workflow.addApprovalStep("Sales Manager")
                    .withReasons(reasonMsg)
                    .withUserGroupApprovers("SalesManager")
                    .withMinApprovalsNeeded(1)
        }

        if (highestLevel == "2") {
            workflow.addApprovalStep("VP Sales")
                    .withReasons(reasonMsg)
                    .withUserGroupApprovers("VPSales")
                    .withMinApprovalsNeeded(1)
        }

        if (highestLevel == "3") {
            workflow.addApprovalStep("Sales EU Director")
                    .withReasons(reasonMsg)
                    .withUserGroupApprovers("Sales_EU_Director")
                    .withMinApprovalsNeeded(1)
        }

        if (highestLevel == "4") {
            workflow.addApprovalStep("CFO")
                    .withReasons(reasonMsg)
                    .withUserGroupApprovers("CFO")
                    .withMinApprovalsNeeded(1)
        }
    }

}