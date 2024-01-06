package kuda.runtimeapi.structure

//https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaDeviceProp.html#structcudaDeviceProp

data class DeviceProp(
    val ECCEnabled: Int,
)