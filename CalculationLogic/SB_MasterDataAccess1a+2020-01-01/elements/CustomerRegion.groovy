import com.googlecode.genericdao.search.Filter

def filter = Filter.equal("name", "Spagetti M")
def fields = ["name", "attribute5"]

try {
    api.find("C", 0, 1, "name", fields, filter)
} catch (e) {
    api.criticalAlert(e.getMessage())
}