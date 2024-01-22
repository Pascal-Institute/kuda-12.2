package kuda.driverapi.prop

/**
 *
 * Limits
 *
 * @property STACK_SIZE GPU thread stack size
 * @property PRINTF_FIFO_SIZE GPU printf FIFO size
 * @property MALLOC_HEAP_SIZE GPU malloc heap size
 * @property DEV_RUNTIME_SYNC_DEPTH GPU device runtime launch synchronize depth
 * @property DEV_RUNTIME_PENDING_LAUNCH_COUNT GPU device runtime pending launch count
 * @property MAX_L2_FETCH_GRANULARITY A value between 0 and 128 that indicates the maximum fetch granularity of L2 (in Bytes). This is a hint
 * @property PERSISTING_L2_CACHE_SIZE A size in bytes for L2 persisting lines cache size
 */
enum class Limit(val byte : Byte) {
    STACK_SIZE(0x00),
    PRINTF_FIFO_SIZE(0x01),
    MALLOC_HEAP_SIZE(0x02),
    DEV_RUNTIME_SYNC_DEPTH(0x03),
    DEV_RUNTIME_PENDING_LAUNCH_COUNT(0x04),
    MAX_L2_FETCH_GRANULARITY(0x05),
    PERSISTING_L2_CACHE_SIZE(0x06)
    //MAX
}