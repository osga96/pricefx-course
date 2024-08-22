if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createUserEntry("Adjustment")
            .setLabel("Adjustment %")
            .setFormatType("PERCENT")
            .setRequired(false)
            .setValue(0)
            .getInput()
}

return input.Adjustment
