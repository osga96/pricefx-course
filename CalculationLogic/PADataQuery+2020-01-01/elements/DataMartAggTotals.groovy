def dmCtx = api.getDatamartContext()
def salesDM = dmCtx.getDatamart("Transaction")

def filters = [
        Filter.equal("CustomerId", out.Customer)
]

def datamartQuery = dmCtx.newQuery(salesDM, true)

datamartQuery.select("CustomerId", "Customer ID")
datamartQuery.select("COUNTDISTINCT(InvoiceDate)", "invoiceCount")
datamartQuery.select("SUM(Margin)/COUNTDISTINCT(InvoiceDate)", "Avg Profit")
datamartQuery.select("SUM(InvoicePrice)", "Total Revenue")
datamartQuery.select("SUM(Margin)", "Total profit")
datamartQuery.select("SUM(Quantity)", "Total Qty")
datamartQuery.select("SUM(Discount)", "Total Discount")

datamartQuery.where(filters)

def result = dmCtx.executeQuery(datamartQuery)
result?.data.each{ row ->     // row as map
    api.trace("query row", row)
}