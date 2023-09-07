package com.atd.atdmobileapp.models.keywordsearch

import com.atd.atdmobileapp.models.myquotes.AppliedTaxes
import java.io.Serializable

data class  Product(
    val atdproductnumber: String,
    val availability: AvailabilityX,
    val brand: String,
    val description: String,
    val discontinued: Boolean,
    val flaggedbrand: Boolean,
    val images: ImagesX,
    val marketingprograms: List<Marketingprograms>,
    val mfgproductnumber: String,
    val preferredbrand: Boolean,
    val price: PriceX,
    val privatebrand: Boolean,
    val productgroup: String,
    val productspec: ProductspecX,
    val rebates: List<Rebate>,
    val replaced: Boolean,
    val style: String,
    val valuebuysproduct: Boolean,
    val type: String?= null,
    var quantity: Int?= null,
    var appliedtaxes: List<AppliedTaxes>?= null

): Serializable