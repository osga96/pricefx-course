def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("PricelistItems")
def column = dm.getColumn("ProductId")

return ctx.dimFilterEntry("ProductId", column)?.getValue()