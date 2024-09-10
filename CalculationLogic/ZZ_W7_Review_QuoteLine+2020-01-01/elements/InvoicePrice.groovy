def requestedPrice = input.RequestedPrice

if (requestedPrice != null && requestedPrice instanceof BigDecimal) {
    return requestedPrice as BigDecimal
} else {
    return out.ListPrice as BigDecimal
}