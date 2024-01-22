package kuda.driverapi.prop

/**
 *
 * Library options to be specified with cuLibraryLoadData() or cuLibraryLoadFromFile()
 *
 * @property HOST_UNIVERSAL_FUNCTION_AND_DATA_TABLE GPU thread stack size
 * @property BINARY_IS_PRESERVED Specifies that the argument code passed to cuLibraryLoadData() will be preserved. Specifying this option will let the driver know that code can be accessed at any point until cuLibraryUnload(). The default behavior is for the driver to allocate and maintain its own copy of code. Note that this is only a memory usage optimization hint and the driver can choose to ignore it if required. Specifying this option with cuLibraryLoadFromFile() is invalid and will return CUDA_ERROR_INVALID_VALUE.
 */
enum class LibraryOption(val num : Int) {
    HOST_UNIVERSAL_FUNCTION_AND_DATA_TABLE(0),
    BINARY_IS_PRESERVED(1),
    //NUM_OPTIONS
}