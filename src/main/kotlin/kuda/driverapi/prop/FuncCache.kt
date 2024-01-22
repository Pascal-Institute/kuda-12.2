package kuda.driverapi.prop

/**
 *
 * Function cache configurations
 *
 * @property PREFER_NONE no preference for shared memory or L1 (default)
 * @property PREFER_SHARED prefer larger shared memory and smaller L1 cache
 * @property PREFER_L1 prefer larger L1 cache and smaller shared memory
 * @property PREFER_EQUAL prefer equal sized L1 cache and shared memory
 */
enum class FuncCache(val num : Int) {
    PREFER_NONE(0x00),
    PREFER_SHARED(0x01),
    PREFER_L1(0x02),
    PREFER_EQUAL(0x03)
}