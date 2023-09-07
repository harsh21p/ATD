package com.atd.atdmobileapp.models.myquotes

data class UpdateRequestBody(
    var locationnumber: String?=null,
    var quoteid: String?=null,
    var consumerinfo: Consumerinfo?=null,
    var quotestatus: String?=null,
    var quotecomment: String?=null,
    var sendemailtoconsumer: Boolean?= null,
    var deletereason: String?= null
)
