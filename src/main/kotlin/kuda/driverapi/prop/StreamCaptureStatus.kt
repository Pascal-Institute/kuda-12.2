package kuda.driverapi.prop

/**
 * Possible stream capture statuses returned by cuStreamIsCapturing (CUstreamCaptureStatus)
 *
 * @property NONE Stream is not capturing
 * @property ACTIVE Stream is actively capturing
 * @property INVALIDATED Stream is part of a capture sequence that has been invalidated, but not terminated
 */
enum class StreamCaptureStatus(val num : Int) {
    NONE(0),
    ACTIVE(1),
    INVALIDATED(2);

    companion object{
        fun fromInt(num : Int) : StreamCaptureStatus ? = entries.find { it.num == num }
    }
}