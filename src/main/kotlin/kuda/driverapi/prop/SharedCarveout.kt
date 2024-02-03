package kuda.driverapi.prop

/**
 * Shared memory carveout configurations. These may be passed to cuFuncSetAttribute or cuKernelSetAttribute (CUshared_carveout)
 *
 * @property DEFAULT No preference for shared memory or L1 (default)
 * @property MAX_SHARED Prefer maximum available shared memory, minimum L1 cache
 * @property MAX_L1 Prefer maximum available L1 cache, minimum shared memory
 */
enum class SharedCarveout(val num : Int) {
    DEFAULT(-1),
    MAX_SHARED(100),
    MAX_L1(0)
}