if (out.ProductId == null) {
    api.addWarning("Product was not set")
    return null
}

def datamartContext = api.getDatamartContext()
def transactionsDatamart = datamartContext.getDatamart("Transaction")
def query = datamartContext.newQuery(transactionsDatamart, true)

query.select("SUM(Quantity)", "Quantity")
query.where(Filter.equal("ProductId", api.product("ProductId")))
query.where(Filter.equal("CustomerId", out.CustomerId))

def result = datamartContext.executeQuery(query)

def quantity = 0
result?.data.each {
    quantity = it.Quantity
}
if (quantity == null) {
    return 0
}

return quantity