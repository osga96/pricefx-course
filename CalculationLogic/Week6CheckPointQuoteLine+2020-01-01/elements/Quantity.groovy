if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createIntegerUserEntry("Quantity")
            .setLabel("Quantity")
            .setFrom(1 as Float)
            .setValue(1)
            .getInput()
}

if (input.Quantity == null) {
    return 1
}

return input.Quantity
