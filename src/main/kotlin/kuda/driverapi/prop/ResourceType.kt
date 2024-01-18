package kuda.driverapi.prop

/**
 *
 * @property ARRAY Array resource
 * @property MIPMAPPED_ARRAY Mipmapped array resource
 * @property LINEAR Linear resource
 * @property PITCH2D Pitch 2D resource
 */
enum class ResourceType(val byte : Byte) {
    ARRAY(0x00),
    MIPMAPPED_ARRAY(0x01),
    LINEAR(0x02),
    PITCH2D(0x03)
}