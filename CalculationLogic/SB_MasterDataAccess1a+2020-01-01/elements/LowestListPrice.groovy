def filters = [
        Filter.equal("name", "ListPrice")
]
def fields = [
        "attribute2"
]

def rows = api.find("PX", 0, api.getMaxFindResultsLimit(), "attribute2", fields, *filters)[0]

rows.each {
    // TODO: add your code here
}
