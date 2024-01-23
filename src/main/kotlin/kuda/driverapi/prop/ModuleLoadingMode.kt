package kuda.driverapi.prop

/**
 *
 * CUDA Lazy Loading status (CUDA Lazy Loading status)
 *
 * @property EAGER_LOADING Lazy Kernel Loading is not enabled
 * @property LAZY_LOADING Lazy Kernel Loading is enabled
 */
enum class ModuleLoadingMode(val num: Int) {
    EAGER_LOADING(0x1),
    LAZY_LOADING(0x2)
}