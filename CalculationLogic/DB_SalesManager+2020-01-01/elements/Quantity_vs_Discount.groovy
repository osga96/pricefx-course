def chart = api.newChartBuilder()
        .newScatter()
        .getOptions()
        .setHideLegend(false)
        .setHideTooltips(false)
        .setDisableDrilldown(false)
        .setDisableZoom(false)
        .setDiscretization(true)
        .setDisableGridDiscretization(false)
        .back()
        .addSeries()
        .setLabel('Test Lab 1')
        .setDatamart('DM.Transaction')
        .setCurrency('EUR')
        .setAxisX('Quantity').withTotal().back()
        .setAxisY('Discount').withPercent().back()
        .setAggregationBy('CustomerId')
        .setBandBy('Region')
        .setShowBandByLegend(false)
        .addDimFilter('InvoiceDateYear', out.Year as String)
        .back()
        .getDictionary()
        .buildFromOpaqueString('[{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"∑Quantity","field":{"name":"Quantity","rank":5,"measureType":"EXTENDED","functionalType":"PERUNITBASIS","visibility":1,"source":"DMDS.Transaction","sourceField":"Quantity","expression":"Quantity","system":false,"key":false,"partitioningKey":false,"distributionKey":false,"persisted":true,"calculated":false,"aggregation":false,"deployed":true,"dimension":false,"queryable":true,"auxiliary":false,"numeric":true,"type":"QUANTITY","owningFC":"Transaction","time":false,"messages":{},"label":"Quantity"},"key":"x","keyLabel":"Axis X","sectionLabel":"Series 1","seriesIndex":0},{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"∑Discount/ƒ{base} (%)","field":{"name":"Discount","rank":8,"measureType":"PERUNIT","visibility":1,"source":"DMDS.Transaction","sourceField":"Discount","expression":"Discount","system":false,"key":false,"partitioningKey":false,"distributionKey":false,"persisted":true,"calculated":false,"aggregation":false,"deployed":true,"dimension":false,"queryable":true,"auxiliary":false,"numeric":true,"type":"MONEY","owningFC":"Transaction","time":false,"messages":{},"label":"Discount"},"key":"y","keyLabel":"Axis Y","sectionLabel":"Series 1","seriesIndex":0},{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"Customer Id","field":{"name":"CustomerId","rank":3,"visibility":1,"source":"DMDS.Transaction","sourceField":"CustomerId","expression":"CustomerId","system":false,"key":false,"partitioningKey":false,"distributionKey":false,"persisted":true,"calculated":false,"aggregation":false,"deployed":true,"dimension":true,"queryable":true,"auxiliary":false,"numeric":false,"type":"TEXT","owningFC":"Transaction","time":false,"messages":{},"label":"Customer Id"},"key":"groupBy","keyLabel":"Aggregation By","sectionLabel":"Series 1","seriesIndex":0},{"sectionIdx":1,"category":"PROJECTION","categoryLabel":"Projection","defaultValue":"Region","field":{"name":"Region","rank":24,"visibility":1,"source":"DMDS.Customer","sourceField":"Region","expression":"Region","system":false,"key":false,"partitioningKey":false,"distributionKey":false,"persisted":true,"calculated":false,"aggregation":false,"deployed":true,"dimension":true,"queryable":true,"auxiliary":false,"numeric":false,"type":"TEXT","owningFC":"Customer","time":false,"messages":{},"label":"Region"},"key":"bandBy","keyLabel":"Band By","sectionLabel":"Series 1","seriesIndex":0}]')
        .back()
        .build()

/*
def ctx = api.getDatamartContext()
def dm = ctx.getDatamart("Transaction")
def column = dm.getColumn("InvoiceDateYear")
//def column = dm.getColumn("InvoiceDate")

api.trace("Year is : " + ctx.dimFilterEntry("Year", column)?.getValue())

return ctx.dimFilterEntry("Year", column)?.getValue()
* */

return chart