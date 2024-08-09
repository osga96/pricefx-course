if (api.isInputGenerationExecution()) {
    def attributeAdjMap = api.findLookupTableValues("AttributeAdj")
            .collectEntries {
                [((it.attribute1 ) as String) : it.name]
            }
    def attributeAdjList = attributeAdjMap.keySet() as List
    return api.inputBuilderFactory()
            .createOptionEntry("OptionEntry")
            .setOptions(attributeAdjList)
            .setLabels(attributeAdjMap)
            .setLabel("OptionEntry")
            .getInput()
}
return input.OptionEntry as BigDecimal

// This returns just 2000
// api.getMaxFindResultsLimit()