def startRow = 0

try {
    while (rows = api.find("PCOMP", startRow, api.getMaxFindResultsLimit(), null)) {
        return rows
    }
} catch (e) {
    api.criticalAlert(e.getMessage())
}