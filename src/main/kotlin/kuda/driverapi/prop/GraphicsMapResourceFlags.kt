package kuda.driverapi.prop

/**
 *
 * Flags for mapping and unmapping interop resources
 *
 * @property NONE
 * @property READ_ONLY
 * @property WRITE_DISCARD
 */
enum class GraphicsMapResourceFlags(val num : Int) {
    NONE(0x00),
    READ_ONLY(0x01),
    WRITE_DISCARD(0x02)
}