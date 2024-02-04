package kuda.driverapi.prop

/**
 * Operations for cuStreamBatchMemOp (CUstreamBatchMemOpType)
 *
 * @property WAIT_VALUE_32 Represents a cuStreamWaitValue32 operation
 * @property WRITE_VALUE_32 Represents a cuStreamWriteValue32 operation
 * @property WAIT_VALUE_64 Represents a cuStreamWaitValue64 operation
 * @property WRITE_VALUE_64 Represents a cuStreamWriteValue64 operation
 * @property BARRIER Insert a memory barrier of the specified type
 * @property FLUSH_REMOTE_WRITES This has the same effect as CU_STREAM_WAIT_VALUE_FLUSH, but as a standalone operation.
 */
enum class StreamBatchMemOpType(val num : Int) {
    WAIT_VALUE_32(1),
    WRITE_VALUE_32(2),
    WAIT_VALUE_64(4),
    WRITE_VALUE_64(5),
    BARRIER(6),
    FLUSH_REMOTE_WRITES(3)
}