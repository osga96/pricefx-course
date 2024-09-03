if (out.BasePrice == null) {
    api.criticalAlert("Base price was not set")
    return null
}

if (out.ListPrice == null) {
    api.criticalAlert("List price was not calculated")
    return null
}

return (out.ListPrice - out.BasePrice) / out.ListPrice