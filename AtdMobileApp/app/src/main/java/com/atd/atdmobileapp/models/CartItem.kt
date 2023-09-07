package com.atd.atdmobileapp.models

data class CartItem(val brand: String = "",
                    val style: String = "",
                    val description: String = "",
                    val quantity :Int,
                    val quantityBackOrder :Int,
                    val quantityBackOrderString :String,
                    val productImage :String ="",
                    val supplier:String ="",
                    val cost :String="",
                    val fet :String="",
                    val freight :Double =0.0,
                    val itemSubtotal :String="",
                    val discontinued :Boolean,
                    val createdDate :String=""
)
