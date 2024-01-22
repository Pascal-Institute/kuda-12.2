package kuda.driverapi.prop

/**
 *
 * Memory types
 *
 * @property HOST Host memory
 * @property DEVICE Device memory
 * @property ARRAY Array memory
 * @property UNIFIED Unified device or host memory
 */
enum class MemoryType(val byte : Byte) {
    HOST(0x01),
    DEVICE(0x02),
    ARRAY(0x03),
    UNIFIED(0x04)
}