def productSize = out.ProductSize

def packagingAdj = api.findLookupTableValues("PackagingAdj", Filter.equal("name", productSize))

if (packagingAdj == null) {
    api.addWarning("Packaging adjustment could not be found")
}

packagingAdj = packagingAdj[0]?.attribute1 as BigDecimal

if (packagingAdj == null || out.BasePrice == null) {
    api.addWarning("Base price or packaging adjustments are null for this product")
}

return packagingAdj * out.BasePrice