if (out.Margin == null) {
    api.addWarning("Margin was null")
    return null
}

if (out.ListPrice == null) {
    api.addWarning("ListPrice was null")
    return null
}

return out.Margin / out.ListPrice