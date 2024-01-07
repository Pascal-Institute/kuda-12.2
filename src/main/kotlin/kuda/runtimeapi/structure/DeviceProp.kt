package kuda.runtimeapi.structure

//https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaDeviceProp.html#structcudaDeviceProp

data class DeviceProp(
    var eccEnabled: Int,
    var accessPolicyMaxWindowSize : Int,
    var asyncEngineCount : Int,
    var  canMapHostMemory : Int,
    var canUseHostPointerForRegisteredMem : Int,
    var clockRate : Int,
    var clusterLaunch : Int,
    var computeMode : Int,
    var computePreemptionSupported : Int,
    var concurrentKernels : Int,
    var concurrentManagedAccess : Int,
    var cooperativeLaunch : Int,
    var cooperativeMultiDeviceLaunch : Int,
    var deferredMappingCudaArraySupported : Int,
    var deviceOverlap : Int,
    var directManagedMemAccessFromHost : Int,
    var globalL1CacheSupported : Int,
    var gpuDirectRDMAFlushWritesOptions : UInt,
    var gpuDirectRDMASupported : Int,
    var gpuDirectRDMAWritesOrdering : Int,
    var hostNativeAtomicSupported : Int,
    var hostRegisterReadOnlySupported : Int,
    var hostRegisterSupported : Int,
    var integrated : Int,
    var ipcEventSupported : Int,
    var isMultiGpuBoard : Int,
    var kernelExecTimeoutEnabled : Int,
    var l2CacheSize : Int,
    var localL1CacheSupported : Int,
//    char  luid[8]
    var luidDeviceNodeMask : UInt,
    var major : Int,
    var managedMemory : Int,
    var maxBlocksPerMultiProcessor : Int,
//int  maxGridSize[3]
    var maxSurface1D : Int,
//int  maxSurface1DLayered[2]
//int  maxSurface2D[2]
//int  maxSurface2DLayered[3]
//int  maxSurface3D[3]
    var maxSurfaceCubemap : Int,
//int  maxSurfaceCubemapLayered[2]
    var maxTexture1D : Int,
//int  maxTexture1DLayered[2]
    var maxTexture1DLinear : Int,
    var maxTexture1DMipmap : Int,
//int  maxTexture2D[2]
//int  maxTexture2DGather[2]
//int  maxTexture2DLayered[3]
//int  maxTexture2DLinear[3]
//int  maxTexture2DMipmap[2]
//int  maxTexture3D[3]
//int  maxTexture3DAlt[3]
    var maxTextureCubemap : Int,
//int  maxTextureCubemapLayered[2]
//int  maxThreadsDim[3]
    var maxThreadsPerBlock : Int,
    var maxThreadsPerMultiProcessor : Int,
//size_t  memPitch
    var memoryBusWidth : Int,
    var memoryClockRate : Int,
    var memoryPoolSupportedHandleTypes : UInt,
    var memoryPoolsSupported : Int,
    var minor : Int,
    var multiGpuBoardGroupID : Int,
    var multiProcessorCount : Int,
//char  name[256]
    var pageableMemoryAccess : Int,
    var pageableMemoryAccessUsesHostPageTables : Int,
    var pciBusID : Int,
    var pciDeviceID : Int,
    var pciDomainID : Int,
    var persistingL2CacheMaxSize : Int,
    var regsPerBlock : Int,
    var regsPerMultiprocessor : Int,
//int  reserved[60]
//int  reserved1[1]
//size_t  reservedSharedMemPerBlock
//size_t  sharedMemPerBlock
//size_t  sharedMemPerBlockOptin
//size_t  sharedMemPerMultiprocessor
    var singleToDoublePrecisionPerfRatio : Int,
    var sparseCudaArraySupported : Int,
    var streamPrioritiesSupported : Int,
//size_t  surfaceAlignment
    var tccDriver : Int,
//size_t  textureAlignment
//size_t  texturePitchAlignment
    var timelineSemaphoreInteropSupported : Int,
//size_t  totalConstMem
//size_t  totalGlobalMem
    var unifiedAddressing : Int,
    var unifiedFunctionPointers : Int,
//cudaUUID_t  uuid
    var warpSize : Int
)