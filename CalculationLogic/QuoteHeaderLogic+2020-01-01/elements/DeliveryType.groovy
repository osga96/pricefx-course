if (quoteProcessor.isPostPhase()) {              // (1)
    return
}

def deliveryType = api.inputBuilderFactory()     // (2)
        .createOptionEntry("DeliveryType")
        .setLabel("Delivery Type")
        .setRequired(true)
        .setOptions(["Express", "Standard"])
        .setLabels(["Express": "Express Delivery", "Standard": "Standard Delivery"])
        .buildMap()                             // (3)

quoteProcessor.addOrUpdateInput(deliveryType)   // (4)