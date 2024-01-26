package kuda.driverapi.prop

/**
 * Event wait flags (CUevent_wait_flags)
 *
 * @property DEFAULT Default event wait flag
 * @property EXTERNAL When using stream capture, create an event wait node instead of the default behavior. This flag is invalid when used outside of capture.
 */
enum class EventWaitFlags(val num : Int) {
    DEFAULT(0x0),
    EXTERNAL(0x1)
}