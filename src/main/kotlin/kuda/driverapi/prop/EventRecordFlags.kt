package kuda.driverapi.prop

/**
 * Event record flags (CUevent_record_flags)
 *
 * @property DEFAULT Default event record flag
 * @property EXTERNAL When using stream capture, create an event record node instead of the default behavior. This flag is invalid when used outside of capture.
 */
enum class EventRecordFlags(val num : Int) {
    DEFAULT(0x0),
    EXTERNAL(0x1)
}