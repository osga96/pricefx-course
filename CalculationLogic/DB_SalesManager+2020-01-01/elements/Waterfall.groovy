def chart = api.newChartBuilder()
        .newWaterfall()
        .getOptions()
        .setHideTooltips(false)
        .back()
        .getSeries()
        .setLabel('Series 1')
        .setDatamart('DM.Transaction')
        .setCurrency('EUR')
        .getAggregation().withTotal().back()
        .setHideDataLabels(false)
        .addWaterfallColumn(WaterfallColumnType.RESULT, 'ListPrice', 'List Price')
        .addWaterfallColumn(WaterfallColumnType.SUBTRACT, 'Discount', 'Discount')
        .addWaterfallColumn(WaterfallColumnType.RESULT, 'InvoicePrice', 'Invoice Price')
        .addWaterfallColumn(WaterfallColumnType.SUBTRACT, 'Cost', 'Margin')
        .addWaterfallColumn(WaterfallColumnType.RESULT, 'Margin', 'Margin')
        .back()
        .getDictionary()
        .buildFromOpaqueString('[{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"","key":"y","keyLabel":"Axis Y","sectionLabel":"Series 1","seriesIndex":0}]')
        .back()
        .build()

return chart