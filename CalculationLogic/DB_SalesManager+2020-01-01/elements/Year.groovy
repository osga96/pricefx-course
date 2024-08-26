/*
if (api.isInputGenerationExecution()) {
    return api.inputBuilderFactory()
            .createDmFilter("Year", "DM.Transaction", "InvoiceDateYear")
            .getInput()
}

return input.Year
*/
def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def column = dm.getColumn("InvoiceDateYear")

return ctx.dimFilterEntry("Year", column)?.getValue()

// Then we set dynamic inputs to generate inputs every time the dashboard is reloaded.