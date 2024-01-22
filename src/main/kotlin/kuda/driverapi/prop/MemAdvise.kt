package kuda.driverapi.prop

/**
 *
 * Memory advise values
 *
 * @property SET_READ_MOSTLY Data will mostly be read and only occasionally be written to
 * @property UNSET_READ_MOSTLY Undo the effect of SET_READ_MOSTLY
 * @property SET_PREFERRED_LOCATION Set the preferred location for the data as the specified device
 * @property UNSET_PREFERRED_LOCATION Clear the preferred location for the data
 * @property SET_ACCESSED_BY Data will be accessed by the specified device, so prevent page faults as much as possible
 * @property UNSET_ACCESSED_BY Let the Unified Memory subsystem decide on the page faulting policy for the specified device
 */
enum class MemAdvise(val num : Int) {
    SET_READ_MOSTLY(1),
    UNSET_READ_MOSTLY(2),
    SET_PREFERRED_LOCATION(3),
    UNSET_PREFERRED_LOCATION(4),
    SET_ACCESSED_BY(5),
    UNSET_ACCESSED_BY(6)
}