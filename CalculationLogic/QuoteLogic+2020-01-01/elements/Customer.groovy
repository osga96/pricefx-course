/*
if (api.isInputGenerationExecution())  {

    if (api.isDebugMode()) {
        def fields = ["Country"]
        def results = api.find("C", 0, api.getMaxFindResultsLimit(), null, fields, null)

        //Get unique/distinct values from list
        def countriesListMap = results.unique { a, b -> a.get("Country") <=> b.get("Country") }

        def countriesList = new ArrayList()
        countriesListMap.each {
            countriesList.add(it.get("Country"))
        }

        api.inputBuilderFactory()
                .createOptionEntry("CustomerCountry")
                .setOptions(countriesList)
                .setLabel("Customer country")
                .getInput()
    }
} else  return input.CustomerCountry*/



if (api.isInputGenerationExecution())  {
//If running in intelliJ give customer input selection
    if (api.isDebugMode()) {
        api.inputBuilderFactory()
                .createCustomerEntry("Customer")
                .setLabel("Customer")
                .getInput()
    }
}
// if not in inputgeneratrionExecution set return to Customer input value
else  return input.Customer