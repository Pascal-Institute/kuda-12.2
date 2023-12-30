package kuda.block

//https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaExtent.html#structcudaExtent

data class Extent(
    val depth: Long,
    val height: Long,
    val width: Long
)