if (api.product("ProductId") == null) {
    api.addWarning("Product was not set")
    return null
}

return api.product("ProductId")