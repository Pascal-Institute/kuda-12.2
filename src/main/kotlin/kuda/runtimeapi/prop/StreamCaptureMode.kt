package kuda.runtimeapi.prop

/**
 * Possible modes for stream capture thread interactions. For more details see cudaStreamBeginCapture and cudaThreadExchangeStreamCaptureMode (cudaStreamCaptureMode)
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