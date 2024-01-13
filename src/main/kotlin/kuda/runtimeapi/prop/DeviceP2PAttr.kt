package kuda.runtimeapi.prop

/**
 * @property PERFORMANCE_RANK A relative value indicating the performance of the link between two devices
 * @property ACCESS_SUPPORTED Peer access is enabled
 * @property NATIVE_ATOMIC_SUPPORTED Native atomic operation over the link supported
 * @property CUDA_ARRAY_ACCESS_SUPPORTED Accessing CUDA arrays over the link supported
 */

enum class DeviceP2PAttr(val num : Int) {
    PERFORMANCE_RANK(1),
    ACCESS_SUPPORTED(2),
    NATIVE_ATOMIC_SUPPORTED(3),
    CUDA_ARRAY_ACCESS_SUPPORTED(4)
}