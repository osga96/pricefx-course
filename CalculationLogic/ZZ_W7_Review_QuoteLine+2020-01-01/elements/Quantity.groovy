if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createIntegerUserEntry("Quantity")
            .setLabel("Quantity")
            .setRequired(true)
            .setValue(1)
            .getInput()
}

return input.Quantity
