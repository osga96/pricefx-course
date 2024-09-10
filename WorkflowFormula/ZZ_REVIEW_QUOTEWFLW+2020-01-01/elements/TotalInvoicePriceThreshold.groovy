def totalInvoicePriceRow = quote.outputs.find {
    "TotalInvoicePrice".equals(it.resultName)
}

if (totalInvoicePriceRow == null) {
    return
}

def totalInvoicePrice = totalInvoicePriceRow["result"]

def customerRow = quote.inputs.find {
    "Customer".equals(it.name)
}

def customerFilters = [Filter.equal("customerId", customerRow?.value)]

def results = api.stream("C", null, *customerFilters).withCloseable {
    it.collect()
}

def region = ""
results.each {
    region = it.attribute5
}

if (!"".equals(region)) {
    def approvalFilters = [Filter.equal("key2", region)]

    def thresholdRows = api.findLookupTableValues("ApprovalThreshold", "attribute2", *approvalFilters)

    thresholdRows.each {

        if ("1".equals(it?.key1)) {
            if (totalInvoicePrice > it?.attribute2) {
                workflow.addApprovalStep("SalesManager")
                        .withUserGroupApprovers("SalesManager")
                        .withMinApprovalsNeeded(1)
            }
        }

        if ("2".equals(it?.key1)) {
            workflow.addApprovalStep("VPSales")
                    .withUserGroupApprovers("VPSales")
                    .withMinApprovalsNeeded(1)
        }

        if ("3".equals(it?.key1)) {
            if ("America".equals(region)) {
                workflow.addApprovalStep("CFO")
                        .withUserGroupApprovers("CFO")
                        .withMinApprovalsNeeded(1)
            } else if ("Europe".equals(region)) {
                workflow.addApprovalStep("Sales_EU_Director")
                        .withUserGroupApprovers("Sales_EU_Director")
                        .withMinApprovalsNeeded(1)
            }
        }

        if ("4".equals(it?.key1)) {
            workflow.addApprovalStep("CFO")
                    .withUserGroupApprovers("CFO")
                    .withMinApprovalsNeeded(1)
        }
    }

}