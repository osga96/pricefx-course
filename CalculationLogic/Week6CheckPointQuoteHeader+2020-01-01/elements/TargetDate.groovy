if (quoteProcessor.isPostPhase()) {
    return
}

def quoteTargetDate = api.inputBuilderFactory()
        .createHiddenEntry("TargetDate")
        .setLabel("Target Date")
        .setValue(quoteProcessor.getQuoteView().targetDate)
        .buildMap()

quoteProcessor.addOrUpdateInput(quoteTargetDate)