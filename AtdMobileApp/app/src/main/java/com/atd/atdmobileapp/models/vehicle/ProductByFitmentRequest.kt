package com.atd.atdmobileapp.models.vehicle

import com.atd.atdmobileapp.models.keywordsearch.Options
import com.atd.atdmobileapp.models.productsearch.Criteria

data class ProductByFitmentRequest(var locationnumber: String="",
                                   var vehicle: VehicleRequest?= null,
                                   var options: Options? =null,
                                   var criteria: Criteria? =null
)
