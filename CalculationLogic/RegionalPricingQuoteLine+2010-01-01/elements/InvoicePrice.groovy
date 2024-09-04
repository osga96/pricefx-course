if (out.RequestedPrice != null) {
    return out.RequestedPrice
}

if (out.ListPrice == null) {
    api.addWarning("List price could not be calculated")
    return null
}

return out.ListPrice