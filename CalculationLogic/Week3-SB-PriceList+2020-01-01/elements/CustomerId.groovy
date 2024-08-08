def fields = [
        "customerId"
]

def customerIds = api.find("C", 0, api.getMaxFindResultsLimit(), "customerId", fields)
def options = new ArrayList()

customerIds.forEach {
    options.add(it["customerId"])
}

if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory()
    .createOptionEntry("customerId")
    .setLabel("Customer Id")
    .setOptions(options)
    .setValue(options[0])
    .getInput()
}