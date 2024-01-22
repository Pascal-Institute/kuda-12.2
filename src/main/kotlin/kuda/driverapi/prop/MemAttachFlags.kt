package kuda.driverapi.prop

/**
 *
 * CUDA Mem Attach Flags
 *
 * @property GLOBAL Memory can be accessed by any stream on any device
 * @property HOST Memory cannot be accessed by any stream on any device
 * @property SINGLE Memory can only be accessed by a single stream on the associated device
 */
enum class MemAttachFlags(val byte : Byte) {
    GLOBAL(0x1),
    HOST(0x2),
    SINGLE(0x4)
}