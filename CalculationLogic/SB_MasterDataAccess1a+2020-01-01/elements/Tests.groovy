assert out.ProductGroup == [["attribute1": "Beef"]]
assert out.CustomerRegion == [["attribute5" : "Europe", "name" : "Spagetti M"]]
//assert out.SeasonalRate == 1.02 Is this correct?
assert out.AverageCost == 5.17
assert out.LowestProductCost == 0.5
assert out.LowestListPrice == 0.0873540635
assert out.HighestCompetitionPrice == 44.07
assert out.CompetitionData.size() == 956
assert out.RevenueTresholds == [[attribute1:"10000"],[attribute1:"50000"]]
assert out.MaxAverageCost == 15.81
return "Passed!"