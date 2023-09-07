package com.atd.atdmobileapp.models

data class Cart(val brand: String = "",
                val style: String = "",
                val description: String = "",
                val quantity :Int = 4,
                val productImage :String ="",
                val supplier:String ="",
                val atdProductNumber:String ="",
                val userName :String="",
                val locationNumber :String="",
                val createdDate :String ="",
                val modifiedDate :String =""
)
