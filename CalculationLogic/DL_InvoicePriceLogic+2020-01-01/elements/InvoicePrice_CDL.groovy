if(api.isInputGenerationExecution()) {
    api.inputBuilderFactory()
            .createUserEntry("ListPrice")
            .getInput()
    api.inputBuilderFactory()
            .createUserEntry("Discount")
            .getInput()
} else {
    if(input.ListPrice == null || input.Discount == null) {
        return null
    }
    return input.ListPrice - input.Discount
}