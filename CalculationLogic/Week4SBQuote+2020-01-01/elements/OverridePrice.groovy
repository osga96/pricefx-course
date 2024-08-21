if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createUserEntry("OverridePrice")
            .setLabel("Override Price")
            .setValue(0)
            .setRequired(false)
            .getInput()
}

return input.OverridePrice as BigDecimal
