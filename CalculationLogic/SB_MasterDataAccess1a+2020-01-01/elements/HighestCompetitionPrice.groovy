def fields = ["price"]

api.find("PCOMP", 0, api.getMaxFindResultsLimit(), "-price", fields)[0]