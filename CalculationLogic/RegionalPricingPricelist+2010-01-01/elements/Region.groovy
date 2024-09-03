if (api.isInputGenerationExecution()) {
    def regions = api.findLookupTableValues("Region")
            .collectEntries {
                [(it.name): it.attribute1]
            }

    return api.inputBuilderFactory()
            .createOptionEntry("Region")
            .setOptions(regions.keySet() as List)
            .setLabel("Region")
            .setRequired(true)
            .getInput()
}

return input.Region as String