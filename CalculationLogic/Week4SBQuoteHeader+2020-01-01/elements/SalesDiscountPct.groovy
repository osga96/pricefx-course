if (quoteProcessor.isPostPhase()) {
    return
}

def salesDiscountPct = api.inputBuilderFactory()
        .createUserEntry("SalesDiscountPct")
        .setFormatType("PERCENT")
        .setLabel("Sales Discount %")
        .setFrom(0.00)
        .setTo(1.00)
        .setValue(0)
        .buildMap()

quoteProcessor.addOrUpdateInput(salesDiscountPct)