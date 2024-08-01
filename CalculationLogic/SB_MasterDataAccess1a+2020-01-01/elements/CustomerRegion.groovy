import com.googlecode.genericdao.search.Filter

def filter = Filter.equal("name", "Spagetti M")
def fields = ["name", "attribute5"]

api.find("C", 0, 1, "name", fields, filter)