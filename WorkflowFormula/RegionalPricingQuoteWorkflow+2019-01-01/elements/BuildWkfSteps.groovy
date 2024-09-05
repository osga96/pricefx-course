if (out.Region == null) {
    api.addWarning("Region was null")
    return null
}

def totalInvoicePriceSum = 0.0

def lineItems = quote.lineItems.findAll {
    !it.folder
}

lineItems.each { lineItem ->
    def totalInvoicePriceRow = lineItem?.outputs?.find {
        ("TotalInvoicePrice").equals(it?.get("resultName"))
    }

    if (totalInvoicePriceRow != null) {
        def totalInvoicePrice = totalInvoicePriceRow?.get("result")

        if (totalInvoicePrice != null && totalInvoicePrice instanceof BigDecimal) {
            totalInvoicePriceSum += totalInvoicePrice
        }
    }
}

if (out.Region == "America"){
    if (totalInvoicePriceSum > 5000) {
        workflow.addApprovalStep("SalesManager")
                .withUserGroupApprovers("SalesManager")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 5000 threshold.")
                .withMinApprovalsNeeded(1)
    }
    if (totalInvoicePriceSum > 10000) {
        workflow.addApprovalStep("VPSales")
                .withUserGroupApprovers("VPSales")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 10000 threshold.")
                .withMinApprovalsNeeded(1)
    }
    if (totalInvoicePriceSum > 25000) {
        workflow.addApprovalStep("CFO")
                .withUserGroupApprovers("CFO")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 25000 threshold.")
                .withMinApprovalsNeeded(1)
    }
} else if (out.Region == "Europe") {
    if (totalInvoicePriceSum > 5000) {
        workflow.addApprovalStep("SalesManager")
                .withUserGroupApprovers("SalesManager")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 5000 threshold.")
                .withMinApprovalsNeeded(1)
    }
    if (totalInvoicePriceSum > 10000) {
        workflow.addApprovalStep("VPSales")
                .withUserGroupApprovers("VPSales")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 10000 threshold.")
                .withMinApprovalsNeeded(1)
    }
    if (totalInvoicePriceSum > 50000) {
        workflow.addApprovalStep("Director")
                .withUserGroupApprovers("Sales_EU_Director")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 50000 threshold.")
                .withMinApprovalsNeeded(1)
    }
    if (totalInvoicePriceSum > 100000) {
        workflow.addApprovalStep("CFO")
                .withUserGroupApprovers("CFO")
                .withReasons("Total invoice price sum of the quote: " + totalInvoicePriceSum + " was higher than the 100000 threshold.")
                .withMinApprovalsNeeded(1)
    }
} else {
    api.addWarning("Region was not recognized")
    return null
}

