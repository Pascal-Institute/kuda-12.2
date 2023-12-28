package kuda.block

//https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaChannelFormatDesc.html#structcudaChannelFormatDesc

import kuda.prop.ChannelFormatKind

data class ChannelFormatDesc(
    val f: ChannelFormatKind,
    val w: Int,
    val x: Int,
    val y: Int,
    val z: Int
)