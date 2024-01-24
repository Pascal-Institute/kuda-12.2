package kuda.driverapi.prop

/**
 * Compute Modes (CUcomputemode)
 *
 * @property
 * @property
 * @property
 */
enum class ComputeMode(val num : Int) {
    DEFAULT(0),
    PROHIBITED(2),
    EXCLUSIVE_PROCESS(3)
}