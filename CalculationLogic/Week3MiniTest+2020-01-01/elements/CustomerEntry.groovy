if (api.isInputGenerationExecution()) {
    def customersMap = libs
            .SharedLib.PaginationUtils.findAllMasterDataPaginated("C", 0, "customerId", "")

    def customersList = customersMap.keySet() as List

    api.inputBuilderFactory()
            .createOptionEntry("CustomerEntry")
            .setLabel("Customer Name")
            .setOptions(customersList)
            .setLabels(customersMap)
            .getInput()
}

return input.CustomerEntry as String