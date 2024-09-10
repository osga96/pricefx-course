if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createUserEntry("RequestedPrice")
            .setLabel("RequestedPrice")
            .getInput()
}

return input.RequestedPrice
