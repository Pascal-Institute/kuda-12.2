package kuda.runtimeapi.prop

/**
 * @property DEVICE Location is a device location, thus id is a device ordinal
 * @property HOST Location is host, id is ignored
 * @property HOST_NUMA Location is a host NUMA node, thus id is a host NUMA node id
 * @property HOST_NUMA_CURRENT Location is the host NUMA node closest to the current thread's CPU, id is ignored
 */

enum class MemLocationType(val num : Int) {
    INVALID(0),
    DEVICE(1),
    HOST(2),
    HOST_NUMA(3),
    HOST_NUMA_CURRENT(4)
}