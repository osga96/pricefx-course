if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory()
            .createIntegerUserEntry("Quantity")
            .setFrom(1)
            .setValue(1)
            .setRequired(true)
            .getInput()
}

if (input.Quantity == null || input.Quantity < 1) {
    input.Quantity = 1
}

return input.Quantity as Integer