package kuda.driverapi.prop

/**
 *
 * Flags for querying different granularities for a multicast object
 *
 * @property GRANULARITY_MINIMUM Minimum required granularity
 * @property GRANULARITY_RECOMMENDED Recommended granularity for best performance
 */
enum class MulticastGranularityFlags(val byte : Byte) {
    GRANULARITY_MINIMUM(0x0),
    GRANULARITY_RECOMMENDED(0x1)
}