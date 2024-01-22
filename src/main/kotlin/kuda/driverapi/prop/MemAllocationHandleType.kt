package kuda.driverapi.prop

/**
 *
 * Flags for specifying particular handle types
 *
 * @property NONE Does not allow any export mechanism. >
 * @property POSIX_FILE_DESCRIPTOR Allows a file descriptor to be used for exporting. Permitted only on POSIX systems. (int)
 * @property WIN32 Allows a Win32 NT handle to be used for exporting. (HANDLE)
 * @property WIN32_KMT Allows a Win32 KMT handle to be used for exporting. (D3DKMT_HANDLE)
 * @property FABRIC Allows a fabric handle to be used for exporting. (CUmemFabricHandle)
 * @property MAX
 */
enum class MemAllocationHandleType(val num : Int) {
    NONE(0x0),
    POSIX_FILE_DESCRIPTOR(0x1),
    WIN32(0x2),
    WIN32_KMT(0x4),
    FABRIC(0x8),
    MAX(0x7FFFFFFF)
}