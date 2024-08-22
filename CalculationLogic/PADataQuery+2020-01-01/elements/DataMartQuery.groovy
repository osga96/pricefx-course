def dmCtx = api.getDatamartContext()
def salesDM = dmCtx.getDatamart("Transaction")

def customerId = out.Customer
def datamartQuery = dmCtx.newQuery(salesDM)

datamartQuery.select("CustomerId")
datamartQuery.select("Cost")
datamartQuery.select("InvoiceDate")
datamartQuery.where(Filter.equal("CustomerId", customerId))

def result = dmCtx.executeQuery(datamartQuery)
result?.getData()?.forEach { row ->
    api.trace("Customer ID:", row.CustomerId)
    api.trace("Date:", row.InvoiceDate)
    api.trace("Cost", row.Cost)
}