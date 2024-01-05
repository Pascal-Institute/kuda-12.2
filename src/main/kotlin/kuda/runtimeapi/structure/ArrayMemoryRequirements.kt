package kuda.runtimeapi.structure

//https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaArrayMemoryRequirements.html#structcudaArrayMemoryRequirements

data class ArrayMemoryRequirements(
    val alignment: Long,
    val size: Long,
)