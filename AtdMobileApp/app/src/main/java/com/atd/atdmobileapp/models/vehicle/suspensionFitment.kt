package com.atd.atdmobileapp.models.vehicle

data class SuspensionFitment(
    val vehicleid: String?= null,
    val suspension: String?= null,
    val height: HeightForSuspension?= null
)

class HeightForSuspension(
    val direction: String?= null,
    val value: String?= null
)
