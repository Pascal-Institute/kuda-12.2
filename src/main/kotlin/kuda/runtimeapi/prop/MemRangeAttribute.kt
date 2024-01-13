package kuda.runtimeapi.prop

import kuda.runtimeapi.prop.MemLocationType.*

/**
 * @property READ_MOSTLY Whether the range will mostly be read and only occassionally be written to
 * @property PREFERRED_LOCATION The preferred location of the range
 * @property ACCESSED_BY  Memory range has MemAdviseSetAccessedBy set for specified device
 * @property LAST_PREFETCH_LOCATION The last location to which the range was prefetched
 * @property PREFERRED_LOCATION_TYPE The preferred location type of the range
 * @property PREFERRED_LOCATION_ID The preferred location id of the range
 * @property LAST_PREFETCH_LOCATION_TYPE The last location type to which the range was prefetched
 * @property LAST_PREFETCH_LOCATION_ID The last location id to which the range was prefetched
 */

enum class MemRangeAttribute(val int : Int) {
    READ_MOSTLY(1),
    PREFERRED_LOCATION(2),
    ACCESSED_BY(3),
    LAST_PREFETCH_LOCATION(4),
    PREFERRED_LOCATION_TYPE(5),
    PREFERRED_LOCATION_ID(6),
    LAST_PREFETCH_LOCATION_TYPE(7),
    LAST_PREFETCH_LOCATION_ID(8),
}