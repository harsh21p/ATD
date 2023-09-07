package com.atd.atdmobileapp.models.myquotes

import com.atd.atdmobileapp.models.Lineitem

data class CreateQuoteRequest(
    var locationnumber :String?= null,
    var lineitems: List<Lineitem>?= null

)
