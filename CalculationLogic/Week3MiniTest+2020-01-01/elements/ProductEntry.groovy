if (api.isInputGenerationExecution()) {
    def productsMap = libs
            .SharedLib.PaginationUtils.findAllMasterDataPaginated("P", 0, "sku", "")

    def productList = productsMap.keySet() as List

    api.inputBuilderFactory()
            .createOptionEntry("ProductEntry")
            .setLabel("Product Name")
            .setOptions(productList)
            .setLabels(productsMap)
            .getInput()
}

return input.ProductEntry as String