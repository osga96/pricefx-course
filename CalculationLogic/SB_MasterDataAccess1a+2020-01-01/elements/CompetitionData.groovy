def startRow = 0

while (rows = api.find("PCOMP", startRow, api.getMaxFindResultsLimit(), null)) {
    return rows
}