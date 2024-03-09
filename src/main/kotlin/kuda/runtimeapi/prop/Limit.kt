package kuda.runtimeapi.prop

enum class Limit(val num: Int) {
    STACK_SIZE(0),
    PRINT_FIFO_SIZE(1),
    MALLOC_HEAP_SIZE(2),
    DEV_RUNTIME_SYNC_DEPTH(3),
    DEV_RUNTIME_PENDING_LAUNCH_COUNT(4),
    MAX_L2_FETCH_GRANULARITY(5),
    PERSISTING_L2_CACHE_SIZE(6)
}