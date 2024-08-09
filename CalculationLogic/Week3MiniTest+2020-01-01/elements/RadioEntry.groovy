if (api.isInputGenerationExecution()) {
    def packagingAdjValuesMap = api
            .findLookupTableValues("PackagingAdj")
            .sort { a,b -> b.name <=> a.name }
            .collectEntries{
                [(it.attribute1 as String) : it.name]
            }

    def valuesList = packagingAdjValuesMap.keySet() as List

    return api.inputBuilderFactory()
            .createRadioEntry("RadioEntry")
            .setLabel("Radio Entry")
            .setOptions(valuesList)
            .setLabels(packagingAdjValuesMap)
            .setValue(valuesList[0])
            .getInput()
}

return input.RadioEntry as BigDecimal