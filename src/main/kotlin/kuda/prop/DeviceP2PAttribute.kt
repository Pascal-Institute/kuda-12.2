package kuda.prop

enum class DeviceP2PAttribute(val num : Int) {
    PERFORMANCE_RANK(1),
    ACCESS_SUPPORTED(2),
    NATIVE_ATOMIC_SUPPORTED(3),
    CUDA_ARRAY_ACCESS_SUPPORTED(4)
}