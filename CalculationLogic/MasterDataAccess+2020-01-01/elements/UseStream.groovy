// Meant to be used for larger quantities of data.
def row =[:]    //define row as Map outside of loop

List<String> fields = ["sku", "attribute1", "attribute2"]

api.stream("P", "sku", fields)?.withCloseable { iterator->
    iterator.each {record->

        if (record.sku != null && record.attribute1 != null) {
            row = [
                    "sku"         : record.sku,
                    "ProductGroup": record.attribute1,
                    "BusinessUnit": record.attribute2
            ]
        }
        api.trace("Row: ", row)
    }
}