package kuda.runtimeapi.prop

enum class StreamCaptureStatus(val num : Int) {
    NONE(0),
    ACTIVE(1),
    INVALIDATED(2)
}