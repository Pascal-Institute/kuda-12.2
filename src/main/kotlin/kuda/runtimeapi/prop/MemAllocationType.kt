package kuda.runtimeapi.prop

enum class MemAllocationType(val byte : Byte) {
    INVALID((0).toByte()),
    PINNED((1).toByte()),
    MAX((Int.MAX_VALUE).toByte())
}