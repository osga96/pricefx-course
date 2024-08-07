if (null in [out.BasePrice, out.MarginAdjAbs, out.AttributeAdjAbs]) {
    api.addWarning("List price cannot be calculated. Missing parameter(s).")
    return null
}

return out.BasePrice + out.MarginAdjAbs + out.AttributeAdjAbs