package kuda.runtimeapi.structure

data class PitchedPtr(
    var pitch : Int,
    var ptr : Long,
    var xSize : Int,
    var ySize : Int
)
