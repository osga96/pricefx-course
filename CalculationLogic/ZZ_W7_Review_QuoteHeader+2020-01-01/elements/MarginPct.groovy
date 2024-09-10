def lineItems = quoteProcessor.quoteView.lineItems.findAll {
    !it.folder
}

def totalMargin = 0.0
def totalQuantity = 0

lineItems.each { lineItem ->
    def marginRow = lineItem?.outputs?.find {
        "Margin".equals(it.resultName)
    }

    def marginValue = marginRow?.getAt("result")

    if (marginValue != null && marginValue instanceof BigDecimal) {
        totalMargin += marginValue
    }

    def quantityRow = lineItem?.inputs?.find {
        "Quantity".equals(it.name)
    }

    def quantityValue = quantityRow?.getAt("value")

    if (quantityValue != null && quantityValue instanceof Integer) {
        totalQuantity += quantityValue
    }
}

if (totalMargin == 0 || totalQuantity == 0) {
    api.addWarning("MarginPct could not be calculated")
    return null
}

def output = [
        "resultName" : "MarginPct",
        "resultLabel" : "Margin %",
        "result" : totalMargin / totalQuantity
]

quoteProcessor.addOrUpdateOutput(output)