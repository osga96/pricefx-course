if (quoteProcessor.isPostPhase()) {
    return
}

def geographicAdjustment = api.inputBuilderFactory()
        .createBooleanUserEntry("GeographicAdjustment")
        .setLabel("Greographic Adjustment Charge")
        .buildMap()

quoteProcessor.addOrUpdateInput(geographicAdjustment)