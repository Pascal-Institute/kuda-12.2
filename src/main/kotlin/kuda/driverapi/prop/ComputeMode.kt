package kuda.driverapi.prop

/**
 * Compute Modes (CUcomputemode)
 *
 * @property DEFAULT
 * @property PROHIBITED
 * @property EXCLUSIVE_PROCESS
 */
enum class ComputeMode(val num : Int) {
    DEFAULT(0),
    PROHIBITED(2),
    EXCLUSIVE_PROCESS(3)
}