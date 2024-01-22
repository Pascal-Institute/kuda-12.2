package kuda.driverapi.prop

/**
 *
 * Specifies compression attribute for an allocation.
 *
 * @property NONE Allocating non-compressible memory
 * @property GENERIC Allocating compressible memory
 */
enum class MemAllocationCompType(val num : Int) {
    NONE(0x0),
    GENERIC(0x1)
}