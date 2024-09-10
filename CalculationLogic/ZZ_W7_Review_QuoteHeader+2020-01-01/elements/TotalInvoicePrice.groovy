import net.pricefx.common.apibuilder.clicoll.LineItemHelper

def lineItems = quoteProcessor.getHelper().getRoot()

def totalSum = 0.0

for (LineItemHelper.LineItem lineItem: lineItems.getChildren()) {
    def totalInvoicePriceRow = lineItem.getOutputByName("TotalInvoicePrice")

    if (totalInvoicePriceRow != null) {

        def totalInvoicePrice = totalInvoicePriceRow["result"]

        if (totalInvoicePrice != null && totalInvoicePrice instanceof BigDecimal) {
            totalSum += totalInvoicePrice
        }
    }
}

def output = [
        "resultName" : "TotalInvoicePrice",
        "resultLabel" : "TotalInvoicePrice SUM",
        "result" : totalSum
]

quoteProcessor.addOrUpdateOutput(output)