package kuda.driverapi.prop

/**
 *
 * Defines the allocation types available
 *
 * @property INVALID
 * @property PINNED This allocation type is 'pinned', i.e. cannot migrate from its current location while the application is actively using it
 * @property MAX
 */
enum class MemAllocationType(val num : Int) {
    INVALID(0x0),
    PINNED(0x1),
    MAX(0x7FFFFFFF)
}