if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createIntegerUserEntry("Quantity")
            .setLabel("Quantity")
            //.setRequired(true) commented for lab 3
            .setValue(1)
            .setFrom(0)
            .getInput()
} else {
    return input.Quantity
}