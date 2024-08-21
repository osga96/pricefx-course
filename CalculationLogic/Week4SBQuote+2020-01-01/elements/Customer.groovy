if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createCustomerEntry("Customer")
            .setLabel("Customer")
            .getInput()
}

return input.Customer