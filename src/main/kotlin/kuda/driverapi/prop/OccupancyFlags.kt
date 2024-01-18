package kuda.driverapi.prop

/**
 * @property DEFAULT Default behavior
 * @property DISABLE_CACHING_OVERRIDE Assume global caching is enabled and cannot be automatically turned off
 */
enum class OccupancyFlags(val byte : Byte) {
    DEFAULT(0x0),
    DISABLE_CACHING_OVERRIDE(0x1)
}