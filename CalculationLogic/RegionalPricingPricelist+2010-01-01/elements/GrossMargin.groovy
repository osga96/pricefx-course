if (out.BasePrice == null) {
    api.addWarning("Base price was not set")
    return null
}

if (out.ListPrice == null) {
    api.addWarning("List price was not calculated")
    return null
}

return (out.ListPrice - out.BasePrice) / out.ListPrice