if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory()
            .createUserEntry("RequestedPrice")
            .setLabel("Requested Price")
            .getInput()
}

return input.RequestedPrice as BigDecimal