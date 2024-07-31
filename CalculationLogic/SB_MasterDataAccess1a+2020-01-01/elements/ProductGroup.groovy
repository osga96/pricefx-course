import com.googlecode.genericdao.search.Filter

def filter = Filter.equal("sku", "MB-0001")

def output = api.find("P", 0, api.getMaxFindResultsLimit(), "sku", filter)