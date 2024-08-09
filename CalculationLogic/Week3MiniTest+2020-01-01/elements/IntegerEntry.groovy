if (api.isInputGenerationExecution()) {
    api.inputBuilderFactory()
            .createIntegerUserEntry("IntegerEntry")
            .setFrom(1 as Float)
            .setTo(10 as Float)
            .getInput()
}
def intValue = input.IntegerEntry as Integer

if (intValue < 1 || intValue > 10) {
    api.addWarning("Integer value has to be 1-10")
    return null
}

return intValue