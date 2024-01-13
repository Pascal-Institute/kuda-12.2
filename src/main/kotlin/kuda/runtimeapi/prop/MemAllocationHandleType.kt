package kuda.runtimeapi.prop

enum class MemAllocationHandleType(val byte : Byte) {
    NONE((0).toByte()),
    POSIX_FILE_DESCRIPTOR((1).toByte()),
    WIN32((2).toByte()),
    WIN32KMT((4).toByte())
}