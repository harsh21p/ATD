package com.atd.atdmobileapp.models.vehicle

data class InstallationSpecResponse(
    val psi: TirePressure,
    val minrim: RimSize,
    val maxrim: RimSize,
    val torque: Torque,
    val diameter: Diameter,
    val speed: Speed,
    val weight: Weight,
    val height: Height,
    val offset: Offset,
    val bolts: Bolts,
    val boltcircle: BoltCircle,
    val boltoetiressize: BoltOEtiressize,
    val vehiclehubsize: VehicleHubSize,
    val oerimwidth: OERimWidth,
    val oewheelsize: OEWheelSize,
    val oelugsize: OELugSize
)

data class TirePressure(
    val front: String,
    val rear: String
)

data class RimSize(
    val front: String,
    val rear: String
)

data class Torque(
    val front: String,
    val rear: String
)

data class Diameter(
    val front: String,
    val rear: String
)

data class Speed(
    val front: String,
    val rear: String
)

data class Weight(
    val front: String,
    val rear: String
)

data class Height(
    val front: String,
    val rear: String
)

data class Offset(
    val front: String,
    val rear: String
)

data class Bolts(
    val front: String,
    val rear: String
)

data class BoltCircle(
    val front: String,
    val rear: String
)

data class BoltOEtiressize(
    val front: String,
    val rear: String
)

data class VehicleHubSize(
    val front: String,
    val rear: String
)

data class OERimWidth(
    val front: String,
    val rear: String
)

data class OEWheelSize(
    val front: String,
    val rear: String
)

data class OELugSize(
    val front: String,
    val rear: String
)
