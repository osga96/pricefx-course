if (quoteProcessor.isPostPhase()) {
    return
}

def customerDiscount = api.inputBuilderFactory()
        .createUserEntry("CustomerDiscount")
        .setLabel("Customer Discount")
        .setValue(0.00)
        .setFrom(0.00)
        .setTo(1.00)
        .buildMap()

quoteProcessor.addOrUpdateInput(customerDiscount)