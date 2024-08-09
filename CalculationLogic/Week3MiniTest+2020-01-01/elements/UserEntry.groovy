if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createUserEntry("UserEntry")
            .setLabel("User Entry Big Decimal")
            .getInput()
}

if (!input.UserEntry instanceof BigDecimal) {
    api.addWarning("Input UserEntry was not convertable to Big Decimal")
    return null
}

return input.UserEntry as BigDecimal