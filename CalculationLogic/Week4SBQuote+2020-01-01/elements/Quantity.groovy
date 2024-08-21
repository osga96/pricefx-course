if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createUserEntry("Quantity")
            .setLabel("Quantity")
            .setValue(0)
            .setRequired(true)
            .getInput()
}

return input.Quantity
