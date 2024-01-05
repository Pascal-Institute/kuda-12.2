package kuda.runtimeapi.structure

import kuda.runtimeapi.prop.ChannelFormatKind

//https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaChannelFormatDesc.html#structcudaChannelFormatDesc

data class ChannelFormatDesc(
    val f: ChannelFormatKind,
    val w: Int,
    val x: Int,
    val y: Int,
    val z: Int
)