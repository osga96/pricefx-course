if (quoteProcessor.isPrePhase()) {
    def customerInput = api.inputBuilderFactory()
            .createCustomerEntry("Customer")
            .buildMap()

    quoteProcessor.addOrUpdateInput(customerInput)
}