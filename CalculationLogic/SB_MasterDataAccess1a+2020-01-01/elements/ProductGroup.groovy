import com.googlecode.genericdao.search.Filter

def filter = Filter.equal("sku", "MB-0001")
def fields = ["attribute1"]

api.find("P", 0, api.getMaxFindResultsLimit(), "sku", fields, filter)[0]