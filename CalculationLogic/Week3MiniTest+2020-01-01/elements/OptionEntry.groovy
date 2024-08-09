if (api.isInputGenerationExecution()) {
    def productLifecycleMap =
            api.findLookupTableValues("AttributeAdj")
                    .collectEntries {
                        [(it.attribute1 as String) : it.name]
                    }

    def productLifeCycleList = productLifecycleMap.keySet() as List

    api.inputBuilderFactory()
            .createOptionEntry("OptionEntry")
            .setLabel("Product Lifecycle")
            .setOptions(productLifeCycleList)
            .setLabels(productLifecycleMap)
            .getInput()
}

return input.OptionEntry as BigDecimal