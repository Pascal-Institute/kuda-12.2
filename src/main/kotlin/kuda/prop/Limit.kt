package kuda.prop

enum class Limit(val byte: Byte) {
    STACK_SIZE((0).toByte()),
    PRINT_FIFO_SIZE((1).toByte()),
    MALLOC_HEAP_SIZE((2).toByte()),
    DEV_RUNTIME_SYNC_DEPTH((3).toByte()),
    DEV_RUNTIME_PENDING_LAUNCH_COUNT((4).toByte()),
    MAX_L2_FETCH_GRANULARITY((5).toByte()),
    PERSISTING_L2_CACHE_SIZE((0).toByte())
}