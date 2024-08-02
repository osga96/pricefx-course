assert out.PocketMarginAlertThreshold == 0.15
assert out.PriceStrategy == ["CriticalAlert": 0.0, "RedAlert": 0.35]
assert out.AlertThreshold == "0.1"
assert out.ExchangeRate == 0.909090909090909
assert out.BusinessUnitCritical == "Alcoholic"
assert out.PriceStrategyLowestRed == [[name: "Sausage"], [name: "Toppings"]]
assert out.ProductLifeCycles == [["ProductLifeCycle": "Decline"],
                                 ["ProductLifeCycle": "Growth"],
                                 ["ProductLifeCycle": "Introduction"],
                                 ["ProductLifeCycle": "Maturity"]]
return "Passed!"