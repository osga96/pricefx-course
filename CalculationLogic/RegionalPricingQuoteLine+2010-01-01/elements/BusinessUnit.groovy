if (api.product() == null) {
    api.addWarning("Product was null")
    return null
}

return api.product("BusinessUnit") as String