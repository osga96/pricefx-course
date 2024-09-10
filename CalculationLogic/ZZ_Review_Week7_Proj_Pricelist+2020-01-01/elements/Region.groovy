if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createTextUserEntry("Region")
            .setLabel("Region")
            .getInput()
}

return input.Region
