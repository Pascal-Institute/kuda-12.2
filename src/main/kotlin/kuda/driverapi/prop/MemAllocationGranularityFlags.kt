package kuda.driverapi.prop

/**
 *
 * Flag for requesting different optimal and required granularities for an allocation.
 *
 * @property MINIMUM Minimum required granularity for allocation
 * @property RECOMMENDED Recommended granularity for allocation for best performance
 */
enum class MemAllocationGranularityFlags(val num : Int) {
    MINIMUM(0x0),
    RECOMMENDED(0x1)
}