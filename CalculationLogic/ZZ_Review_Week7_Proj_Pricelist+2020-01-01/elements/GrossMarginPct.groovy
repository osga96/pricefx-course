if (out.BasePrice == null) {
    api.addWarning("BasePrice was null")
    return null
}

if (out.ListPrice == null) {
    api.addWarning("ListPrice was null")
    return null
}

return (out.ListPrice - out.BasePrice) / out.ListPrice