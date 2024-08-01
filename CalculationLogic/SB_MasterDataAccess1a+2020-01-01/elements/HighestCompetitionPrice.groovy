def fields = ["price"]

api.find("PCOMP", 0, 1, "-price", fields)[0].price as BigDecimal