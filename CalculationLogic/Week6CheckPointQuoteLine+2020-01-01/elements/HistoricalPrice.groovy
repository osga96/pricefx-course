def productId = api.product("ProductId")

if (productId == null) {
    api.addWarning("Historic avg price can't be calculated, product was not set")
    return null
}

def dmCtx = api.getDatamartContext()
def salesDM = dmCtx.getDatamart("Transaction")

def customerId = out.Customer
def datamartQuery = dmCtx.newQuery(salesDM)

datamartQuery.select("ListPrice")
datamartQuery.where(Filter.equal("CustomerId", customerId))
datamartQuery.where(Filter.equal("ProductId", productId))

def result = dmCtx.executeQuery(datamartQuery)

def numberOfTransactions = 0
def totalValue = 0.0

result?.getData()?.forEach { row ->
    totalValue = row.ListPrice
    numberOfTransactions++
}

return totalValue / numberOfTransactions