import com.googlecode.genericdao.search.Filter

def filter = Filter.equal("name", "Spagetti M")

def output = api.find("C", 0, api.getMaxFindResultsLimit(), "name", filter)