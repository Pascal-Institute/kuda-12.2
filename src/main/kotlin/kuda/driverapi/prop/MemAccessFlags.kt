package kuda.driverapi.prop

/**
 *
 * Specifies the memory protection flags for mapping.
 *
 * @property PROT_NONE Default, make the address range not accessible
 * @property PROT_READ Make the address range read accessible
 * @property PROT_READWRITE Make the address range read-write accessible
 * @property PROT_MAX
 */
enum class MemAccessFlags(val num : Int) {

    PROT_NONE(0x0),
    PROT_READ(0x1),
    PROT_READWRITE(0x3),
    PROT_MAX(0x7FFFFFFF)

}