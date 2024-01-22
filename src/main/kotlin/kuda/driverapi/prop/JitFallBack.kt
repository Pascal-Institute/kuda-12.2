package kuda.driverapi.prop

/**
 *
 * Cubin matching fallback strategies
 *
 * @property PREFER_PTX Prefer to compile ptx if exact binary match not found
 */
enum class JitFallBack(val num : Int) {
    PREFER_PTX(0),
    //PREFER_BINARY
}