if (api.product() == null) {
    api.addWarning("Product was not set")
    return null
}

return api.product().attribute2