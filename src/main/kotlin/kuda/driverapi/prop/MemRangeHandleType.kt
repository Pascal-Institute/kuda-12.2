package kuda.driverapi.prop

/**
 *
 * Specifies the handle type for address range
 *
 * @property DMA_BUF_FD
 * @property MAX
 */
enum class MemRangeHandleType(val num : Int) {
    DMA_BUF_FD(0x1),
    MAX(0x7FFFFFFF)
}