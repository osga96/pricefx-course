def ctx = api.getDatamartContext()
def transactionsDatamartTable = ctx.getDatamart("Transaction")

def query = ctx.newQuery(transactionsDatamartTable, true)

query.select("SUM(Quantity)", "QuantitySum")
query.select("ProductId")
query.where(Filter.equal("ProductId", api.product("sku")))

def quantitySum = 0
ctx.executeQuery(query).getData().forEach {
    quantitySum =  it.QuantitySum
}

return quantitySum
