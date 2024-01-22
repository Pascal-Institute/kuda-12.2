package kuda.driverapi.prop

/**
 *
 * CUDA Ipc Mem Flags
 *
 * @property LAZY_ENABLE_PEER_ACCESS Automatically enable peer access between remote devices as needed
 */
enum class IpcMemFlags(val num : Int) {
    LAZY_ENABLE_PEER_ACCESS(0x1)
}