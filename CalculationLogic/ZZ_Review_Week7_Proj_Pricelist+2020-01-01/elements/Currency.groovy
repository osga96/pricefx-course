if (out.Region == null) {
    api.addWarning("Region was null")
    return null
}

def region = out.Region as String

return api.vLookup("Region", "attribute1", region)