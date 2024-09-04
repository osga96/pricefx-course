def ctx = api.getDatamartContext()

def dataMart = ctx.getDatamart("Transaction")

def query = ctx.newQuery(dataMart, true)

// TODO:
// query.select("SUM()")