def ctx = api.getDatamartContext()

def dm = ctx.getDatamart("Transaction")

def query = ctx.newQuery(dm, true)
        .select("TransactionId")
        .select("CustomerId")
        .select("InvoiceDate")
        .select("Quantity")
        .where(Filter.equal("Quantity", 1))
        .where(Filter.equal("CustomerId", "CD-00038"))
        .orderBy("InvoiceDate")

def result = ctx.executeQuery(query)

result?.getData()?.collect {
    // TODO: add your code here
    api.trace(it)
}