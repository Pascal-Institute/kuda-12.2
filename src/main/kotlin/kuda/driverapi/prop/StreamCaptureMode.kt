package kuda.driverapi.prop

/**
 * Possible modes for stream capture thread interactions. For more details see cuStreamBeginCapture and cuThreadExchangeStreamCaptureMode (CUstreamCaptureMode)
 *
 * @property GLOBAL
 * @property THREAD_LOCAL
 * @property RELAXED
 */
enum class StreamCaptureMode(val num : Int) {
    GLOBAL(0),
    THREAD_LOCAL(1),
    RELAXED(2)
}